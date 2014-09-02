package com.pemelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseBaoImpl {
	protected Connection conn=null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
}
