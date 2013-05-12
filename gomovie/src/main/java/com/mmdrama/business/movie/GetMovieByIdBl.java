package com.mmdrama.business.movie;

import com.mmdrama.core.business.BusinessLogic;
import com.mmdrama.dao.MovieDao;
import com.mmdrama.dao.entity.Movie;

public class GetMovieByIdBl extends BusinessLogic {

	private MovieDao dao=new MovieDao(getEntityManager());
    private String id;
    private Movie movie;
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		movie= dao.getMovieById(id);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
