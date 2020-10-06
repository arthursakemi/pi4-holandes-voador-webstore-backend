/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

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

/**
 *
 * @author DiogoSouza
 */
public class UsuarioDAO {

    public static ArrayList<Usuario> getAllUsers() {
        Connection conexao = null;
        PreparedStatement usuarioStatement = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            usuarioStatement = conexao.prepareStatement("SELECT * FROM usuarios WHERE ativo = true;");

            ResultSet rsUsuario = usuarioStatement.executeQuery();
            while (rsUsuario.next()) {

                int id = rsUsuario.getInt("id");
                String nome = rsUsuario.getString("nome");
                String cpf = rsUsuario.getString("cpf");
                String email = rsUsuario.getString("email");
                String senha = rsUsuario.getString("senha");
                String cargo = rsUsuario.getString("cargo");
                boolean ativo = rsUsuario.getBoolean("ativo");

                usuarios.add(new Usuario(id, nome, cpf, email, senha, cargo, ativo));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);

        }
        return usuarios;
    }

    public static Usuario cadastrarUsuario(Usuario usuario) {
        Connection con;
        ResultSet rs;
        try {
            con = GerenciadorConexao.abrirConexao();
            String sql = "INSERT INTO usuarios (nome, cpf, email, senha, cargo, ativo) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getSenha());
            statement.setString(5, usuario.getCargo());
            statement.setBoolean(6, true);

            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            rs.next();

            int idUsuario = rs.getInt(1);
            usuario.setId(idUsuario);
            usuario.setAtivo(true);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            usuario = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return usuario;
    }

    //TODO
    public static Usuario getUserById(int id) {
        return new Usuario();
    }

    //TODO
    public static Usuario updateUser(int id, Usuario usuario) {
        return new Usuario();
    }

    //TODO
    public static boolean deleteUser(int id) {
        return true;
    }
}
