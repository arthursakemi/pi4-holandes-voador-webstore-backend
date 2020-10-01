/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.ImagemDAO;
import holandes.voador.pi4webstorebackend.Model.Imagem;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ImagemController {

    @DeleteMapping("/imagem/{id}")
    public static boolean deleteImagem(@PathVariable int id) {
        return ImagemDAO.deleteImage(id);
    }

    @PostMapping("/imagem")
    public static boolean addImagem(@RequestBody Imagem imagem) {
        return ImagemDAO.addImage(imagem);
    }
}
