/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class Venda {

    private int id;
    private Cliente cliente;
    private String data;
    private Endereco enderecoEntrega;
    private String pagamento;
    private int desconto;
    private double total;
    private String status;
    private ArrayList<ProdutoVenda> produtos;

    public Venda() {
    }

    public Venda(Cliente cliente, String data, Endereco enderecoEntrega, String pagamento, int desconto, double total, String status, ArrayList<ProdutoVenda> produtos) {
        this.cliente = cliente;
        this.data = data;
        this.enderecoEntrega = enderecoEntrega;
        this.pagamento = pagamento;
        this.desconto = desconto;
        this.total = total;
        this.status = status;
        this.produtos = produtos;
    }

    public Venda(int id, Cliente cliente, String data, Endereco enderecoEntrega, String pagamento, int desconto, double total, String status, ArrayList<ProdutoVenda> produtos) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.enderecoEntrega = enderecoEntrega;
        this.pagamento = pagamento;
        this.desconto = desconto;
        this.total = total;
        this.status = status;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ProdutoVenda> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoVenda> produtos) {
        this.produtos = produtos;
    }

}
