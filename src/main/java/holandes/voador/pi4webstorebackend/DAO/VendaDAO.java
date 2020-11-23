/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.Produto;
import holandes.voador.pi4webstorebackend.Model.ProdutoVenda;
import holandes.voador.pi4webstorebackend.Model.Venda;
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
 * @author Arthur
 */
public class VendaDAO {

    public static ArrayList<Venda> getAllVendas() {
        Connection conexao;
        PreparedStatement stmt;
        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            stmt = conexao.prepareStatement("SELECT * FROM vendas ORDER BY data_venda DESC;");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                int idVenda = rs.getInt("id");

                venda.setId(idVenda);
                venda.setData(rs.getString("data_venda"));
                venda.setEnderecoEntrega(EnderecoDAO.getEnderecoFromDB(conexao, rs.getInt("id_endereco")));
                venda.setPagamento(rs.getString("pagamento"));
                venda.setDesconto(rs.getInt("desconto"));
                venda.setFrete(rs.getDouble("frete"));
                venda.setTotal(rs.getDouble("total"));
                venda.setStatus(rs.getString("status"));

                venda.setCliente(ClienteDAO.getBasicClientInfo(conexao, rs.getInt("id_cliente")));
                venda.setProdutos(getProdutosBySaleId(conexao, idVenda));

                vendas.add(venda);
            }
            stmt.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return vendas;
    }

    public static ArrayList<Venda> getVendasByClient(int clientId) {
        Connection conexao;
        PreparedStatement stmt;
        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            stmt = conexao.prepareStatement("SELECT * FROM vendas WHERE id_cliente = ? ORDER BY data_venda DESC;");
            stmt.setInt(1, clientId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                int idVenda = rs.getInt("id");

                venda.setId(idVenda);
                venda.setData(rs.getString("data_venda"));
                venda.setEnderecoEntrega(EnderecoDAO.getEnderecoFromDB(conexao, rs.getInt("id_endereco")));
                venda.setPagamento(rs.getString("pagamento"));
                venda.setDesconto(rs.getInt("desconto"));
                venda.setFrete(rs.getDouble("frete"));
                venda.setTotal(rs.getDouble("total"));
                venda.setStatus(rs.getString("status"));

                venda.setProdutos(getProdutosBySaleId(conexao, idVenda));

                vendas.add(venda);
            }
            stmt.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return vendas;
    }

    private static ArrayList<ProdutoVenda> getProdutosBySaleId(Connection conexao, int idVenda) throws SQLException {
        ArrayList<ProdutoVenda> produtos = new ArrayList<>();
        PreparedStatement statement;

        statement = conexao.prepareStatement(
                "SELECT id_produto, nome, marca, categoria, valor ,tamanho, quantidade FROM venda_produto "
                + "INNER JOIN produtos ON id_produto = produtos.id "
                + "WHERE id_venda = ?;");
        statement.setInt(1, idVenda);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            ProdutoVenda produtoVenda = new ProdutoVenda();
            int idProduto = rs.getInt("id_produto");

            produto.setId(idProduto);
            produto.setNome(rs.getString("nome"));
            produto.setMarca(rs.getString("marca"));
            produto.setCategoria(rs.getString("categoria"));
            produto.setValor(rs.getDouble("valor"));
            produto.setImagens(ImagemDAO.getImagensByProductId(conexao, idProduto));

            produtoVenda.setProduto(produto);
            produtoVenda.setTamanho(rs.getString("tamanho"));
            produtoVenda.setQuantidade(rs.getInt("quantidade"));

            produtos.add(produtoVenda);
        }
        statement.close();
        return produtos;
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
                + "(id_cliente, id_endereco, data_venda, pagamento, desconto, frete, total, status) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);",
                Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, venda.getCliente().getId());
        statement.setInt(2, venda.getEnderecoEntrega().getId());
        statement.setString(3, venda.getData());
        statement.setString(4, venda.getPagamento());
        statement.setInt(5, venda.getDesconto());
        statement.setDouble(6, venda.getFrete());
        statement.setDouble(7, venda.getTotal());
        statement.setString(8, venda.getStatus());
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

    public static boolean atualizarStatusVenda(int idVenda, String status) {
        Connection conexao;
        PreparedStatement statement;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            statement = conexao.prepareStatement("UPDATE vendas SET status = ? WHERE id = ?;");
            statement.setString(1, status);
            statement.setInt(2, idVenda);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            GerenciadorConexao.fecharConexao();
        }

        return true;
    }
}
