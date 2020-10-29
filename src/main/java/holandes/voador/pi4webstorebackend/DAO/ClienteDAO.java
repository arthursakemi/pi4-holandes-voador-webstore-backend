/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.Cliente;
import holandes.voador.pi4webstorebackend.Model.Credencial;
import holandes.voador.pi4webstorebackend.Model.Endereco;
import holandes.voador.pi4webstorebackend.Model.JwtToken;
import holandes.voador.pi4webstorebackend.Model.Usuario;
import holandes.voador.pi4webstorebackend.utils.GerenciadorConexao;
import holandes.voador.pi4webstorebackend.utils.JwtUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Arthur
 */
public class ClienteDAO {

    public static Cliente getClienteById(int idCliente) {
        Connection conexao;
        PreparedStatement stmtCliente, stmtEndereco, stmtEnderecosEntrega;
        Cliente cliente = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            stmtCliente = conexao.prepareStatement("SELECT * FROM clientes WHERE id = ?;");
            stmtCliente.setInt(1, idCliente);

            ResultSet rsCliente = stmtCliente.executeQuery();

            rsCliente.next();
            String nome = rsCliente.getString("nome");
            String cpf = rsCliente.getString("cpf");
            String email = rsCliente.getString("email");
            String senha = "****";
            String cargo = rsCliente.getString("cargo");
            int idEndereco = rsCliente.getInt("id_endereco");
            boolean ativo = rsCliente.getBoolean("ativo");

            stmtEndereco = conexao.prepareStatement("SELECT * FROM enderecos WHERE id = ?");
            stmtEndereco.setInt(1, idEndereco);

            ResultSet rsEndereco = stmtEndereco.executeQuery();

            rsEndereco.next();
            int id = rsEndereco.getInt("id");
            String cep = rsEndereco.getString("cep");
            String endereco = rsEndereco.getString("endereco");
            int numero = rsEndereco.getInt("numero");
            String complemento = rsEndereco.getString("complemento");
            String cidade = rsEndereco.getString("cidade");
            String uf = rsEndereco.getString("uf");
            String bairro = rsEndereco.getString("bairro");
            Endereco enderecoFaturamento = new Endereco(id, cep, endereco, numero, complemento, cidade, uf, bairro);

            stmtEnderecosEntrega = conexao.prepareStatement(
                    "SELECT id_endereco, cep, endereco, numero, complemento FROM enderecos_entrega "
                    + "INNER JOIN enderecos ON id_endereco = enderecos.id "
                    + "WHERE id_cliente = ?;");
            stmtEnderecosEntrega.setInt(1, idCliente);

            ResultSet rsEnderecosEntrega = stmtEnderecosEntrega.executeQuery();

            ArrayList<Endereco> enderecosEntrega = new ArrayList<>();
            while (rsEnderecosEntrega.next()) {
                int idEnderecoEntrega = rsEnderecosEntrega.getInt("id_endereco");
                String cepEntrega = rsEnderecosEntrega.getString("cep");
                String enderecoEntrega = rsEnderecosEntrega.getString("endereco");
                int numeroEntrega = rsEnderecosEntrega.getInt("numero");
                String complementoEntrega = rsEnderecosEntrega.getString("complemento");
                String cidadeEntrega = rsEndereco.getString("cidade");
                String ufEntrega = rsEndereco.getString("uf");
                String bairroEntrega = rsEndereco.getString("bairro");

                enderecosEntrega.add(new Endereco(idEnderecoEntrega, cepEntrega, enderecoEntrega, numeroEntrega, complementoEntrega, cidadeEntrega, ufEntrega, bairroEntrega));
            }

            cliente = new Cliente(enderecoFaturamento, enderecosEntrega, idCliente, nome, cpf, email, senha, cargo, ativo);
            stmtCliente.close();
            stmtEndereco.close();
            stmtEnderecosEntrega.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            cliente = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }

