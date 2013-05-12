package com.mmdrama.core.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ernieyu.feedparser.Feed;
import com.ernieyu.feedparser.FeedException;
import com.ernieyu.feedparser.FeedParser;
import com.ernieyu.feedparser.FeedParserFactory;
import com.mmdrama.dao.entity.DownloadFeed;

public class RssParser {
	

	
	public Feed download(String rssUrl)
	{
		
		
		  
		    try {
		    	  URL url=null;
		    	  url = new URL(rssUrl);
		    	  HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		    	
				if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				    InputStream feedStream = httpConnection.getInputStream();
				    
FeedParser parser = FeedParserFactory.newParser();
   Feed feed = parser.parse(feedStream);
   return feed; 
   
   
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FeedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return null;
	}
	
	public static void main(String[] args)
	{
		// DownloadFeed df=new DownloadFeed();
		// df.download();
	}

}
