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

                int idUsuario = rsUsuario.getInt("id");
                boolean ativo = rsUsuario.getBoolean("ativo");
                String nome = rsUsuario.getString("nome");
                String senha = rsUsuario.getString("senha");
                int profissao = rsUsuario.getInt("profissao");
                String email = rsUsuario.getString("email");
                String cpf = rsUsuario.getString("cpf");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);

        }
        return usuarios;
    }

    public static Usuario cadastrarUsuario(Usuario usuario) {
        boolean ok = false;
        Connection con;
        try {
            con = GerenciadorConexao.abrirConexao();
            String sql = "insert into usuarios values (default,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, usuario.isAtivo());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getProfissao());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getCpf());

            ps.execute();
            ok = true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }finally{
            GerenciadorConexao.fecharConexao();
        }
        return usuario;
        
    }
}
