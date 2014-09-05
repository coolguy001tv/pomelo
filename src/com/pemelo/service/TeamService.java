package com.pemelo.service;

import com.pemelo.dao.impl.TeamImpl;

public class TeamService {
	
	private TeamImpl teamImpl = new TeamImpl();
	
	public int getPlayerPower(int id){
		return teamImpl.getPowerById(id);
	}
	
	public int addPlayerPower(int id){
		return teamImpl.addPowerById(id);
	}

}
