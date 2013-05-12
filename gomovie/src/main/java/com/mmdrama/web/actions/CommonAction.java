package com.mmdrama.web.actions;

import java.util.List;

import com.mmdrama.core.web.CommonActionSupport;
import com.mmdrama.dao.entity.Movie;
import com.mmdrama.service.MovieService;

public class CommonAction extends CommonActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5470733640878677004L;

	public List<Movie> getMovieList() {
		MovieService service=new MovieService();
		return service.getAllMovie();
	}
	
}
