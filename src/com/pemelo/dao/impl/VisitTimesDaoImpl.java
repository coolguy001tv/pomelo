package com.pemelo.dao.impl;

import java.sql.SQLException;

import com.pemelo.dao.VisitTimesDao;
import com.pemelo.utils.DBUtil;

public class VisitTimesDaoImpl extends BaseBaoImpl implements VisitTimesDao{

	@Override
	public int getTotalNum() {
		String sql = "SELECT total FROM d_visittimes WHERE id =1";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("total");
			}
			DBUtil.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		return 0;
	}

	@Override
	public int addTotalNum() {
		String sql = "UPDATE d_visittimes SET total = total + 1 WHERE id =1";
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
