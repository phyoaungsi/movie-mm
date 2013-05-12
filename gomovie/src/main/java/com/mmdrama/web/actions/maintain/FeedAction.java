package com.mmdrama.web.actions.maintain;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.mmdrama.service.MovieService;
import com.mmdrama.web.actions.CommonAction;


@Action( 
results={@Result(name="success", location="/content/maintain/feed.jsp"),
		@Result(name="error", location="/content/maintain/feed.jsp")	
}
)
public class FeedAction extends CommonAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8536610116961807836L;
	public String url;
public String address;
	public String execute()
	
	{
		if(this.getUrl()==null || this.getAddress()==null){
			
			this.addActionError("URL cannot be null");
			if(this.getAddress()==null)
				this.addActionError("Address cannot be empty");
			return ERROR;
		}
		else
		{
		MovieService bl=new MovieService();
		 int c=bl.feedRss(this.getUrl(),address);
		 this.addActionMessage(c+" records inserted.");
		}
		return SUCCESS;
	
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
