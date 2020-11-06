/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.VendaDAO;
import holandes.voador.pi4webstorebackend.Model.Venda;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class VendaController {

    @GetMapping("/venda/{clientId}")
    public static ArrayList<Venda> getVendasByClient(@PathVariable int clientId) {
        return VendaDAO.getVendasByClient(clientId);
    }

    @PostMapping("/venda")
    public static Venda cadastroVenda(@RequestBody Venda venda) {
        return VendaDAO.addVenda(venda);
    }
}
