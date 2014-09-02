package com.pemelo.service;

import com.pemelo.dao.VisitTimesDao;
import com.pemelo.dao.impl.VisitTimesDaoImpl;

public class CountService {
	private VisitTimesDao visitTimesDao = new VisitTimesDaoImpl();
	public int gettotalNum(){
		visitTimesDao.addTotalNum();
		return visitTimesDao.getTotalNum();
	}
}
