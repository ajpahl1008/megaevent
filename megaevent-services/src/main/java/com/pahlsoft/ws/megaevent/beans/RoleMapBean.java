package com.pahlsoft.ws.megaevent.beans;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.pahlsoft.ws.megaevent.dao.PropertyDAO;

public class RoleMapBean {
	private Map<Integer,String> roleTypes = Collections.synchronizedMap(new HashMap<Integer,String>());
	
	@Autowired
	PropertyDAO propertyDao;
	
	public void load() {
		this.setRoleTypes(propertyDao.getRoleTypes());
	}

	public Map<Integer,String> getRoleTypes() {
		return roleTypes;
	}

	public void setRoleTypes(Map<Integer,String> roleTypes) {
		this.roleTypes = roleTypes;
	}

	
	
}
