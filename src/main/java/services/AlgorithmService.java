/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.sun.jersey.api.core.InjectParam;
import domain.Ucenik;
import helper.RestHelperClass;
import javax.persistence.EntityManager;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import search.RecommendationAlgorithm;
import token.AbstractTokenCreator;
import token.Base64Token;

/**
 *
 * @author marij
 */
@Path("alg")
public class AlgorithmService {
    
    AbstractTokenCreator tokenHelper;
    
    @InjectParam
    RestHelperClass helper;

    public AlgorithmService(AbstractTokenCreator tokenHelper) {
        this.tokenHelper = new Base64Token();
    }
    
    @POST
    @Path("/a")
    public Response algSer(@HeaderParam("authorization") String token) {
        EntityManager em = helper.getEntityManager();
        RecommendationAlgorithm r = new RecommendationAlgorithm(null);
        return Response.ok().build();
    }
    
}
