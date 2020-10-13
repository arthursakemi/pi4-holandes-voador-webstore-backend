/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.Controllers;

import holandes.voador.pi4webstorebackend.DAO.UsuarioDAO;
import holandes.voador.pi4webstorebackend.Model.Credencial;
import holandes.voador.pi4webstorebackend.Model.JwtToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arthur
 */
@CrossOrigin
@RestController
public class LoginController {

    @PostMapping("/login")
    public JwtToken handleLogin(@RequestBody Credencial credencial) {
        return UsuarioDAO.handleLogin(credencial);
    }

}
