/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Model;

/**
 *
 * @author DiogoSouza
 */
public class ProdutosModel {
    private double id;
    private String nome;
    private String marca;
    private String categoria;
    private double valor;
    private String descricao;
    private String [] palavrasChave;
    private int ativo;

    public ProdutosModel(double id, String nome, String marca, String categoria, double valor, String descricao, String[] palavrasChave, int ativo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
        this.palavrasChave = palavrasChave;
        this.ativo = ativo;
    }
    
    public ProdutosModel(){}

    public double getId() {
        return id;
    }

    public void setId(double id) {
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

    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
}
