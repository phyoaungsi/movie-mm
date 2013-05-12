package com.mmdrama.business.movie;

import java.util.List;

import com.mmdrama.core.business.BusinessLogic;
import com.mmdrama.dao.MovieDao;
import com.mmdrama.dao.entity.Movie;

public class GetAllBl extends BusinessLogic{

	private MovieDao dao=new MovieDao(getEntityManager());
	private List<Movie> movies;
	@Override
protected void execute() {
		// TODO Auto-generated method stub
		//logger.info("Get all movie**************************************");
		setMovies( dao.getAll());
		
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}
