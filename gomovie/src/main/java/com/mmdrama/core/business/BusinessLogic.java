package com.mmdrama.core.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BusinessLogic {
	
	
	
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager em;
	protected EntityManager getEntityManager()
	{
	  	
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
		em= entityManagerFactory.createEntityManager();
		return em;
	}
	
	
	public void process()
	{
		execute();
		disconnect();
		
	}
	
	
	private void disconnect()
	{
		em.close();
		
	}
	
	
	protected abstract void execute();
	


}
