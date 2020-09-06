/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Clases.Contacto;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Yosimar
 */
public class cContactos extends postgres {

    public cContactos() throws ClassNotFoundException, SQLException {
    }
    public ArrayList<Contacto> listarContactos() throws SQLException
    {
        psPrepararSentencia=conexion.prepareStatement("select *from public.spclientesselect()");
        rs=psPrepararSentencia.executeQuery();
        ArrayList<Contacto> array = new ArrayList();
        while (rs.next()) {
            array.add(
                    new Contacto(rs.getInt("uout_id_contacto"), rs.getString("uout_nombres"),
                            rs.getString("uout_apellidos"), rs.getString("uout_correo"), 
                            rs.getString("uout_numero_movil"), rs.getString("uout_numero_fijo"),
                            rs.getString("uout_numero_trabajo")));}
        conexion.close();
        return array;
    }
    public int idultimo() throws SQLException{
        int resul=0;
        psPrepararSentencia=conexion.prepareStatement("SELECT public.spclienteultimo()");
        rs=psPrepararSentencia.executeQuery();
        while(rs.next()){
            resul=rs.getInt(1);
        }
        return resul;
    }
    public String insertarContacto(Contacto contacto) throws SQLException, ClassNotFoundException, ParseException
    {
        String resultado=null;
        psPrepararSentencia=conexion.prepareStatement("select public.spclientes(?,?,?,?,?,?,?)");
        psPrepararSentencia.setString(1, contacto.getNombres());
        psPrepararSentencia.setString(2, contacto.getApellidos());
        psPrepararSentencia.setString(3, contacto.getEmail());
        psPrepararSentencia.setString(4, contacto.getMovil());
        psPrepararSentencia.setString(5, contacto.getFijo());
        psPrepararSentencia.setString(6, contacto.getTrabajo());
        psPrepararSentencia.setInt(7, contacto.getId());
        rs=psPrepararSentencia.executeQuery();
        while(rs.next()){
            resultado=rs.getString(1);
        }
        conexion.close();
        return resultado;
    }
    public String modificarContacto(Contacto contacto) throws SQLException, ClassNotFoundException, ParseException
    {
         String resultado=null;
        psPrepararSentencia=conexion.prepareStatement("select public.spdclienteactualiza(?,?,?,?,?,?,?)");
        psPrepararSentencia.setString(1, contacto.getNombres());
        psPrepararSentencia.setString(2, contacto.getApellidos());
        psPrepararSentencia.setString(3, contacto.getEmail());
        psPrepararSentencia.setString(4, contacto.getMovil());
        psPrepararSentencia.setString(5, contacto.getFijo());
        psPrepararSentencia.setString(6, contacto.getTrabajo());
        psPrepararSentencia.setInt(7, contacto.getId());
        rs=psPrepararSentencia.executeQuery();
        while(rs.next()){
            resultado=rs.getString(1);
        }
        conexion.close();
        return resultado;
    }
    
    public String eliminarContacto(int id_contacto) throws SQLException, ClassNotFoundException, ParseException
    {
        String resultado=null;
        psPrepararSentencia=conexion.prepareStatement("select public.spclienteseliminar(?)");
        psPrepararSentencia.setInt(1, id_contacto);
        rs=psPrepararSentencia.executeQuery();
        while(rs.next()){
            resultado=rs.getString(1);
        }
        return resultado;
    }
}
