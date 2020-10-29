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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur
 */
public class EnderecoDAO {

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

    public static Endereco updateEndereco() {
        return new Endereco();
    }

}
