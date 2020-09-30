/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holandes.voador.pi4webstorebackend.utils;

/**
 *
 * @author Arthur
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;

public class GerenciadorConexao {

    public static String STATUS = "Não conectado";

    public static Connection CONEXAO;

    public GerenciadorConexao() {

    }

    public static Connection abrirConexao() throws ClassNotFoundException, SQLException {

        String DRIVER = "com.mysql.cj.jdbc.Driver";

        String USER = Env.USER;

        String PASSWORD = Env.PASSWORD;

        String URL = Env.URL;

        if (CONEXAO == null) {
            try {
                //carrega o driver
                Class.forName(DRIVER);
                CONEXAO = DriverManager.getConnection(URL, USER, PASSWORD);

                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                } else {
                    STATUS = "Não foi possivel realizar a conexão!";
                }

            } catch (ClassNotFoundException e) {

                throw new ClassNotFoundException("O driver expecificado não foi encontrado");

            } catch (SQLException e) {

                throw new SQLException("Erro ao estabelecer conexão com o banco de dados.");
            }
        } else {
            try {
                if (CONEXAO.isClosed()) {
                    CONEXAO = DriverManager.getConnection(URL, USER, PASSWORD);
                }
            } catch (SQLException ex) {
                throw new SQLException("falha ao fechar a conexão.");
            }
        }

        return CONEXAO;
    }

    public static String getStatusConexao() {
        return STATUS;
    }

    public static boolean fecharConexao() {
        try {
            if (CONEXAO != null) {
                if (!CONEXAO.isClosed()) {
                    CONEXAO.close();
                }
            }

            STATUS = "Não conectado";
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

}
