/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.PerguntaDAO;
import holandes.voador.pi4webstorebackend.Model.Pergunta;
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
public class PerguntasController {

    @DeleteMapping("/pergunta/{id}")
    public static boolean deletePergunta(@PathVariable int id) {
        return PerguntaDAO.deletePergunta(id);
    }

    @PostMapping("/pergunta")
    public static boolean addPergunta(@RequestBody Pergunta pergunta) {
        return PerguntaDAO.addPergunta(pergunta);
    }
}
