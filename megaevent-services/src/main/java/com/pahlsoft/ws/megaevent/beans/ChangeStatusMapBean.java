package com.pahlsoft.ws.megaevent.beans;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pahlsoft.ws.megaevent.dao.PropertyDAO;


public class ChangeStatusMapBean {
	private Map<Integer,String> changeStatusTypes = Collections.synchronizedMap(new HashMap<Integer,String>());
	
	@Autowired
	PropertyDAO propertyDao;
	
	public void load() {
		this.setChangeStatusTypes(propertyDao.getChangeStatusTypes());
	}

	public Map<Integer,String> getChangeStatusTypes() {
		return changeStatusTypes;
	}

	public void setChangeStatusTypes(Map<Integer,String> changeStatusTypes) {
		this.changeStatusTypes = changeStatusTypes;
	}


	
}
