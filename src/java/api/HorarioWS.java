/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import bean.Horario;
import com.google.gson.Gson;
import dao.HorarioDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Kaique
 */
@Path("Horario")
public class HorarioWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HorarioWS
     */
    public HorarioWS() {
    }

    /**
     * Retrieves representation of an instance of api.HorarioWS
     * @return an instance of java.lang.String
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHorarios() {
        return new Gson().toJson(new HorarioDAO().list());
    }
    
    @GET
    @Path("nextHorario/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNextHorario(@PathParam("date") String horario){
        return new Gson().toJson(new HorarioDAO().getNextHorario(horario));
    }
    
    @POST
    @Path("insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertHorario(Horario h){
        if (new HorarioDAO().save(h)){
            return "{\"response\":\"Success\"}";
        }
        return "{\"response\":\"Fail\"}";
    }

    /**
     * PUT method for updating or creating an instance of HorarioWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
