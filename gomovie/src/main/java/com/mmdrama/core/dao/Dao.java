package com.mmdrama.core.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;




public class Dao {

	

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public Dao(EntityManager em) {
		
		entityManager=em;
		
	}
	protected boolean create(Object o)
	{
		
		entityManager.getTransaction().begin();
		entityManager.persist( o );	
		entityManager.getTransaction().commit();
		//entityManager.close();
		return true;
	}
	
	public boolean update(Object o)
	{
		
		entityManager.getTransaction().begin();
		entityManager.persist(o);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	
	
	public boolean delete(Object o)
	{
		
		entityManager.getTransaction().begin();
		entityManager.remove(o);
		entityManager.getTransaction().commit();
		//entityManager.close();
		return true;
	}
	public List getList(Class clazz)
	{
	// now lets pull events from the database and list them
			
			entityManager.getTransaction().begin();
			
	        List result = entityManager.createQuery( "from "+clazz.getName(), clazz ).getResultList();
			
	        entityManager.getTransaction().commit();
	       // entityManager.close();
	        return result;
	}
	
	protected CommonEntity getSingleQuery(String query,Map<String,Object> params)
	{
		
		entityManager.getTransaction().begin();
		
		   
				Query q=   entityManager.createQuery( query);
				Iterator<String> s=params.keySet().iterator();
				while(s.hasNext())
				{
					String key=s.next();
					q.setParameter(key, params.get(key));
				}
				
				CommonEntity result=null;
				if(q.getSingleResult()!=null)
				{
				 result=(CommonEntity) q.getSingleResult();
				}
				
				
        entityManager.getTransaction().commit();
        //entityManager.flush();
        
       // entityManager.close();
        return result;
		
	}
	protected List queryResults(String query,Map<String,Object> params)
	{
		
		entityManager.getTransaction().begin();
		
		   
				Query q=   entityManager.createQuery( query);
				Iterator<String> s=params.keySet().iterator();
				while(s.hasNext())
				{
					String key=s.next();
					q.setParameter(key, params.get(key));
				}
				
				List result= q.getResultList();
				
        entityManager.getTransaction().commit();
       // entityManager.close();
        return result;
		
	}
	
	public void closeConnection()
	{	
		entityManager.close();
	}
	
	protected List queryResults(String query,Map<String,Object> params,int max)
	{
		
		entityManager.getTransaction().begin();
		
		   
				Query q=   entityManager.createQuery( query);
				q.setMaxResults(max);
			
				Iterator<String> s=params.keySet().iterator();
				while(s.hasNext())
				{
					String key=s.next();
					q.setParameter(key, params.get(key));
				}
				
				List result= q.getResultList();
				
        entityManager.getTransaction().commit();
        //entityManager.close();
        return result;
		
	}
	
	
	
	protected List queryResults(String query)
	{
		
		entityManager.getTransaction().begin();
		
		   
				Query q=   entityManager.createQuery( query);
				List result= q.getResultList();
				
        entityManager.getTransaction().commit();
        //entityManager.close();
        return result;
		
	}
	
	protected int executeNonQuery(String query)
	{
		
		entityManager.getTransaction().begin();
		
		   
				Query q=   entityManager.createQuery( query);
			int i=	q.executeUpdate();
				
        entityManager.getTransaction().commit();
        //entityManager.close();
        return i;
		
	}
	
	
	
}
