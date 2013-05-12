package com.mmdrama.web.actions.search;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import com.mmdrama.dao.entity.Movie;
import com.mmdrama.web.actions.CommonAction;
import com.mmdrama.web.service.Service;


public class SearchAction extends CommonAction {
	
	private String keyword;
	
	private List<Movie> movies;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5073160958672989731L;
	
	
	@Action("search")
	public String search()
	{
		
			Service.getBl("ha");
		getMovieList();
		System.out.println("hk");
		return INPUT;
	}

	
	
	@Action("result")
	public String result()
	{
		
		
		movies=getMovieList();
		System.out.println("showing results");
		return SUCCESS;
	}
	
public String execute() throws Exception {
		
		
		
		//call Service class to store personBean's state in database
		
		return SUCCESS;
		
	}

public List<Movie> getMovies() {
	return movies;
}

public void setMovies(List<Movie> movies) {
	this.movies = movies;
}

public String getKeyword() {
	return keyword;
}

public void setKeyword(String keyword) {
	this.keyword = keyword;
}

}
