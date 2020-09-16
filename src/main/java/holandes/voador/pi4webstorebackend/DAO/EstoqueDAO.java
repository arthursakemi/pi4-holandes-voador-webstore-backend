/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.Estoque;
import holandes.voador.pi4webstorebackend.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Arthur
 */
public class EstoqueDAO {

    public static boolean updateEstoque(int idProduto, Estoque estoque) {
        Connection conexao;
        boolean resposta = true;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement updateStatement = conexao.prepareStatement("UPDATE produtos SET p = ?, m = ?, g = ?, unico = ? WHERE id = ?;");
            updateStatement.setInt(1, estoque.getP());
            updateStatement.setInt(2, estoque.getM());
            updateStatement.setInt(3, estoque.getG());
            updateStatement.setInt(4, estoque.getUnico());
            updateStatement.setInt(5, idProduto);
            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            resposta = false;
        } finally {
            GerenciadorConexao.fecharConexao();
        }

        return resposta;
    }
}
