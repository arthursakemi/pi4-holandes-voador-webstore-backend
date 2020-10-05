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
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    //Verificar se é melhor salvar profissao no banco por String ou por numero, ex: 1 == Admin
    private int profissao;
    private String email;
    private String cpf;
    private boolean ativo;

    public Usuario(int id, String nome, String senha, int profissao, String email, String cpf, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.profissao = profissao;
        this.email = email;
        this.cpf = cpf;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getProfissao() {
        return profissao;
    }

    public void setProfissao(int profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
