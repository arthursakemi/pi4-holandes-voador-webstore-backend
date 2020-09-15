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
public class Imagem {

    private int id;
    private int idProduto;
    private String imagem;

    public Imagem() {
    }

    public Imagem(String imagem) {
        this.imagem = imagem;
    }

    public Imagem(int idProduto, String imagem) {
        this.idProduto = idProduto;
        this.imagem = imagem;
    }

    public Imagem(int id, int idProduto, String imagem) {
        this.id = id;
        this.idProduto = idProduto;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
