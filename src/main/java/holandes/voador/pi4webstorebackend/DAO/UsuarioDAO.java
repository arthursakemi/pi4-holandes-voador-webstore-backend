/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.Credencial;
import holandes.voador.pi4webstorebackend.Model.Usuario;
import holandes.voador.pi4webstorebackend.utils.GerenciadorConexao;
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
 * @author DiogoSouza
 */
public class UsuarioDAO {

    public static ArrayList<Usuario> getAllUsers() {
        Connection conexao = null;
        PreparedStatement statement = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            statement = conexao.prepareStatement("SELECT * FROM usuarios WHERE ativo = true;");

            ResultSet rsUsuario = statement.executeQuery();
            while (rsUsuario.next()) {

                int id = rsUsuario.getInt("id");
                String nome = rsUsuario.getString("nome");
                String cpf = rsUsuario.getString("cpf");
                String email = rsUsuario.getString("email");
                String senha = "*****";
                String cargo = rsUsuario.getString("cargo");
                boolean ativo = rsUsuario.getBoolean("ativo");

                usuarios.add(new Usuario(id, nome, cpf, email, senha, cargo, ativo));
            }
            statement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);

        }
        return usuarios;
    }

    public static Usuario cadastrarUsuario(Usuario usuario) {
        Connection con;
        ResultSet rs;

        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(usuario.getSenha(), salt);
        try {
            con = GerenciadorConexao.abrirConexao();
            String sql = "INSERT INTO usuarios (nome, cpf, email, senha, cargo, ativo) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, passwordHash);
            statement.setString(5, usuario.getCargo());
            statement.setBoolean(6, true);

            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            rs.next();

            int idUsuario = rs.getInt(1);
            usuario.setId(idUsuario);
            usuario.setAtivo(true);

            statement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            usuario = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return usuario;
    }

    public static Usuario getUserById(int idUsuario) {
        Connection conexao;
        PreparedStatement statement = null;
        Usuario usuario = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            statement = conexao.prepareStatement("SELECT * FROM usuarios WHERE id = ?;");
            statement.setInt(1, idUsuario);

            ResultSet rsUsuario = statement.executeQuery();
            if (rsUsuario.next()) {
                int id = rsUsuario.getInt("id");
                String nome = rsUsuario.getString("nome");
                String cpf = rsUsuario.getString("cpf");
                String email = rsUsuario.getString("email");
                String senha = "*****";
                String cargo = rsUsuario.getString("cargo");
                boolean ativo = rsUsuario.getBoolean("ativo");

                usuario = new Usuario(id, nome, cpf, email, senha, cargo, ativo);
            }
            statement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            usuario = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return usuario;
    }

    public static Usuario updateUser(int id, Usuario usuario) {
        Connection conexao;
        String query = "UPDATE usuarios SET nome = ?, cpf = ?, cargo = ?, ativo = ? WHERE id = ?;";

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement updateStatement = conexao.prepareStatement(query);
            updateStatement.setString(1, usuario.getNome());
            updateStatement.setString(2, usuario.getCpf());
            updateStatement.setString(3, usuario.getCargo());
            updateStatement.setBoolean(4, usuario.isAtivo());
            updateStatement.setInt(5, id);
            updateStatement.executeUpdate();
            updateStatement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return getUserById(id);
    }

    public static boolean deleteUser(int id) {
        Connection conexao;
        boolean resposta = true;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement deleteStatement = conexao.prepareStatement("UPDATE usuarios SET ativo = false WHERE id = ?;");
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

    public static boolean updateUserPassword(int id, String senha) {
        Connection conexao;
        boolean success = true;
        String query = "UPDATE usuarios SET senha = ? WHERE id = ?;";

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

    public static Usuario handleLogin(Credencial credencial) {
        Connection conexao;
        PreparedStatement statement = null;
        Usuario usuario = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            statement = conexao.prepareStatement("SELECT * FROM usuarios WHERE email = ? AND ativo = true;");
            statement.setString(1, credencial.getUsuario());

            ResultSet rsUsuario = statement.executeQuery();
            if (rsUsuario.next()) {
                int id = rsUsuario.getInt("id");
                String nome = rsUsuario.getString("nome");
                String cpf = rsUsuario.getString("cpf");
                String email = rsUsuario.getString("email");
                String senha = rsUsuario.getString("senha");
                String cargo = rsUsuario.getString("cargo");
                boolean ativo = rsUsuario.getBoolean("ativo");

                usuario = new Usuario(id, nome, cpf, email, senha, cargo, ativo);

                if (credencial.isCredentialValid(usuario.getSenha())) {
                    usuario.setSenha("****");
                } else {
                    usuario = null;
                }
            }
            statement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            usuario = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return usuario;
    }
}
