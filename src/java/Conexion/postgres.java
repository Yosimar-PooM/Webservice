/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yosimar
 */
public class postgres {
    public String driver = "org.postgresql.Driver";
    public Statement sentencias;
    PreparedStatement psPrepararSentencia;
    public Connection conexion;
    public ResultSet rs;
    
    public postgres() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        String url="jdbc:postgresql://192.168.1.50:5433/ejemplo";
        conexion = DriverManager.getConnection(url, "postgres", "12345");
        sentencias = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        System.out.println("La conexión se realizo sin problemas!");
    }
//
//    void conexion() throws ClassNotFoundException, SQLException {
//         Class.forName(driver);
//        String url="jdbc:postgresql://192.168.1.50:5433/ejemplo";
//        conexion = DriverManager.getConnection(url, "postgres", "12345");
//        sentencias = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        System.out.println("La conexión se realizo sin problemas!");
//    }

}
