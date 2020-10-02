/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.Pergunta;
import holandes.voador.pi4webstorebackend.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Arthur
 */
public class PerguntaDAO {

    public static boolean deletePergunta(int id) {
        Connection conexao;
        boolean resposta = true;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement deleteStatement = conexao.prepareStatement("DELETE FROM perguntas WHERE id = ?;");
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

    public static Pergunta addPergunta(Pergunta newPergunta) {
        Connection conexao;
        ResultSet rs;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            PreparedStatement addStatement = conexao.prepareStatement("INSERT INTO perguntas "
                    + "(id_produto, pergunta, resposta) "
                    + "VALUES (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            addStatement.setInt(1, newPergunta.getIdProduto());
            addStatement.setString(2, newPergunta.getPergunta());
            addStatement.setString(3, newPergunta.getResposta());
            addStatement.executeUpdate();

            rs = addStatement.getGeneratedKeys();
            rs.next();

            newPergunta.setId(rs.getInt(1));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            GerenciadorConexao.fecharConexao();
        }

        return newPergunta;
    }
}
