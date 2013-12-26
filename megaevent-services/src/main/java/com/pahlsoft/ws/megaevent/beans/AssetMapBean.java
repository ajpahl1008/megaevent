package com.pahlsoft.ws.megaevent.beans;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.pahlsoft.ws.megaevent.dao.PropertyDAO;

public class AssetMapBean {
	private Map<Integer,String> assetTypes = Collections.synchronizedMap(new HashMap<Integer,String>());
	
	@Autowired
	PropertyDAO propertyDao;
	
	public void load() {
		this.setAssetTypes(propertyDao.getAssetTypes());
	}

	public Map<Integer,String> getAssetTypes() {
		return assetTypes;
	}

	public void setAssetTypes(Map<Integer,String> assetTypes) {
		this.assetTypes = assetTypes;
	}
	
}
