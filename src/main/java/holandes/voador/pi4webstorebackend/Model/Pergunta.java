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
public class Pergunta {

    private int id;
    private int idProduto;
    private String pergunta;
    private String resposta;

    public Pergunta() {
    }

    public Pergunta(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Pergunta(int idProduto, String pergunta, String resposta) {
        this.idProduto = idProduto;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Pergunta(int id, int idProduto, String pergunta, String resposta) {
        this.id = id;
        this.idProduto = idProduto;
        this.pergunta = pergunta;
        this.resposta = resposta;
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

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

}
