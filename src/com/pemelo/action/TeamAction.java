package com.pemelo.action;

import com.pemelo.service.TeamService;

public class TeamAction extends BasicAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] power = new int[5];
	

	private int id;
	private TeamService teamService = new TeamService();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getPower() {
		return power;
	}
	
	public String getAllPlayerPower(){
		System.out.println("getAllPlayerPower----------");
		
		for(int i = 0; i < 5; i++){
			power[i] =  teamService.getPlayerPower(i + 1);
			System.out.println("power "+ i + "=" + power[i]);
		}
		
		return "success";
	}
	
	public String getPlayerPowerById(){
		power[id -1] =  teamService.getPlayerPower(id);
		return "success";
	}
	
	public String addPlayerPowerById(){
		power[id - 1] =  teamService.addPlayerPower(id);
		getAllPlayerPower();
		for(int i = 0; i < 5; i++){
			System.out.println("power "+ i + "=" + power[i]);
		}
		return "success";
	}
	

	
}
