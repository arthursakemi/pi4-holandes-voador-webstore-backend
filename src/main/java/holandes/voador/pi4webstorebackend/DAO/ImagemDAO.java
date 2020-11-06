/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.Imagem;
import holandes.voador.pi4webstorebackend.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ImagemDAO {

    public static boolean deleteImage(int id) {
        Connection conexao;
        boolean resposta = true;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement deleteStatement = conexao.prepareStatement("DELETE FROM imagens WHERE id = ?;");
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

    public static Imagem addImage(Imagem newImagem) {
        Connection conexao;
        ResultSet rs;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement addStatement = conexao.prepareStatement("INSERT INTO imagens "
                    + "(id_produto, imagem) "
                    + "VALUES (?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            addStatement.setInt(1, newImagem.getIdProduto());
            addStatement.setString(2, newImagem.getImagem());
            addStatement.executeUpdate();

            rs = addStatement.getGeneratedKeys();
            rs.next();

            newImagem.setId(rs.getInt(1));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            GerenciadorConexao.fecharConexao();
        }

        return newImagem;
    }

    public static ArrayList<Imagem> getImagensByProductId(Connection conexao, int idProduto) throws SQLException {
        ResultSet rs;
        ArrayList<Imagem> imagens = new ArrayList<>();

        PreparedStatement imagensStatement = conexao.prepareStatement("SELECT * FROM imagens WHERE id_produto = ?;");
        imagensStatement.setInt(1, idProduto);

        rs = imagensStatement.executeQuery();

        while (rs.next()) {
            int idImagem = rs.getInt("id");
            String imagem = rs.getString("imagem");
            imagens.add(new Imagem(idImagem, idProduto, imagem));
        }
        return imagens;
    }
}
