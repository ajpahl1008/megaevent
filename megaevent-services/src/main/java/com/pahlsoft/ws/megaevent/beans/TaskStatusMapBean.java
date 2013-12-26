package com.pahlsoft.ws.megaevent.beans;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pahlsoft.ws.megaevent.dao.PropertyDAO;


public class TaskStatusMapBean {
	private Map<Integer,String> taskStatusTypes = Collections.synchronizedMap(new HashMap<Integer,String>());

	@Autowired
	PropertyDAO propertyDao;
	
	public void load() {
		this.setTaskStatusTypes(propertyDao.getTaskStatusTypes());
	}

	public Map<Integer,String> getTaskStatusTypes() {
		return taskStatusTypes;
	}

	public void setTaskStatusTypes(Map<Integer,String> taskStatusTypes) {
		this.taskStatusTypes = taskStatusTypes;
	}

	
}
