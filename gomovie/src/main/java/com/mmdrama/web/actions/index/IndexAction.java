package com.mmdrama.web.actions.index;



import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ResultPath;

import com.mmdrama.web.actions.CommonAction;
import com.opensymphony.xwork2.ActionSupport;


public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -56317338472291629L;
	
	@Action("welcome")
	public String execute()
	{
		System.out.println("hk");
		return SUCCESS;
	}

	public static void main(String[] args)
	{
		
		System.out.println("hk");
	}
}
