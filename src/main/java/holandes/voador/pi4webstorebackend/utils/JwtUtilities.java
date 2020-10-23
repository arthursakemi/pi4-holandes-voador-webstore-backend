/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.utils;

import holandes.voador.pi4webstorebackend.Model.Cliente;
import holandes.voador.pi4webstorebackend.Model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Arthur
 */
public class JwtUtilities {

    private static Key generateJwtKey() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = Env.JWT_KEY.getBytes();

        return new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    }

    public static String generateJWT(Usuario usuario) {
        long nowMs = System.currentTimeMillis();
        Date now = new Date(nowMs);
        Date expirationDate = new Date(nowMs + 3600000);

        Key key = generateJwtKey();

        String jws = Jwts
                .builder()
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .claim("id", usuario.getId())
                .claim("nome", usuario.getNome())
                .claim("email", usuario.getEmail())
                .claim("cpf", usuario.getCpf())
                .claim("cargo", usuario.getCargo())
                .signWith(key).compact();

        return jws;
    }

    public static boolean validateJWT(String token) {
        Key key = generateJwtKey();
        try {
            // String subject1 = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().get("cargo").toString();
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        } catch (JwtException e) {
            return false;
        }

        return true;
    }

}
