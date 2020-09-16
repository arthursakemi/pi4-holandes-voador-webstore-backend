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
import holandes.voador.pi4webstorebackend.DAO.ProdutoDAO;
import holandes.voador.pi4webstorebackend.Model.Produto;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProdutosController {

    @GetMapping("/produto")
    public ArrayList<Produto> homeInit() {
        return ProdutoDAO.getAllProducts();
    }

    @PostMapping("/produto")
    public Produto cadastroProduto(@RequestBody Produto produto) {
        return ProdutoDAO.cadastrarProduto(produto);
    }

    @GetMapping("/produto/{id}")
    public Produto getProdutoById(@PathVariable int id) {
        return ProdutoDAO.getProductById(id);
    }

    @PatchMapping("/produto/{id}")
    public Produto updateProduto(@PathVariable int id, @RequestBody Produto produto) {
        return ProdutoDAO.updateProduto(id, produto);
    }

    @DeleteMapping("/produto/{id}")
    public boolean deleteProduto(@PathVariable int id) {
        return ProdutoDAO.deleteProduct(id);
    }
}
