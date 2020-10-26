/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Model;

/**
 *
 * @author Arthur
 */
public class Endereco {

    private int id;
    private String cep;
    private String endereco;
    private int numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String bairro;

    public Endereco() {
    }

    public Endereco(String cep, String endereco, int numero, String cidade, String uf, String bairro) {
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
    }

    public Endereco(String cep, String endereco, int numero, String complemento, String cidade, String uf, String bairro) {
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
    }

    public Endereco(int id, String cep, String endereco, int numero, String complemento, String cidade, String uf, String bairro) {
        this.id = id;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
