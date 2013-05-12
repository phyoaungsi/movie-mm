package com.mmdrama.web.actions.maintain;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.mmdrama.constants.PropertyKey;
import com.mmdrama.core.common.FileWriter;
import com.mmdrama.core.common.PropertiesFile;
import com.mmdrama.dao.entity.GoogleMap;
import com.mmdrama.dao.entity.Movie;
import com.mmdrama.service.MovieService;
import com.mmdrama.web.actions.CommonAction;
import com.mmdrama.web.model.maintain.movie.MaintainMovie;
import com.opensymphony.xwork2.interceptor.ScopedModelDriven;

public class MaintainAction extends CommonAction implements ScopedModelDriven<MaintainMovie>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556964477579706534L;
	private MaintainMovie model;
	private String scopeKey;

	
	
	
	@Action(value="create", 
		    results={@Result(name="success", location="/content/maintain/display-input.jsp")}
		  )
	public String create()
	{
		
	
		
		Movie m=new Movie();
		m.setTitle(model.getName());
		m.setEmbed(model.getEmbed());
	    m.setDescription(model.getDesc());
	    FileWriter ffw=new FileWriter();
	    String basePath=PropertiesFile.getString(PropertyKey.IMAGE_PATH.getName());
	    ffw.writeFile(model.getUpload(), basePath+File.pathSeparator+model.getUploadFileName());
	    m.setThumbnail(model.getUploadFileName());
	    m.setMap(new GoogleMap());
	    m.getMap().setLattitude(model.getLatitude());
	    m.getMap().setLongitude(model.getLongitude());
	    m.getMap().setZoomLevel(model.getZoomlevel());
		MovieService service=new MovieService();
		service.create(m);
	    this.addActionMessage("Created Successfully");
		return SUCCESS;
	}
	
	@Action("display")
	public String display()
	{
		
		
	
	
		return INPUT;
	}
	
	
	public MaintainMovie getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	
	public void setModel(MaintainMovie model) {
		// TODO Auto-generated method stub
		this.model=model;
	}


	public void setScopeKey(String key) {
		// TODO Auto-generated method stub
		this.scopeKey=key;	}


	public String getScopeKey() {
		// TODO Auto-generated method stub
		return this.scopeKey;
	}



}
