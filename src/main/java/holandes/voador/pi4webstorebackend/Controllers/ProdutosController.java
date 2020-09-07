/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

/**
 *
 * @author Arthur
 */
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProdutosController {

    @GetMapping("/produtos")
    public String homeInit() {
        return "Lista de Produtos!!";
    }
    
    @PostMapping("/produtos")
    public String cadastroProduto() {
        return "Teste executado com sucesso";
    }
}
