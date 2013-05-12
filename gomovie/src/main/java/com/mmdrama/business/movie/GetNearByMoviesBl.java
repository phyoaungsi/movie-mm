package com.mmdrama.business.movie;

import java.math.BigDecimal;
import java.util.List;

import com.mmdrama.core.business.BusinessLogic;
import com.mmdrama.dao.MovieDao;
import com.mmdrama.dao.entity.GoogleMap;
import com.mmdrama.dao.entity.Movie;

public class GetNearByMoviesBl extends BusinessLogic {

	private MovieDao dao=new MovieDao(getEntityManager());
	private List<Movie> movies;
	GoogleMap map;
	int limit;
	int radious;
	
	BigDecimal lat0;
	BigDecimal lat1;BigDecimal lng0;BigDecimal lng1;
	boolean flag;
	public GetNearByMoviesBl(GoogleMap map,int limit,int radious)
	{
		this.map=map;
		this.limit=limit;
		this.radious=radious;
		this.flag=false;
		
	}
	
	public GetNearByMoviesBl(BigDecimal lat0,BigDecimal lat1,BigDecimal lng0,BigDecimal lng1)
	{
		this.lat0=lat0;
		this.lat1=lat1;
		this.lng1=lng1;
		this.lng0=lng0;
		this.flag=true;
	}
	
	private List<Movie> getNearByMovie(GoogleMap map,int limit,int radious)
	{
		
		return dao.getNearByMovie(map,limit,radious);
		
		
	}
	
	private List<Movie> getNearByMovie(BigDecimal lat0,BigDecimal lat1,BigDecimal lng0,BigDecimal lng1)
	{
		
		return dao.getNearByMovie(lat0,lat1,lng0,lng1);
		//return dao.getAll();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(flag)
		{
			movies=getNearByMovie(lat0,lat1,lng0,lng1);
		}
		else{
		    movies= getNearByMovie( map, limit, radious);
		}
		
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
}
