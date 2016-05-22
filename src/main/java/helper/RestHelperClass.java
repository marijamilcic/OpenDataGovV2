/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import token.AbstractTokenCreator;
import token.Base64Token;

/**
 *
 * @author lazar
 */
public class RestHelperClass {

    AbstractTokenCreator tokenHelper;

    public AbstractTokenCreator getAbstractToken() {
        return tokenHelper;
    }

    public RestHelperClass() {
        tokenHelper = new Base64Token();
    }

    public EntityManager getEntityManager() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rs.htec.cms_CMS_Bulima_war_1.0PU");
//        EntityManager ecm = emf.createEntityManager();
//        return ecm;
        return EMF.createEntityManager();
    }

    public void persistObject(EntityManager em, Object o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    public void removeObject(EntityManager em, Object o, Long id) {
        if (o == null) {
            throw new RuntimeException("News at index: " + id + " does not exits");
        }
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
    }

    public void mergeObject(EntityManager em, Object o) {
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
    }

    public String trimAll(String string) {
        string = string.replaceAll("\t", "");
        string = string.replaceAll("\n", "");
//        string = string.replaceAll(" ", "");
        return string;
    }
}