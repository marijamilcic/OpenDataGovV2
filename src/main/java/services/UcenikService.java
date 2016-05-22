/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.sun.jersey.api.core.InjectParam;
import domain.Ucenik;
import helper.RestHelperClass;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import token.AbstractTokenCreator;
import token.Base64Token;

/**
 *
 * @author marij
 */
@Path("/ucenik")
public class UcenikService {
    
    AbstractTokenCreator tokenHelper;
    
    @InjectParam
    RestHelperClass helper;

    public UcenikService() {
        this.tokenHelper = new Base64Token();
    }
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logIn(@HeaderParam("authorization") String authorization) {
        String[] userPass;
        EntityManager em = helper.getEntityManager();
            userPass = tokenHelper.decodeBasicAuth(authorization);
        Ucenik user = (Ucenik) em
                    .createNamedQuery("Ucenik.findByKorisnickoIme")
                    .setParameter("korisnickoIme", userPass[0])
                    .getSingleResult();
        String pass = userPass[1];
            if (!userPass[1].equals(user.getLozinka())) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        if (user.getToken() == null || user.getToken().equals("")) {
            user.setToken(tokenHelper.encode(tokenHelper.createToken(user.getId())));
            helper.mergeObject(em, user);
        }
        return Response.ok().entity(user).build();
    }
    
    @POST
    @Path("/logout")
    public Response logOut(@HeaderParam("authorization") String token) {
        EntityManager em = helper.getEntityManager();
        Ucenik user = em.find(Ucenik.class, Long.parseLong(tokenHelper.decode(token).split("##")[1]));
        user.setToken(null);
        helper.mergeObject(em, user);
        return Response.ok().build();
    }
    
}
