/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import dao.ServicoDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Kaique
 */
@Path("Servicos")
public class ServicosWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosWS
     */
    public ServicosWS() {
    }

    /**
     * Retrieves representation of an instance of api.ServicosWS
     * @return an instance of java.lang.String
     */
    @GET
    @Path("list")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getServicos() {
        return new Gson().toJson(new ServicoDAO().list());
    }

    /**
     * PUT method for updating or creating an instance of ServicosWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
