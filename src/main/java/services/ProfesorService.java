/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.sun.jersey.api.core.InjectParam;
import domain.Profesor;
import domain.Ucenik;
import helper.RestHelperClass;
import javax.persistence.EntityManager;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import token.AbstractTokenCreator;
import token.Base64Token;

/**
 *
 * @author marij
 */
@Path("/profesor")
public class ProfesorService {
    
    AbstractTokenCreator tokenHelper;
    
    @InjectParam
    RestHelperClass helper;

    public ProfesorService() {
        this.tokenHelper = new Base64Token();
    }
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logIn(@HeaderParam("authorization") String authorization) {
        String[] userPass;
        EntityManager em = helper.getEntityManager();
            userPass = tokenHelper.decodeBasicAuth(authorization);
        Profesor user = (Profesor) em
                    .createNamedQuery("Profesor.findByKorisnickoIme")
                    .setParameter("korisnickoIme", userPass[0])
                    .getSingleResult();
        String pass = userPass[1];
            if (!userPass[1].equals(user.getLozinka())) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        if (user.getToken() == null || user.getToken().equals("")) {
            user.setToken(tokenHelper.createToken(user.getId()));
            helper.mergeObject(em, user);
        }
        return Response.ok().entity(user).build();
    }
    
}
