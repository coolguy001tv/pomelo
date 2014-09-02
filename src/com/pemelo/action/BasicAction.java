package com.pemelo.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport 
		implements RequestAware,SessionAware,
		ApplicationAware,ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected HttpServletRequest httpRequest;
	protected HttpServletResponse httpResponse;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpRequest =request;
		
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.httpResponse=response;
		
	}

}
