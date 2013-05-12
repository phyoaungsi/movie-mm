package com.mmdrama.service;

import java.math.BigDecimal;
import java.util.List;

import com.mmdrama.business.movie.CreateBl;
import com.mmdrama.business.movie.DistributePin;
import com.mmdrama.business.movie.FeedRssBl;
import com.mmdrama.business.movie.GetAllBl;
import com.mmdrama.business.movie.GetMovieByIdBl;
import com.mmdrama.business.movie.GetNearByMoviesBl;
import com.mmdrama.dao.entity.GoogleMap;
import com.mmdrama.dao.entity.Movie;

public class MovieService {

	public void create(Movie m)
	{
		CreateBl bl=new CreateBl();
		bl.setMovie(m);
		bl.process();
		
	}
	
	public int feedRss(String url,String address)
	{
		FeedRssBl bl=new FeedRssBl();
		bl.setAddress(address);
		bl.setRssUrl(url);
		bl.process();
		
		
		return bl.getCount();
		
	}
	
	public List<Movie> getAllMovie()
	{
		GetAllBl bl=new GetAllBl();
		bl.process();
		return bl.getMovies();
	}
	
	public Movie getMovieById(String id)
	{
		GetMovieByIdBl bl=new GetMovieByIdBl();
		bl.setId(id);
		bl.process();
		
		return bl.getMovie();
	}
	
	
	public List<Movie> getNearByMovie(BigDecimal lat0,BigDecimal lat1,BigDecimal lng0,BigDecimal lng1)
	{
		GetNearByMoviesBl bl=new GetNearByMoviesBl( lat0, lat1, lng0, lng1);
		bl.process();
		return bl.getMovies();
	}
	
	public List<Movie> getNearByMovie(GoogleMap map,int limit,int radious)
	{
		GetNearByMoviesBl bl=new GetNearByMoviesBl(  map, limit, radious);
		bl.process();
		return bl.getMovies();
	}
	
	
	public List<Movie> getDistributedPin(BigDecimal lat0,BigDecimal lat1,BigDecimal lng0,BigDecimal lng1)
	{
		DistributePin pins=new DistributePin(lat0,lat1,lng0,lng1);
		pins.process();
		
		return pins.getResults();
	}
	
}
