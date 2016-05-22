/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import domain.Skole;
/**
 *
 * @author marij
 */
public class SchoolDAO {
    @SuppressWarnings("unchecked")
	public List<Skole> getSchools(int page, int limit, String sort, String q) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		
		String queryString = "SELECT s " +
							 "FROM Skola s ";
		
		if (q != null && !q.isEmpty()) {
			queryString += "WHERE s.ssSmerId = :ssSmerId";
		}
			
		
		Query query = session.createQuery(queryString);
		
		List<Skole> all = query
				.setFirstResult((page - 1) * limit)
				.setMaxResults(limit)
				.list();

		session.close();

		return all;
	}
        
        
}
