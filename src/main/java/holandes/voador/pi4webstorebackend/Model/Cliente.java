/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Model;

import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class Cliente extends Usuario {

    private Endereco enderecoFaturamento;
    private ArrayList<Endereco> enderecosEntrega;

    public Cliente() {
    }

    public Cliente(Endereco enderecoFaturamento, ArrayList<Endereco> enderecosEntrega, int id, String nome, String cpf, String cargo, boolean ativo) {
        super(id, nome, cpf, cargo, ativo);
        this.enderecoFaturamento = enderecoFaturamento;
        this.enderecosEntrega = enderecosEntrega;
    }

    public Cliente(Endereco enderecoFaturamento, ArrayList<Endereco> enderecosEntrega, String nome, String cpf, String email, String senha, String cargo) {
        super(nome, cpf, email, senha, cargo);
        this.enderecoFaturamento = enderecoFaturamento;
        this.enderecosEntrega = enderecosEntrega;
    }

    public Cliente(Endereco enderecoFaturamento, ArrayList<Endereco> enderecosEntrega, int id, String nome, String cpf, String email, String senha, String cargo, boolean ativo) {
        super(id, nome, cpf, email, senha, cargo, ativo);
        this.enderecoFaturamento = enderecoFaturamento;
        this.enderecosEntrega = enderecosEntrega;
    }

    public Endereco getEnderecoFaturamento() {
        return enderecoFaturamento;
    }

    public void setEnderecoFaturamento(Endereco enderecoFaturamento) {
        this.enderecoFaturamento = enderecoFaturamento;
    }

    public ArrayList<Endereco> getEnderecosEntrega() {
        return enderecosEntrega;
    }

    public void setEnderecosEntrega(ArrayList<Endereco> enderecosEntrega) {
        this.enderecosEntrega = enderecosEntrega;
    }

}
