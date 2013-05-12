package com.mmdrama.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.mmdrama.core.dao.Dao;
import com.mmdrama.dao.entity.RssFeeds;

public class RssFeedDao extends Dao {
	


	public RssFeedDao(EntityManager entityManager) {
		// TODO Auto-generated constructor stub
		super(entityManager);
	}

	public void uploadFeed(RssFeeds rss)
	{	
		create(rss);	
	}
	
	public int deleteAllRssFeeds()
	{	
		return super.executeNonQuery("Delete from RssFeeds");
	}
	
	@SuppressWarnings("unchecked")
	public List<RssFeeds> getAllRss()
	{	
		return (List<RssFeeds>) super.queryResults("From RssFeeds rss order by rss.pubDate desc");
	}

}
