/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.EnderecoDAO;
import holandes.voador.pi4webstorebackend.Model.Endereco;
import holandes.voador.pi4webstorebackend.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
 * @author Arthur
 */
@CrossOrigin
@RestController
public class EnderecoController {

    @PostMapping("/endereco/{idCliente}")
    public static Endereco addEnderecoEntrega(@PathVariable int idCliente, @RequestBody Endereco endereco) {
        return EnderecoDAO.addEnderecoEntrega(idCliente, endereco);
    }

    @GetMapping("/endereco/{id}")
    public static Endereco getEnderecoById(@PathVariable int id) {
        return EnderecoDAO.getEnderecoById(id);
    }

    @PatchMapping("/endereco/{id}")
    public static Endereco updateEndereco(@PathVariable int id, @RequestBody Endereco endereco) {
        return EnderecoDAO.updateEndereco(id, endereco);
    }

    @DeleteMapping("/endereco/{id}")
    public static boolean deleteEnderecoById(@PathVariable int id) {
        return EnderecoDAO.deleteEndereco(id);
    }
}
