/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.ProdutoVenda;
import holandes.voador.pi4webstorebackend.Model.Venda;
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
public class VendaDAO {

    public static ArrayList<Venda> getVendasByClient(int clientId) {
        return new ArrayList<Venda>();
    }

    public static Venda addVenda(Venda venda) {
        Connection conexao;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            conexao.setAutoCommit(false);

            cadastrarVenda(venda, conexao);
            cadastrarProdutosVenda(venda, conexao);

            conexao.setAutoCommit(true);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            venda = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return venda;
    }

    public static void cadastrarVenda(Venda venda, Connection conexao) throws SQLException {
        PreparedStatement statement;
        ResultSet rs;

        statement = conexao.prepareStatement(
                "INSERT INTO vendas "
                + "(id_cliente, id_endereco, data_venda, pagamento, desconto, total, status) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?);",
                Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, venda.getCliente().getId());
        statement.setInt(2, venda.getEnderecoEntrega().getId());
        statement.setString(3, venda.getData());
        statement.setString(4, venda.getPagamento());
        statement.setInt(5, venda.getDesconto());
        statement.setDouble(6, venda.getTotal());
        statement.setString(7, venda.getStatus());
        statement.executeUpdate();

        rs = statement.getGeneratedKeys();
        rs.next();

        int idVenda = rs.getInt(1);
        venda.setId(idVenda);
        statement.close();
    }

    public static void cadastrarProdutosVenda(Venda venda, Connection conexao) throws SQLException {
        PreparedStatement statement = null;

        ArrayList<ProdutoVenda> produtos = venda.getProdutos();

        for (ProdutoVenda produto : produtos) {
            statement = conexao.prepareStatement(
                    "INSERT INTO venda_produto "
                    + "(id_venda, id_produto, quantidade, tamanho) "
                    + "VALUES(?, ?, ?, ?);");

            statement.setInt(1, venda.getId());
            statement.setInt(2, produto.getProduto().getId());
            statement.setInt(3, produto.getQuantidade());
            statement.setString(4, produto.getTamanho());
            statement.executeUpdate();

            atualizarEstoque(produto, conexao);
        }
        statement.close();
    }

    public static void atualizarEstoque(ProdutoVenda produto, Connection conexao) throws SQLException {
        PreparedStatement statement;

        String tamanho = produto.getTamanho();
        statement = conexao.prepareStatement(
                "UPDATE produtos "
                + "SET " + tamanho + " = " + tamanho + " - ? "
                + "WHERE id = ?;");

        statement.setInt(1, produto.getQuantidade());
        statement.setInt(2, produto.getProduto().getId());
        statement.executeUpdate();

        statement.close();
    }
}
