/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Constructor.consContacto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Yosimar
 */
@WebService(serviceName = "wscontactos")
public class wscontactos {

    /**
     * This is a sample web service operation
     * @param nombre
     * @param apellido
     * @param email
     * @param movil
     * @param fijo
     * @param trabajo
     * @return 
     */
    @WebMethod(operationName = "insertarContacto")
    public String insertarContacto(@WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "email") String email,
            @WebParam(name = "movil") String movil,
            @WebParam(name = "fijo") String fijo,
            @WebParam(name = "trabajo") String trabajo) {
        Constructor.consContacto constructor=new consContacto();
        return constructor.insertarContacto(nombre, apellido, email, movil, fijo, trabajo);
        
    }
}
