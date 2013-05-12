package com.mmdrama.business.movie;

import com.mmdrama.core.business.BusinessLogic;
import com.mmdrama.dao.MovieDao;
import com.mmdrama.dao.entity.Movie;

public class CreateBl extends BusinessLogic{

	private MovieDao dao=new MovieDao(getEntityManager());
    private boolean success;
    private Movie movie;
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		dao.createMovie(movie);
	}
	
	 
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	

}
