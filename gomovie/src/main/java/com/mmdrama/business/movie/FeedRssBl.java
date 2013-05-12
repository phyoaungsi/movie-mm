package com.mmdrama.business.movie;

import java.io.File;
import java.io.IOException;

import com.ernieyu.feedparser.Feed;
import com.ernieyu.feedparser.Item;
import com.mmdrama.constants.PropertyKey;
import com.mmdrama.core.business.BusinessLogic;
import com.mmdrama.core.common.PropertiesFile;
import com.mmdrama.core.common.RssParser;
import com.mmdrama.core.webservice.google.GeoCode;
import com.mmdrama.dao.MovieDao;
import com.mmdrama.dao.entity.GoogleMap;
import com.mmdrama.dao.entity.Movie;
import com.mmdrama.html.business.HtmlParser;
import com.mmdrama.html.business.entity.YouTube;
import com.mmdrama.html.business.impl.UTubeParser;
import com.mmdrama.html.download.SaveImageFromUrl;

public class FeedRssBl extends BusinessLogic {
	private static final String JPG = ".jpg";
	private String address;
 private String rssUrl;

private int count;
 private MovieDao dao=new MovieDao(getEntityManager());
 
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		int count=0;
		RssParser p=new RssParser();
		Feed f=p.download(rssUrl);
		System.out.print(rssUrl);
		HtmlParser parser=new UTubeParser();
		YouTube u2=new YouTube();
		for(Item i:f.getItemList())
		{
			
		
			
			u2=(YouTube) parser.parseUrl(i.getLink());
			
			Movie m=new Movie();
		
			m.setTitle(i.getTitle());		
			m.setDescription(u2.getDescription());
			m.setThumbnail(u2.getId()+JPG);
			m.setLink(i.getLink());
			String youtubeEmbed=PropertiesFile.getString(PropertyKey.YOUTUBE_EMBED);
			m.setEmbed(youtubeEmbed.replace("{0}", u2.getId()));
	
			
			String thumbnailUrl=PropertiesFile.getString(PropertyKey.U2_THUMBNAIL_URL).replace("{0}", u2.getId());
			try {
				SaveImageFromUrl.saveImage(thumbnailUrl,PropertiesFile.getString(PropertyKey.IMAGE_PATH)+File.separator+u2.getId()+JPG);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GoogleMap gmap=new GoogleMap();
			GeoCode gCode=new GeoCode();
			gCode.searchAddress(address);
			gmap.setLattitude(gCode.getLat());
			gmap.setLongitude(gCode.getLng());
			gmap.setZoomLevel(12);
			m.setMap(gmap);
			//MovieDao dao=new MovieDao();
			dao.createMovie(m);
			count++;
			}
		setCount(count);
		
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	 public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getRssUrl() {
			return rssUrl;
		}

		public void setRssUrl(String rssUrl) {
			this.rssUrl = rssUrl;
		}


}
