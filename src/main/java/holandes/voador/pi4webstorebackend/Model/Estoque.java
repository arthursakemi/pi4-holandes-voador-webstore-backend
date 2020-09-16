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
public class Estoque {

    private int p;
    private int m;
    private int g;
    private int unico;

    public Estoque() {
    }

    public Estoque(int p, int m, int g, int unico) {
        this.p = p;
        this.m = m;
        this.g = g;
        this.unico = unico;
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

}
