/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Model;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Arthur
 */
public class Credencial {

    private String usuario;
    private String senha;

    public Credencial() {
    }

    public Credencial(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isCredentialValid(String hash) {
        return BCrypt.checkpw(this.senha, hash);
    }

}
