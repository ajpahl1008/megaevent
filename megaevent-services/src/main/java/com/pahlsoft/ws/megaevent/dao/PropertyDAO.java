package com.pahlsoft.ws.megaevent.dao;

import java.util.Map;

public interface PropertyDAO {
	// The Getters
	public Map<Integer,String> getRoleTypes();
	public Map<Integer,String> getEventStatusTypes();
	public Map<Integer,String> getChangeStatusTypes();
	public Map<Integer,String> getTaskStatusTypes();
	public Map<Integer,String> getTaskResultTypes();
	public Map<Integer,String> getAssetTypes();

	
}
