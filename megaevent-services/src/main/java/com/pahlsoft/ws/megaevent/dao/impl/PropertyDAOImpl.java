package com.pahlsoft.ws.megaevent.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pahlsoft.ws.megaevent.dao.PropertyDAO;

public class PropertyDAOImpl implements PropertyDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public Logger daoLog = Logger.getLogger(PropertyDAOImpl.class);
	
	public Map<Integer, String> getRoleTypes() {
		daoLog.debug("Retrieving Roles");
		String role_sql = "select * from megaevent.roles";
		Map<Integer,String> roles = new HashMap<Integer,String>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(role_sql);
		for (Map<?, ?> row : rows) {
			roles.put((Integer)row.get("roleID"),(String)row.get("role"));
		}		
		return roles;
	}

	public Map<Integer, String> getEventStatusTypes() {
		daoLog.debug("Retrieving EventStatus Types");
		String role_sql = "select * from megaevent.event_status";
		Map<Integer,String> eventStatusMap = new HashMap<Integer,String>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(role_sql);
		for (Map<?, ?> row : rows) {
			
			eventStatusMap.put((Integer)row.get("event_statusID"),(String)row.get("event_status"));
		}		
		return eventStatusMap;
	}

	public Map<Integer, String> getChangeStatusTypes() {
		daoLog.debug("Retrieving ChangeStatus Types");
		String role_sql = "select * from megaevent.change_status";
		Map<Integer,String> changeStatusMap = new HashMap<Integer,String>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(role_sql);
		for (Map<?, ?> row : rows) {
			changeStatusMap.put((Integer)row.get("change_statusID"),(String)row.get("change_status"));
		}		
		return changeStatusMap;
	}

	public Map<Integer, String> getTaskStatusTypes() {
		daoLog.debug("Retrieving TaskStatus Types");
		String role_sql = "select * from megaevent.task_status";
		Map<Integer,String> taskStatusMap = new HashMap<Integer,String>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(role_sql);
		for (Map<?, ?> row : rows) {
			taskStatusMap.put((Integer)row.get("task_statusID"),(String)row.get("task_status"));
		}		
		return taskStatusMap;
	}

	public Map<Integer, String> getTaskResultTypes() {
		daoLog.debug("Retrieving TaskResult Types");
		String role_sql = "select * from megaevent.task_result";
		Map<Integer,String> taskResultMap = new HashMap<Integer,String>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(role_sql);
		for (Map<?, ?> row : rows) {
			taskResultMap.put((Integer)row.get("task_resultID"),(String)row.get("task_result"));
		}		
		return taskResultMap;
	}
	
	public Map<Integer, String> getAssetTypes() {
		daoLog.debug("Retrieving Asset Types");
		String role_sql = "select * from megaevent.asset_types";
		Map<Integer,String> assetTypeMap = new HashMap<Integer,String>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(role_sql);
		for (Map<?, ?> row : rows) {
			assetTypeMap.put((Integer)row.get("asset_typeID"),(String)row.get("asset_type"));
		}		
		return assetTypeMap;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
