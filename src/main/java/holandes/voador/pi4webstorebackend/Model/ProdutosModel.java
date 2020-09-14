/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Model;

import java.util.ArrayList;

/**
 *
 * @author DiogoSouza
 */
public class ProdutosModel {

    private int id;
    private String nome;
    private String marca;
    private String categoria;
    private double valor;
    private String descricao;
    private String palavrasChave;
    private int p;
    private int m;
    private int g;
    private int unico;
    private ArrayList<String> imagens;
    private ArrayList<FaqModel> perguntas;
    private int ativo;

    public ProdutosModel() {
    }

    public ProdutosModel(int id, String nome, String marca, String categoria, double valor, String descricao, String palavrasChave, int p, int m, int g, int unico, ArrayList<String> imagens, ArrayList<FaqModel> perguntas, int ativo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
        this.palavrasChave = palavrasChave;
        this.p = p;
        this.m = m;
        this.g = g;
        this.unico = unico;
        this.imagens = imagens;
        this.perguntas = perguntas;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getUnico() {
        return unico;
    }

    public void setUnico(int unico) {
        this.unico = unico;
    }

    public ArrayList<String> getImagens() {
        return imagens;
    }

    public void setImagens(ArrayList<String> imagens) {
        this.imagens = imagens;
    }

    public ArrayList<FaqModel> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(ArrayList<FaqModel> perguntas) {
        this.perguntas = perguntas;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

}
