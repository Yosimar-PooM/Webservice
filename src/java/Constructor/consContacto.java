/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructor;

import Clases.Contacto;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Yosimar
 */
public class consContacto {

    public Contacto contacto = new Contacto();
    public ArrayList<Contacto> array = new ArrayList<>();
    private Conexion.cContactos conexion;

    public consContacto() {
        try {
            conexion = new Conexion.cContactos();
        } catch (Exception ex) {
            conexion = null;
        }
    }
   
    public String insertarContacto( String nombre, String apellido, String email, String movil, String fijo,
            String trabajo) {
        try {
            int id_contacto = conexion.idultimo();
            String resul = conexion.insertarContacto(new Contacto(id_contacto, nombre, apellido, email, movil, fijo, trabajo));
            return resul;

        } catch (ClassNotFoundException | ParseException | SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String modificarContacto( int id, String nombre, String apellido, String email, String movil, String fijo,
            String trabajo) {
        try {
            String resul = conexion.modificarContacto(new Contacto(id, nombre, apellido, email, movil, fijo, trabajo));
            return resul;

        } catch (ClassNotFoundException | ParseException | SQLException ex) {
            return ex.getMessage();
        }
    }

    public void listar_Contactos() {
        try {
            array = conexion.listarContactos();
        } catch (SQLException e) {
            array = null;
        }
    }
    
    public String eliminarContacto(int id_contacto)
    {
        try{
           
            String resul=conexion.eliminarContacto(id_contacto);
            return resul;
        }
        catch(SQLException|ClassNotFoundException|ParseException ex)
        {
            return ex.getMessage();
        }
    }
}
