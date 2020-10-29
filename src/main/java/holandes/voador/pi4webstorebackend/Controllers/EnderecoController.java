/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.EnderecoDAO;
import holandes.voador.pi4webstorebackend.Model.Endereco;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arthur
 */
@CrossOrigin
@RestController
public class EnderecoController {

    @GetMapping("/endereco/{id}")
    public static Endereco getEnderecoById(@PathVariable int id) {
        return EnderecoDAO.getEnderecoById(id);
    }
}
