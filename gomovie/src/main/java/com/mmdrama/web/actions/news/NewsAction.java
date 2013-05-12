package com.mmdrama.web.actions.news;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.mmdrama.business.news.NewsBl;
import com.mmdrama.dao.entity.RssFeeds;
import com.mmdrama.service.NewsService;
import com.mmdrama.web.actions.CommonAction;


@Action( 
results={@Result(name="success", location="/content/news/news.jsp")}
)
public class NewsAction extends CommonAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8536610116961807836L;
	public List<RssFeeds> feeds;

	public String execute()
	
	{
		
		NewsService service=new NewsService();
	    setFeeds(service.getAllNews());
		return SUCCESS;
	
	}

	public List<RssFeeds> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<RssFeeds> feeds) {
		this.feeds = feeds;
	}
}
