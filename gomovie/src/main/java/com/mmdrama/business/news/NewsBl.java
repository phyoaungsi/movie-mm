package com.mmdrama.business.news;

import com.mmdrama.core.business.BusinessLogic;
import com.mmdrama.dao.RssFeedDao;

public abstract class NewsBl extends BusinessLogic {

	
	RssFeedDao dao=new RssFeedDao(getEntityManager());
	
	
	

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
		executeBusiness();
	}
	
	public abstract void executeBusiness();


	
	
	 
	
}
