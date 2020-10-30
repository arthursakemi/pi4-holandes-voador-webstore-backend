/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.Endereco;
import holandes.voador.pi4webstorebackend.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur
 */
public class EnderecoDAO {

    public static Endereco addEnderecoEntrega(int idCliente, Endereco endereco) {
        Connection conexao;
        ResultSet rs;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement statement = conexao.prepareStatement(
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

            statement = conexao.prepareStatement(
                    "INSERT INTO enderecos_entrega "
                    + "(id_cliente, id_endereco) "
                    + "VALUES(?, ?);");

            statement.setInt(1, idCliente);
            statement.setInt(2, idEndereco);
            statement.executeUpdate();

            statement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            GerenciadorConexao.fecharConexao();
        }

        return endereco;
    }

    public static Endereco getEnderecoById(int idEndereco) {
        Connection conexao;
        PreparedStatement statement;
        Endereco endereco = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            statement = conexao.prepareStatement("SELECT * FROM enderecos WHERE id = ?;");
            statement.setInt(1, idEndereco);

            ResultSet rsEndereco = statement.executeQuery();
            if (rsEndereco.next()) {
                int id = rsEndereco.getInt("id");
                String cep = rsEndereco.getString("cep");
                String rua = rsEndereco.getString("endereco");
                int numero = rsEndereco.getInt("numero");
                String complemento = rsEndereco.getString("complemento");
                String cidade = rsEndereco.getString("cidade");
                String uf = rsEndereco.getString("uf");
                String bairro = rsEndereco.getString("bairro");
                endereco = new Endereco(id, cep, rua, numero, complemento, cidade, uf, bairro);
            }
            statement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Endereco.class.getName()).log(Level.SEVERE, null, ex);
            endereco = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return endereco;
    }

    public static Endereco updateEndereco(int idEndereco, Endereco endereco) {
        Connection conexao;
        String query = "UPDATE enderecos "
                + "SET cep = ?, endereco = ?, numero = ?, complemento = ?, cidade = ?, uf = ?, bairro = ? "
                + "WHERE id = ?;";

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setString(1, endereco.getCep());
            statement.setString(2, endereco.getEndereco());
            statement.setInt(3, endereco.getNumero());
            statement.setString(4, endereco.getComplemento());
            statement.setString(5, endereco.getCidade());
            statement.setString(6, endereco.getUf());
            statement.setString(7, endereco.getBairro());
            statement.setInt(8, idEndereco);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return getEnderecoById(idEndereco);
    }

    public static boolean deleteEndereco(int id) {
        Connection conexao;
        boolean resposta = true;

        try {
            conexao = GerenciadorConexao.abrirConexao();

            PreparedStatement deleteStatement = conexao.prepareStatement("DELETE FROM enderecos_entrega WHERE id_endereco = ?;");
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();

            deleteStatement = conexao.prepareStatement("DELETE FROM enderecos WHERE id = ?;");
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();

            deleteStatement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            resposta = false;
        } finally {
            GerenciadorConexao.fecharConexao();
        }

        return resposta;
    }

}
