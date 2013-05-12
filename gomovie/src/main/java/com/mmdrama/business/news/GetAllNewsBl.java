package com.mmdrama.business.news;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mmdrama.dao.entity.RssFeeds;

public class GetAllNewsBl extends NewsBl {

	private static Logger logger = LogManager.getLogger(NewsBl.class);
	private List<RssFeeds> allFeeds;
	@Override
	public void executeBusiness() {
		// TODO Auto-generated method stub
		logger.info("Get all feeds**************************************");
		setAllFeeds(dao.getAllRss());
	}
	
	public List<RssFeeds> getAllFeeds() {
		return allFeeds;
	}


	public void setAllFeeds(List<RssFeeds> allFeeds) {
		this.allFeeds = allFeeds;
	}

}
