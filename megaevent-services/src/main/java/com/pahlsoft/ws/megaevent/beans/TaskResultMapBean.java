package com.pahlsoft.ws.megaevent.beans;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pahlsoft.ws.megaevent.dao.PropertyDAO;


public class TaskResultMapBean {
	private Map<Integer,String> taskResultTypes = Collections.synchronizedMap(new HashMap<Integer,String>());
	
	@Autowired
	PropertyDAO propertyDao;
		
	public void load() {
		this.setTaskResultTypes(propertyDao.getTaskResultTypes());
	}

	public Map<Integer,String> getTaskResultTypes() {
		return taskResultTypes;
	}

	public void setTaskResultTypes(Map<Integer,String> taskResultTypes) {
		this.taskResultTypes = taskResultTypes;
	}

		
}
