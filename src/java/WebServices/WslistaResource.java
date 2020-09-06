/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Constructor.consContacto;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Yosimar
 */
@Path("wslista")
public class WslistaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WslistaResource
     */
    public WslistaResource() {
    }

    /**
     * Retrieves representation of an instance of WebServices.WslistaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        Map<String, ?> config = null;
        //TODO return proper representation object
        JsonBuilderFactory factory= Json.createBuilderFactory(config);
        Constructor.consContacto consP= new consContacto();
        consP.listar_Contactos();
        
               
        JsonArrayBuilder personas = Json.createArrayBuilder();
        JsonObject jsonObject=null;
        try{
            for (int i = 0; i < consP.array.size(); i++) {
                personas.add( Json.createObjectBuilder()
                        .add("id_contacto", consP.array.get(i).getId())
                        .add("nombres", consP.array.get(i).getNombres())
                        .add("apellidos", consP.array.get(i).getApellidos())
                        .add("email", consP.array.get(i).getEmail())
                        .add("numeros", Json.createObjectBuilder().
                                add("movil",consP.array.get(i).getMovil())
                                .add("fijo",consP.array.get(i).getFijo())
                                .add("trabajo",consP.array.get(i).getTrabajo())));
            }
            jsonObject = factory.createObjectBuilder()
                .add("result",personas).build();
        }
        catch(Exception ex)
        {
            jsonObject = factory.createObjectBuilder()
                .add("result",ex.getMessage()).build();
        }
               
        return Response.ok(jsonObject.toString())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content.Type, Accept, X-Requested-With").build();
    }

    /**
     * PUT method for updating or creating an instance of WslistaResource
     * @param content representation for the resource
     * @return 
     */
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
         Map<String, ?> config = null;
        //TODO return proper representation object
        JsonBuilderFactory factory= Json.createBuilderFactory(config);
        Constructor.consContacto consP= new consContacto();
        consP.listar_Contactos();
        
               
        JsonArrayBuilder personas = Json.createArrayBuilder();
        JsonObject jsonObject=null;
        try{
            for (int i = 0; i < consP.array.size(); i++) {
                personas.add( Json.createObjectBuilder()
                        .add("id_contacto", consP.array.get(i).getId())
                        .add("nombres", consP.array.get(i).getNombres())
                        .add("apellidos", consP.array.get(i).getApellidos())
                        .add("email", consP.array.get(i).getEmail())
                        .add("numeros", Json.createObjectBuilder().
                                add("movil",consP.array.get(i).getMovil())
                                .add("fijo",consP.array.get(i).getFijo())
                                .add("trabajo",consP.array.get(i).getTrabajo())));
            }
            jsonObject = factory.createObjectBuilder()
                .add("result",personas).build();
        }
        catch(Exception ex)
        {
            jsonObject = factory.createObjectBuilder()
                .add("result",ex.getMessage()).build();
        }
        
        
        
        
        return Response.ok(jsonObject.toString())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content.Type, Accept, X-Requested-With").build();
    }
}
