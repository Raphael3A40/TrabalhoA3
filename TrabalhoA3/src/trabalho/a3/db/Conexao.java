/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.a3.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mathe
 */
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/a3?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "SUA_SENHA";
    
    // pode ser assim tbm 
    // exemplo simplificado: ler de variáveis de ambiente
//private static final String USER = System.getenv("A3_DB_USER");
//private static final String PASS = System.getenv("A3_DB_PASS");


    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
