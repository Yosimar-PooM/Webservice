/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Clases.Contacto;
import Constructor.consContacto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yosimar
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        postgres pos = new postgres();
        cContactos s = new cContactos();
        ArrayList<Contacto> array = new ArrayList<>();
        array =s.listarContactos();
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).getId());
        }
        
        
//        pos.conexion();
    }
    
}
