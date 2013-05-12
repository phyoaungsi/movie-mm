package com.mmdrama.business.movie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mmdrama.core.business.BusinessLogic;
import com.mmdrama.dao.MovieDao;
import com.mmdrama.dao.entity.Movie;

public class DistributePin extends BusinessLogic {

	
	MovieDao dao=new MovieDao(getEntityManager());
	private BigDecimal lat0,lat1,lng0,lng1,scale,width,height;
	private List<Movie> list=new ArrayList<Movie>();
	private List<Movie> tmp=new ArrayList<Movie>();
	/**
	 * @param args
	 */
	
	
	public void distributePin() {
		width=lng1.subtract(lng0);
		height=lat1.subtract(lat0);	//int number_of_square=(width.multiply(height)).divide(scale.multiply(scale)).intValue();
		float scl=scale.floatValue();
		float widt=width.floatValue();
		float ht=height.floatValue();
		int bb=(int) (widt/scl);
		int horizontal_square=(int) (widt/scl);
		int vertical_square=(int) (ht/scl);;
		for(int i=1;i<=horizontal_square;i++ )
		{
			for(int j=1;j<=vertical_square;j++)
			{
				
				//int 
				BigDecimal latmin=lat0.add(scale.multiply(new BigDecimal(j)));
				BigDecimal latmax=latmin.add(scale);
				BigDecimal lngmin=lng0.add(scale.multiply(new BigDecimal(i)));
				BigDecimal lngmax=lngmin.add(scale);
				
				tmp=dao.getNearByMovie(latmin,latmax,lngmin,lngmax);
				if(tmp.size()>0){
				list.add(tmp.get(0));
				}
				//get this current block
				//retrieve list
				//if list > o then 
				//get the first one or highest rank
				//put to global array list and done!
			}
			
		}
		
		
	}
	public DistributePin(BigDecimal lat0, BigDecimal lat1, BigDecimal lng0,
			BigDecimal lng1) {
		super();
		this.lat0 = lat0;
		this.lat1 = lat1;
		this.lng0 = lng0;
		this.lng1 = lng1;
		this.scale=lat1.subtract(lat0).divide(new BigDecimal(20));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Movie> getResults() {
		// TODO Auto-generated method stub
		return this.list;
	}
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		distributePin();
	}

}
