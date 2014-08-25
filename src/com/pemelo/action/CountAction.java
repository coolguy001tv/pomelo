package com.pemelo.action;

import com.pemelo.service.CountService;

public class CountAction extends BasicAction{
	private int total;
	private CountService service = new CountService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String count(){
		total = service.gettotalNum();
		return "success";
	}

	public int getTotal() {
		return total;
	}
	
}
