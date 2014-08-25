package com.pemelo.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBUtil {
	private static BasicDataSource bds;
	static {
		Properties pros = new Properties();
		try {
			pros.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			bds=(BasicDataSource) BasicDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return bds.getConnection();
	}
	public static void close(Connection conn) throws SQLException{
		if(!conn.isClosed()){
			conn.close();
		}
	}
}
