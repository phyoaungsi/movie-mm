package com.mmdrama.business.movie;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

public class MovieBL extends BusinessLogic {
	
	
	private static Logger logger = LogManager.getLogger(BusinessLogic.class);
	//MovieDao dao=new MovieDao();
	
	public List<Movie> getAllMovie()
	{
		logger.info("Get all movie**************************************");
		return dao.getAll();
		
	}
	
	public boolean create(Movie m)
	{
		
		dao.createMovie(m);
		return true;
	}
	
	public Movie getMovieById(String id)
	{
		
		
		
	}
	
	
	public int feedFromRss(String rssUrl,String address)
	{
		
	}
	
	

}