        return cliente;
    }

    public static Cliente cadastrarCliente(Cliente newCliente) {
        Connection conexao;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            conexao.setAutoCommit(false);

            cadastrarEnderecoDeFaturamento(newCliente, conexao);
            cadastrarDadosDoCliente(newCliente, conexao);
            cadastrarEnderecosDeEntrega(newCliente, conexao);

            conexao.setAutoCommit(true);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            newCliente = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return newCliente;
    }

    private static void cadastrarEnderecoDeFaturamento(Cliente newCliente, Connection conexao) throws SQLException {
        PreparedStatement statement;
        ResultSet rs;

        Endereco enderecoFaturamento = newCliente.getEnderecoFaturamento();

        statement = conexao.prepareStatement(
                "INSERT INTO enderecos "
                + "(cep, endereco, numero, complemento, cidade, uf, bairro) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?);",
                Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, enderecoFaturamento.getCep());
        statement.setString(2, enderecoFaturamento.getEndereco());
        statement.setInt(3, enderecoFaturamento.getNumero());
        statement.setString(4, enderecoFaturamento.getComplemento());
        statement.setString(5, enderecoFaturamento.getCidade());
        statement.setString(6, enderecoFaturamento.getUf());
        statement.setString(7, enderecoFaturamento.getBairro());
        statement.executeUpdate();

        rs = statement.getGeneratedKeys();
        rs.next();

        int idEndereco = rs.getInt(1);
        enderecoFaturamento.setId(idEndereco);
        statement.close();
    }

    private static void cadastrarDadosDoCliente(Cliente newCliente, Connection conexao) throws SQLException {
        PreparedStatement statement;
        ResultSet rs;

        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(newCliente.getSenha(), salt);

        statement = conexao.prepareStatement(
                "INSERT INTO clientes "
                + "(nome, cpf, email, senha, cargo, id_endereco, ativo) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, newCliente.getNome());
        statement.setString(2, newCliente.getCpf());
        statement.setString(3, newCliente.getEmail());
        statement.setString(4, passwordHash);
        statement.setString(5, "cliente");
        statement.setInt(6, newCliente.getEnderecoFaturamento().getId());
        statement.setBoolean(7, true);

        statement.executeUpdate();
        rs = statement.getGeneratedKeys();
        rs.next();

        int idCliente = rs.getInt(1);
        newCliente.setId(idCliente);
        newCliente.setSenha("****");
        newCliente.setAtivo(true);

        statement.close();
    }

    private static void cadastrarEnderecosDeEntrega(Cliente newCliente, Connection conexao) throws SQLException {
        PreparedStatement statement;
        ResultSet rs;

        int idCliente = newCliente.getId();

        for (Endereco endereco : newCliente.getEnderecosEntrega()) {
            statement = conexao.prepareStatement(
                    "INSERT INTO enderecos "
                    + "(cep, endereco, numero, complemento, cidade, uf, bairro) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, endereco.getCep());
            statement.setString(2, endereco.getEndereco());
            statement.setInt(3, endereco.getNumero());
            statement.setString(4, endereco.getComplemento());
            statement.setString(5, endereco.getCidade());
            statement.setString(6, endereco.getUf());
            statement.setString(7, endereco.getBairro());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            rs.next();

            int idEndereco = rs.getInt(1);
            endereco.setId(idEndereco);
            statement.close();

            statement = conexao.prepareStatement(
                    "INSERT INTO enderecos_entrega "
                    + "(id_cliente, id_endereco) "
                    + "VALUES(?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, idCliente);
            statement.setInt(2, idEndereco);
            statement.executeUpdate();
            statement.close();
        }

    }

    public static Cliente updateCliente(int id, Cliente cliente) {
        Connection conexao;
        String query = "UPDATE clientes SET nome = ? WHERE id = ?;";

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement updateStatement = conexao.prepareStatement(query);
            updateStatement.setString(1, cliente.getNome());
            updateStatement.setInt(2, id);
            updateStatement.executeUpdate();
            updateStatement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return getClienteById(id);
    }

    public static JwtToken handleLogin(Credencial credencial) {
        Connection conexao;
        PreparedStatement statement;
        Cliente cliente;
        JwtToken jwt = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            statement = conexao.prepareStatement("SELECT * FROM clientes WHERE email = ? AND ativo = true;");
            statement.setString(1, credencial.getUsuario());

            ResultSet rsCliente = statement.executeQuery();
            if (rsCliente.next()) {
                int id = rsCliente.getInt("id");
                String nome = rsCliente.getString("nome");
                String cpf = rsCliente.getString("cpf");
                String email = rsCliente.getString("email");
                String senha = rsCliente.getString("senha");
                String cargo = rsCliente.getString("cargo");
                boolean ativo = rsCliente.getBoolean("ativo");

                cliente = new Cliente(id, nome, cpf, email, senha, cargo, ativo);

                if (credencial.isCredentialValid(cliente.getSenha())) {
                    jwt = new JwtToken(JwtUtilities.generateJWT(cliente));
                }
            }
            statement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return jwt;
    }

    public static boolean updateClientPassword(int id, String senha) {
        Connection conexao;
        boolean success = true;
        String query = "UPDATE clientes SET senha = ? WHERE id = ?;";

        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(senha, salt);

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement updateStatement = conexao.prepareStatement(query);
            updateStatement.setString(1, passwordHash);
            updateStatement.setInt(2, id);

            updateStatement.executeUpdate();
            updateStatement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            success = false;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return success;
    }
}
