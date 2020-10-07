/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.UsuarioDAO;
import holandes.voador.pi4webstorebackend.Model.Credencial;
import holandes.voador.pi4webstorebackend.Model.Usuario;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DiogoSouza
 */
@CrossOrigin
@RestController
public class UsuarioController {

    @GetMapping("/usuario")
    public ArrayList<Usuario> getAllUsers() {
        return UsuarioDAO.getAllUsers();
    }

    @PostMapping("/usuario")
    public Usuario cadastroUsuario(@RequestBody Usuario usuario) {
        return UsuarioDAO.cadastrarUsuario(usuario);
    }

    @GetMapping("/usuario/{id}")
    public Usuario getUserById(@PathVariable int id) {
        return UsuarioDAO.getUserById(id);
    }

    @PatchMapping("/usuario/{id}")
    public Usuario updateUser(@PathVariable int id, @RequestBody Usuario usuario) {
        return UsuarioDAO.updateUser(id, usuario);
    }

    @PatchMapping("/usuario/{id}/senha")
    public boolean updateUserPassword(@PathVariable int id, @RequestBody Credencial credencial) {
        return UsuarioDAO.updateUserPassword(id, credencial.getSenha());
    }

    @DeleteMapping("/usuario/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return UsuarioDAO.deleteUser(id);
    }

}
