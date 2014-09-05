package com.pemelo.dao.impl;

import java.sql.SQLException;

import com.pemelo.dao.TeamDao;
import com.pemelo.utils.DBUtil;

public class TeamImpl extends BaseBaoImpl implements TeamDao{

	@Override
	public int getPowerById(int id) {
		
		String sql = "SELECT power FROM team WHERE id = " + id;
		return executeSeletePowerSQL(sql);
		        
	}
	
	public int addPowerById(int id){
		String sql = "UPDATE team SET power = power + 1 WHERE id = " + id;
		return excuteUpdatePowerSQL(sql);
	}
	
	private int executeSeletePowerSQL(String sql) {
		
		System.out.println(sql);
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("power");
			}
			DBUtil.close(conn);
		} catch (SQLException e) {
			System.out.println("executeSeletePowerSQL SQLException");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	private int excuteUpdatePowerSQL(String sql) {
		int flag = 0;
		try {
			conn =DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			flag = ps.executeUpdate();
			DBUtil.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
