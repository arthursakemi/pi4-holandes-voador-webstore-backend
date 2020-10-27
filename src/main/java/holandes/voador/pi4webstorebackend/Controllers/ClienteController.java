/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.ClienteDAO;
import holandes.voador.pi4webstorebackend.Model.Cliente;
import holandes.voador.pi4webstorebackend.Model.Credencial;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ClienteController {

    @GetMapping("/cliente/{idCliente}")
    public static Cliente getClienteById(@PathVariable int idCliente) {
        return ClienteDAO.getClienteById(idCliente);
    }

    @PostMapping("/cliente")
    public static Cliente cadastroCliente(@RequestBody Cliente cliente) {
        return ClienteDAO.cadastrarCliente(cliente);
    }

    @PatchMapping("/cliente/{id}/senha")
    public boolean updateClientPassword(@PathVariable int id, @RequestBody Credencial credencial) {
        return ClienteDAO.updateClientPassword(id, credencial.getSenha());
    }

}
