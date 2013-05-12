package com.mmdrama.service;

import java.util.List;

import com.mmdrama.business.news.DownlodFeedBl;
import com.mmdrama.business.news.GetAllNewsBl;
import com.mmdrama.dao.entity.RssFeeds;

public class NewsService {

	public void downlodFeed()
	{
		DownlodFeedBl bl=new DownlodFeedBl();
		bl.download();
	}
	
	public List<RssFeeds> getAllNews()
	{
		GetAllNewsBl bl=new GetAllNewsBl();
		bl.process();
		return bl.getAllFeeds();
	}
	
}
