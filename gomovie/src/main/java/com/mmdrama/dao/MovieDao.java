package com.mmdrama.dao;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.mmdrama.core.dao.Dao;
import com.mmdrama.dao.entity.GoogleMap;
import com.mmdrama.dao.entity.Movie;

public class MovieDao extends Dao {
	
	
	public MovieDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	public void createMovie(Movie m)
	{
		
		create(m);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> getAll()
	{
		
		return (List<Movie>) super.queryResults("From Movie order by createdTime desc" );
	}
	
	


	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		String query="From Movie m where m.uuid=:uuid";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("uuid", id.trim());
		return (Movie)super.getSingleQuery(query, params);
		
	}

	
	@SuppressWarnings("unchecked")
	public List<Movie> getNearByMovie(GoogleMap map, int limit, int radious) {
		// TODO Auto-generated method stub
		
		map.getLattitude();
		map.getLongitude();
		
		//map.getLattitude()
		//String query="From movie m where (m.map.lattidude > :lattidude and m.map.lattidude < :lattitude) and  (m.map.longitude > :longitude and m.map.longitude < :longitude)";
		String query="From Movie m where (m.map.lattitude between :lattidudemin and :lattitudemax) and  (m.map.longitude between :longitudemin and :longitudemax)";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("lattitudemax", map.getLattitude().add(new BigDecimal(0.01)));
		params.put("lattidudemin", map.getLattitude().subtract(new BigDecimal(0.01)));
		params.put("longitudemax", map.getLongitude().add(new BigDecimal(0.01)));
		params.put("longitudemin", map.getLongitude().subtract(new BigDecimal(0.01)));
		//params.put("limit", limit);
		return (List<Movie>) super.queryResults(query, params,limit);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> getNearByMovie(BigDecimal lat0,BigDecimal lat1,BigDecimal lng0,BigDecimal lng1) {
		// TODO Auto-generated method stub
		
	
		//map.getLattitude()
		//String query="From movie m where (m.map.lattidude > :lattidude and m.map.lattidude < :lattitude) and  (m.map.longitude > :longitude and m.map.longitude < :longitude)";
		String query="From Movie m where (m.map.lattitude between :lattidudemin and :lattitudemax) and  (m.map.longitude between :longitudemin and :longitudemax)";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("lattitudemax", lat1);
		params.put("lattidudemin", lat0);
		params.put("longitudemax", lng1);
		params.put("longitudemin", lng0);
		//params.put("limit", limit);
		return (List<Movie>) super.queryResults(query, params);
		
	}
	
	

}
