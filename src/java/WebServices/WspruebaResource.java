/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Constructor.consContacto;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Yosimar
 */
@Path("wsprueba")
public class WspruebaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WspruebaResource
     */
    public WspruebaResource() {
    }

    /**
     * Retrieves representation of an instance of WebServices.WspruebaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        Constructor.consContacto cons= new consContacto();
        
        String nombre="Lorena",apellido="Mar",email="lore@yahoo.es",movil="123",trabajo="123",fijo="123";
    
            return cons.insertarContacto(nombre,apellido,email,movil,fijo,trabajo);
    }

    /**
     * PUT method for updating or creating an instance of WspruebaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
        
        
    }
}
