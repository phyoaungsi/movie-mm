package com.mmdrama.web.ajax;

import java.math.BigDecimal;
import java.util.List;

import com.mmdrama.dao.entity.Movie;
import com.mmdrama.service.MovieService;
import com.opensymphony.xwork2.Action;


public class GetLatLngDistributedListAction {
	
	BigDecimal lat0;
	BigDecimal lat1;
	BigDecimal lng0;
	BigDecimal lng1;
	private List<Movie> movies;
	
	public String find()
	{
		MovieService service=new MovieService();
	  setMovies(service.getDistributedPin(lat0,lat1, lng0, lng1));	
	  return Action.SUCCESS;
	}

	public String execute()
	{
	  MovieService service=new MovieService();
	  setMovies(service.getDistributedPin(lat0,lat1, lng0, lng1));	
	  return Action.SUCCESS;
	}

	

	

	public BigDecimal getLat0() {
		return lat0;
	}

	public void setLat0(BigDecimal lat0) {
		this.lat0 = lat0;
	}

	public BigDecimal getLat1() {
		return lat1;
	}

	public void setLat1(BigDecimal lat1) {
		this.lat1 = lat1;
	}

	public BigDecimal getLng0() {
		return lng0;
	}

	public void setLng0(BigDecimal lng0) {
		this.lng0 = lng0;
	}

	public BigDecimal getLng1() {
		return lng1;
	}

	public void setLng1(BigDecimal lng1) {
		this.lng1 = lng1;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	

}
