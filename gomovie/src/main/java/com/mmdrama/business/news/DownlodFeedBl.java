package com.mmdrama.business.news;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ernieyu.feedparser.Feed;
import com.ernieyu.feedparser.FeedException;
import com.ernieyu.feedparser.FeedParser;
import com.ernieyu.feedparser.FeedParserFactory;
import com.ernieyu.feedparser.Item;
import com.mmdrama.dao.entity.RssFeeds;

public class DownlodFeedBl extends NewsBl {

	@Override
	public void executeBusiness() {
		// TODO Auto-generated method stub
		download();
	}
	
	
	
	
	public void download()
	{
		
		dao.deleteAllRssFeeds();
		  
		    try {
		    	  URL url=null;
		    	  url = new URL("https://news.google.com/news/feeds?hl=en&gl=us&q=myanmar&um=1&ie=UTF-8&output=rss");
		    	  HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		    	
				if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				    InputStream feedStream = httpConnection.getInputStream();
				    
FeedParser parser = FeedParserFactory.newParser();
   Feed feed = parser.parse(feedStream);
   feed.getDescription();
   
   System.out.println(feed.getItemList().get(0).getDescription());
   for(Item it: feed.getItemList())
   {
	   
	   
	   RssFeeds rss=new RssFeeds();
	   rss.setAurthor(it.getAuthor());
	   rss.setDescription(it.getDescription());
	   rss.setGuid(it.getGuid());
	   rss.setLink(it.getLink());
	   rss.setMetadata(it.getTitle());
	   rss.setPubDate(it.getPubDate());
	   rss.setTags("news");
	   rss.setTitle(it.getTitle());
	  
	  // RssFeedDao dao=new RssFeedDao();
	   dao.uploadFeed(rss);
	   
	   
   }
   
   
   
   
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FeedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
