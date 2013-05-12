package com.mmdrama.web.actions.display;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import com.mmdrama.dao.entity.Movie;
import com.mmdrama.service.MovieService;
import com.opensymphony.xwork2.ActionSupport;

@Action
public class ShowmovieAction extends ActionSupport {

	/**
	 * 
	 */
	private String id;
	private Movie movie;
	private List<Movie> nearByMoives;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private static final long serialVersionUID = 2995134996939797491L;
	
	public String execute()
	{
		System.out.println("display page");
		MovieService service=new MovieService();
	
		Movie m=service.getMovieById(id);
		setMovie(m);
		
		setNearByMoives(service.getNearByMovie(m.getMap(), 5, 5));
		
		return SUCCESS;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Movie> getNearByMoives() {
		return nearByMoives;
	}

	public void setNearByMoives(List<Movie> nearByMoives) {
		this.nearByMoives = nearByMoives;
	}

}
