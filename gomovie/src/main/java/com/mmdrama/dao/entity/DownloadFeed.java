package com.mmdrama.dao.entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.ernieyu.feedparser.Feed;
import com.ernieyu.feedparser.FeedException;
import com.ernieyu.feedparser.FeedParser;
import com.ernieyu.feedparser.FeedParserFactory;
import com.ernieyu.feedparser.Item;
import com.mmdrama.dao.RssFeedDao;

public class DownloadFeed {


	
	public static void main(String[] args)
	{
		 DownloadFeed df=new DownloadFeed();
		// df.download();
	}
	
}
