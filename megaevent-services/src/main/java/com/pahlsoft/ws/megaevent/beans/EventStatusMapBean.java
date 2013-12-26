package com.pahlsoft.ws.megaevent.beans;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.pahlsoft.ws.megaevent.dao.PropertyDAO;

public class EventStatusMapBean {
	private Map<Integer,String> eventStatusTypes = Collections.synchronizedMap(new HashMap<Integer,String>());
	
	@Autowired
	PropertyDAO propertyDao;
	
	public void load() {
		
		this.setEventStatusTypes(propertyDao.getEventStatusTypes());
	}

	public Map<Integer,String> getEventStatusTypes() {
		return eventStatusTypes;
	}

	public void setEventStatusTypes(Map<Integer,String> eventStatusTypes) {
		this.eventStatusTypes = eventStatusTypes;
	}

	
}
