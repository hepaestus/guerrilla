package org.stripesbook.quickstart.util;

import java.util.List;

import javax.persistence.Query;
 
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.ejb.HibernateEntityManager;
import org.stripesstuff.stripersist.EntityUtil;
import org.stripesstuff.stripersist.Stripersist;
 
public class DAO {

	public static Session getSession() {
		HibernateEntityManager em = (HibernateEntityManager) Stripersist.getEntityManager();
    
		return em.getSession();
	}
	
	/* Find an object by its ID */
	public static <T, K> T load(Class<T> type, K key) {
		return Stripersist.getEntityManager(type).find(type, key);
	}
  
	public static <T> Criteria createCriteria(Class<T> type, Criterion... criterions) {    
		Session session = getSession();
		Criteria criteria = session.createCriteria(type);
		
		for (Criterion criterion : criterions)
			criteria.add(criterion);
    
		return criteria;
	}
  
	@SuppressWarnings("unchecked")
	public static <T> List<T> list(Class<T> type, Criterion... criteria) {
		return createCriteria(type, criteria).list();
	}
  
	@SuppressWarnings("unchecked")
	public static <T> T unique(Class<T> type, Criterion... criteria) {
		return (T) createCriteria(type, criteria).uniqueResult();
	}
 
	/* Persists objects but you have to commit() to commit the transaction.
	 * Stripersist automatically calls rollback() when it completes so unless 
	 * you call commit() explicitly your changes will be lost.
	 */
	public static <T> T save(T entity) {
		Stripersist.getEntityManager(EntityUtil.deproxifyCglibClass(entity.getClass())).persist(entity);
    
		return entity;
	}
  
	public static void commit() {
		Stripersist.getEntityManager().getTransaction().commit();
	}
  
	public static void rollback() {
		Stripersist.getEntityManager().getTransaction().rollback();
	}
 
	public static <T> void remove(T entity) {
		Stripersist.getEntityManager(EntityUtil.deproxifyCglibClass(entity.getClass())).remove(entity);
	}
  
	public static Query createQuery(String query) {
		
		return Stripersist.getEntityManager().createQuery(query);
	}
}