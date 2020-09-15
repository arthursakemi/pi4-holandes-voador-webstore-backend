/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.DAO;

import holandes.voador.pi4webstorebackend.Model.Imagem;
import holandes.voador.pi4webstorebackend.Model.Pergunta;
import holandes.voador.pi4webstorebackend.Model.Produto;
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
public class ProdutoDAO {

    public static Produto cadastrarProduto(Produto newProduto) {
        Connection conexao;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            conexao.setAutoCommit(false);

            cadastrarProduto(newProduto, conexao);
            cadastrarPerguntas(newProduto, conexao);
            cadastrarImagens(newProduto, conexao);

            conexao.setAutoCommit(true);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            newProduto = null;
        } finally {
            GerenciadorConexao.fecharConexao();
        }
        return newProduto;
    }

    private static void cadastrarProduto(Produto newProduto, Connection conexao) throws SQLException {
        PreparedStatement statement;
        ResultSet rs;
        statement = conexao.prepareStatement("INSERT INTO produtos "
                + "(nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, newProduto.getNome());
        statement.setString(2, newProduto.getMarca());
        statement.setString(3, newProduto.getCategoria());
        statement.setDouble(4, newProduto.getValor());
        statement.setInt(5, newProduto.getP());
        statement.setInt(6, newProduto.getM());
        statement.setInt(7, newProduto.getG());
        statement.setInt(8, newProduto.getUnico());
        statement.setString(9, newProduto.getDescricao());
        statement.setString(10, newProduto.getPalavrasChave());
        statement.setBoolean(11, true);
        statement.executeUpdate();
        rs = statement.getGeneratedKeys();
        rs.next();
        int idProduto = rs.getInt(1);
        newProduto.setId(idProduto);
    }

    private static void cadastrarImagens(Produto newProduto, Connection conexao) throws SQLException {
        PreparedStatement imagensStatement;
        ResultSet rs;

        for (Imagem imagem : newProduto.getImagens()) {
            imagensStatement = conexao.prepareStatement("INSERT INTO imagens "
                    + "(id_produto, imagem) "
                    + "VALUES (?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            imagensStatement.setInt(1, newProduto.getId());
            imagensStatement.setString(2, imagem.getImagem());
            imagensStatement.executeUpdate();

            rs = imagensStatement.getGeneratedKeys();
            rs.next();

            imagem.setId(rs.getInt(1));
            imagem.setIdProduto(newProduto.getId());
        }
    }

    private static void cadastrarPerguntas(Produto newProduto, Connection conexao) throws SQLException {
        PreparedStatement faqStatement;
        ResultSet rs;

        for (Pergunta faq : newProduto.getPerguntas()) {
            faqStatement = conexao.prepareStatement("INSERT INTO perguntas "
                    + "(id_produto, pergunta, resposta) "
                    + "VALUES(?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            faqStatement.setInt(1, newProduto.getId());
            faqStatement.setString(2, faq.getPergunta());
            faqStatement.setString(3, faq.getResposta());

            faqStatement.executeUpdate();

            rs = faqStatement.getGeneratedKeys();
            rs.next();

            faq.setId(rs.getInt(1));
            faq.setIdProduto(newProduto.getId());

            faqStatement.close();
        }
    }

    public static Produto getProductById(int idProduto) {
        Connection conexao = null;
        PreparedStatement produtoStatement = null;
        PreparedStatement perguntasStatement = null;
        PreparedStatement imagensStatement = null;
        Produto produto = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            produtoStatement = conexao.prepareStatement("SELECT * FROM produtos WHERE id = ?;");
            produtoStatement.setInt(1, idProduto);

            ResultSet rs = produtoStatement.executeQuery();
            rs.next();

            String nome = rs.getString("nome");
            String marca = rs.getString("marca");
            String categoria = rs.getString("categoria");
            double valor = rs.getDouble("valor");
            int p = rs.getInt("p");
            int m = rs.getInt("m");
            int g = rs.getInt("g");
            int unico = rs.getInt("unico");
            String descricao = rs.getString("descricao");
            String palavrasChave = rs.getString("palavras_chave");
            boolean ativo = rs.getBoolean("ativo");

            perguntasStatement = conexao.prepareStatement("SELECT * FROM perguntas WHERE id_produto = ?;");
            perguntasStatement.setInt(1, idProduto);

            rs = perguntasStatement.executeQuery();

            ArrayList<Pergunta> perguntas = new ArrayList<>();

            while (rs.next()) {
                int idPergunta = rs.getInt("id");
                String pergunta = rs.getString("pergunta");
                String resposta = rs.getString("resposta");

                perguntas.add(new Pergunta(idPergunta, idProduto, pergunta, resposta));
            }

            imagensStatement = conexao.prepareStatement("SELECT * FROM imagens WHERE id_produto = ?;");
            imagensStatement.setInt(1, idProduto);

            rs = imagensStatement.executeQuery();

            ArrayList<Imagem> imagens = new ArrayList<>();

            while (rs.next()) {
                int idImagem = rs.getInt("id");
                String imagem = rs.getString("imagem");
                imagens.add(new Imagem(idImagem, idProduto, imagem));
            }
            produto = new Produto(idProduto, nome, marca, categoria, valor, descricao, palavrasChave, p, m, g, unico, imagens, perguntas, ativo);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (produtoStatement != null) {
                    produtoStatement.close();
                }
                if (perguntasStatement != null) {
                    perguntasStatement.close();
                }
                if (imagensStatement != null) {

                    imagensStatement.close();
                }
                GerenciadorConexao.fecharConexao();
            } catch (SQLException ex) {
            }
        }
        return produto;
    }

    public static ArrayList<Produto> getAllProducts() {
        Connection conexao = null;
        PreparedStatement produtoStatement = null;
        PreparedStatement perguntasStatement = null;
        PreparedStatement imagensStatement = null;
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            produtoStatement = conexao.prepareStatement("SELECT * FROM produtos WHERE ativo = true;");

            ResultSet rsProduto = produtoStatement.executeQuery();
            while (rsProduto.next()) {

                int idProduto = rsProduto.getInt("id");
                String nome = rsProduto.getString("nome");
                String marca = rsProduto.getString("marca");
                String categoria = rsProduto.getString("categoria");
                double valor = rsProduto.getDouble("valor");
                int p = rsProduto.getInt("p");
                int m = rsProduto.getInt("m");
                int g = rsProduto.getInt("g");
                int unico = rsProduto.getInt("unico");
                String descricao = rsProduto.getString("descricao");
                String palavrasChave = rsProduto.getString("palavras_chave");
                boolean ativo = rsProduto.getBoolean("ativo");

                perguntasStatement = conexao.prepareStatement("SELECT * FROM perguntas WHERE id_produto = ?;");
                perguntasStatement.setInt(1, idProduto);

                ResultSet rsPerguntas = perguntasStatement.executeQuery();

                ArrayList<Pergunta> perguntas = new ArrayList<>();

                while (rsPerguntas.next()) {
                    int idPergunta = rsPerguntas.getInt("id");
                    String pergunta = rsPerguntas.getString("pergunta");
                    String resposta = rsPerguntas.getString("resposta");

                    perguntas.add(new Pergunta(idPergunta, idProduto, pergunta, resposta));
                }

                imagensStatement = conexao.prepareStatement("SELECT * FROM imagens WHERE id_produto = ?;");
                imagensStatement.setInt(1, idProduto);

                ResultSet rsImagens = imagensStatement.executeQuery();

                ArrayList<Imagem> imagens = new ArrayList<>();

                while (rsImagens.next()) {
                    int idImagem = rsImagens.getInt("id");
                    String imagem = rsImagens.getString("imagem");
                    imagens.add(new Imagem(idImagem, idProduto, imagem));
                }
                produtos.add(new Produto(idProduto, nome, marca, categoria, valor, descricao, palavrasChave, p, m, g, unico, imagens, perguntas, ativo));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (produtoStatement != null) {
                    produtoStatement.close();
                }
                if (perguntasStatement != null) {
                    perguntasStatement.close();
                }
                if (imagensStatement != null) {

                    imagensStatement.close();
                }
                GerenciadorConexao.fecharConexao();
            } catch (SQLException ex) {
            }
        }
        return produtos;
    }
}
