package com.mmdrama.web.actions.welcome;



import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.mmdrama.dao.entity.Movie;
import com.mmdrama.web.actions.CommonAction;
import com.opensymphony.xwork2.ActionSupport;


public class WelcomeAction extends CommonAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -56317338472291629L;
	private List<Movie> movies;
	@Action(
			value="welcome", 
		    results={@Result(name="success", location="/content/search/result-success.jsp")}
			
			)
	public String execute()
	{
		System.out.println("hk");
		this.setMovies(getMovieList());
		return SUCCESS;
	}

	public static void main(String[] args)
	{
		
		System.out.println("hk");
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
