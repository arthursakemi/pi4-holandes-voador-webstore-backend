/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.EstoqueDAO;
import holandes.voador.pi4webstorebackend.Model.Estoque;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arthur
 */
@CrossOrigin
@RestController
public class EstoqueController {

    @PatchMapping("estoque/{idProduto}")
    public static boolean atualizarEstoque(@PathVariable int idProduto, @RequestBody Estoque estoque) {
        return EstoqueDAO.updateEstoque(idProduto, estoque);
    }
}
