package com.mmdrama.web.actions.maintain;

import java.util.Map;

import com.mmdrama.service.MovieService;
import com.mmdrama.web.actions.CommonAction;
import com.mmdrama.web.model.maintain.movie.MaintainMovie;
import com.mmdrama.web.service.Service;
import com.opensymphony.xwork2.interceptor.ScopedModelDriven;

public class UpdateFormAction extends CommonAction implements ScopedModelDriven<MaintainMovie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8913517218156131272L;
	private String uuid;
	private MaintainMovie model;
	public String execute()
	{
		
		MovieService svc=new MovieService();
		svc.getMovieById(this.getUuid());
		
		return SUCCESS;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public MaintainMovie getModel() {
		// TODO Auto-generated method stub
		return null;
	}



	public void setModel(MaintainMovie model) {
		// TODO Auto-generated method stub
		
	}

	public void setScopeKey(String key) {
		// TODO Auto-generated method stub
		
	}

	public String getScopeKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
