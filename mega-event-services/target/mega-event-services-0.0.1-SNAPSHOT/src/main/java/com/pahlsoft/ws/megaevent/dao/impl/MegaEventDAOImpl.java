package com.pahlsoft.ws.megaevent.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pahlsoft.ws.megaevent.dao.MegaEventDAO;
import com.pahlsoft.ws.megaevent.generated.AssetType;
import com.pahlsoft.ws.megaevent.generated.ChangeStatus;
import com.pahlsoft.ws.megaevent.generated.Event;
import com.pahlsoft.ws.megaevent.generated.EventStatus;
import com.pahlsoft.ws.megaevent.generated.Person;
import com.pahlsoft.ws.megaevent.generated.Role;
import com.pahlsoft.ws.megaevent.generated.TargetedItem;
import com.pahlsoft.ws.megaevent.generated.Task;
import com.pahlsoft.ws.megaevent.generated.TaskResult;
import com.pahlsoft.ws.megaevent.generated.TaskStatus;
import com.pahlsoft.ws.megaevent.mappers.PersonMapper;
import com.pahlsoft.ws.megaevent.mappers.TargetedItemMapper;
import com.pahlsoft.ws.megaevent.mappers.TaskRowMapper;

public class MegaEventDAOImpl implements MegaEventDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public Logger daoLog = Logger.getLogger(MegaEventDAOImpl.class);

	public Event getEvent(int eventId) {

		daoLog.debug("Querying for Event: " + eventId);
		String sql = "select * from megaevent.megaevent_events_j01 where eventID='" + eventId + "'";
		Map<String, Object> attributes = getJdbcTemplate().queryForMap(sql);
		Event event = new Event();
		event.setId(eventId);
		event.setTitle((String)attributes.get("title"));
		event.setDescription((String)attributes.get("description"));
		event.setEventStatus(EventStatus.fromValue((String)attributes.get("status")));

		return event;
	}

	public List<Event> getEvents() {
		daoLog.debug("Querying for all Events");
		String sql = "select * from megaevent.megaevent_events_j01";
		List<Event> events = new ArrayList<Event>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Event event= new Event();
			event.setId((Integer)row.get("eventID"));
			event.setTitle((String)row.get("title"));
			event.setDescription((String)row.get("description"));
			event.setEventStatus(EventStatus.valueOf(((String)row.get("status"))));
			
			events.add(event);
		}		
		return events;
	}

	public List<Task> getTasks(int eventId) {
		daoLog.debug("Querying for Tasks for Event ID: " + eventId);
		String sql = "select * from megaevent.megaevent_tasks_j01 where eventID='" + eventId + "'";
		List<Task> tasks = new ArrayList<Task>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Task task = new Task();
			task.setId((Integer)row.get("taskID"));
			task.setName((String)row.get("task_name"));
			task.setTaskStatus(TaskStatus.fromValue(((String)row.get("task_status"))));
			task.setTaskResult(TaskResult.fromValue(((String)row.get("task_result"))));
			task.setDependencyId((Integer)row.get("dependency_taskID"));
			task.setEventId((Integer)row.get("eventID"));
			task.setOwnerId((Integer)row.get("ownerID"));
			task.setActivatorId((Integer)row.get("activatorID"));
			task.setValidatorId((Integer)row.get("validatorID"));
			task.setRole(Role.valueOf((String)row.get("role")));
			task.setDescription(((String)row.get("description")));
			task.setChangeControlNumber((((String)row.get("change_control"))));
			task.setChangeControlStatus(ChangeStatus.valueOf((String)row.get("change_status")));
			task.setAssetName((String)row.get("asset_name"));
			tasks.add(task);
		}

		return tasks;
	}

	public Task getTask(int taskId) {
		daoLog.debug("Querying for Task: " + taskId);
		String sql = "select * from megaevent.megaevent_tasks_j01 where taskID=?";
		return (Task)getJdbcTemplate().queryForObject(sql, new Object[] { taskId}, new TaskRowMapper());
		
	}


	public Person getPerson(int personId) {
		daoLog.debug("Querying for Person: " + personId);
		String sql = "select * from megaevent.megaevent_persons_j01 where personID=?";
		return (Person)getJdbcTemplate().queryForObject(sql, new Object[] { personId}, new PersonMapper());

	}

	public List<Person> getPersons(int eventId) {
		daoLog.debug("Querying for Persons for Event ID: " + eventId);
		String sql = "select * from megaevent.megaevent_persons_event_j01 where eventID='" + eventId + "'";
		List<Person> persons = new ArrayList<Person>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Person person = new Person();
			person.setId((Integer)row.get("personID"));
			person.setFirstName((String) row.get("first_name"));
			person.setLastName((String)row.get("last_name"));
			person.setLogin((String)row.get("login"));
			person.setRole(Role.fromValue((String)row.get("role")));
			person.setWorkPhone((String)row.get("work_phone"));
			person.setCellPhone((String)row.get("cell_phone"));
			person.setPager((String)row.get("pager"));
			persons.add(person);
		}

		return persons;
	}

	public TargetedItem getTargetedItem(int taskId) {
		daoLog.debug("Querying for Targeted Item: " + taskId);
		String sql = "select * from megaevent.megaevent_tasks_items_j03 where taskID=?";
		return (TargetedItem)getJdbcTemplate().queryForObject(sql, new Object[] {taskId} , new TargetedItemMapper());

	}

	public List<TargetedItem> getTargetedItems(int eventId) {
		daoLog.debug("Querying for Targeted Item: " + eventId);
		String sql = "select * from megaevent.megaevent_tasks_items_j03 where eventID='" + eventId + "'";
		List<TargetedItem> items = new ArrayList<TargetedItem>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			TargetedItem item = new TargetedItem();
			item.setId((Integer)row.get("taskID"));
			item.setAssetName((String)row.get("asset_name"));
			item.setAssetType(AssetType.valueOf((String)row.get("asset_type")));
			items.add(item);
		}
		return items;
	}
		
	public int addEvent(Event event) {
		daoLog.debug("Adding Event Entitled: " + event.getTitle());
		String event_sql = "INSERT INTO megaevent.events VALUES (default,?,?,?)";
		return getJdbcTemplate().update(event_sql,new Object[] { event.getTitle(),
																 event.getDescription(),
																 getStatusId(event.getEventStatus())});
	}

	public int addTask(Task taskInfo, int eventId) {
		daoLog.debug("Adding Task to Event ID: " + eventId);
		String event_sql = "INSERT INTO megaevent.tasks VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return getJdbcTemplate().update(event_sql,new Object[] { 
																 taskInfo.getName(),
																 getStatusId(taskInfo.getTaskStatus()),
																 getResultId(taskInfo.getTaskResult()),
																 taskInfo.getDependencyId(),
																 taskInfo.getEventId(),
																 taskInfo.getOwnerId(),
																 taskInfo.getActivatorId(),
																 taskInfo.getValidatorId(),
																 getRoleId(taskInfo.getRole()),
																 taskInfo.getDescription(),
																 taskInfo.getChangeControlNumber(),
																 getStatusId(taskInfo.getChangeControlStatus()),
																 getTargetedItemId(taskInfo.getAssetName())
																 
																 
																 
		});
	}

	public int addPerson(Person person) {
		daoLog.debug("Adding Person : " + person.getFirstName() + " " + person.getLastName());
		String person_sql = "INSERT INTO megaevent.persons VALUES (default,?,?,?,?,?,?,?)";
		return getJdbcTemplate().update(person_sql,new Object[] {
																person.getFirstName(),
																person.getLastName(),
																person.getLogin(),
																getRoleId(person.getRole()),
																person.getWorkPhone(),
																person.getCellPhone(),
																person.getPager()
		});
		
	}

	public int addTargetedItem(TargetedItem targetedItem) {

		daoLog.debug("Adding Targeted Item: " + targetedItem.getAssetName());
		String targeted_item_sql = "INSERT INTO megaevent.targeted_items VALUES (default,?,?)";
		return getJdbcTemplate().update(targeted_item_sql,new Object[] {
																		 targetedItem.getAssetName(),
																		 getAssetTypeId(targetedItem.getAssetType())
		});	
		
	}

	public int updateEvent(Event event) {
		daoLog.debug("Updating Event : " + event.getTitle());
		String event_sql = "UPDATE megaevent.events set title=?, description=?,status=? where eventID =?";
		return getJdbcTemplate().update(event_sql,new Object[] {event.getTitle(),
																	  event.getDescription(),
																	  getStatusId(event.getEventStatus()),
																	  event.getId()
		});
	}

	public int updateTask(Task taskInfo) {
		daoLog.debug("Updating Task : " + taskInfo.getId());
		String task_sql = "UPDATE megaevent.tasks set name=?,task_status=?,task_result=?,dependency_taskID=?,eventID=?,ownerID=?,activatorID=?,validatorID=?,role=?,description=?,change_control=?,change_status=?,targeted_itemID=? where taskID=?";
		return getJdbcTemplate().update(task_sql,new Object[] {taskInfo.getName(),
																 getStatusId(taskInfo.getTaskStatus()),
																 getResultId(taskInfo.getTaskResult()),
																 taskInfo.getDependencyId(),
																 taskInfo.getEventId(),
																 taskInfo.getOwnerId(),
																 taskInfo.getActivatorId(),
																 taskInfo.getValidatorId(),
																 getRoleId(taskInfo.getRole()),
																 taskInfo.getDescription(),
																 taskInfo.getChangeControlNumber(),
																 getStatusId(taskInfo.getChangeControlStatus()),
																 getTargetedItemId(taskInfo.getAssetName()),
																 taskInfo.getId()
		});
	}

	public int updatePerson(Person person) {
		daoLog.debug("Updating Person: " + person.getFirstName() + " " + person.getLastName());
		String task_sql = "UPDATE megaevent.persons set first_name=?,last_name=?,login=?,roleID=?,work_phone=?,cell_phone=?,pager=? where personID=?";
		return getJdbcTemplate().update(task_sql,new Object[] {	person.getFirstName(),
																person.getLastName(),
																person.getLogin(),
																getRoleId(person.getRole()),
																person.getWorkPhone(),
																person.getCellPhone(),
																person.getPager(),
																person.getId()
		});
		
	}

	public int updateTargetedItem(TargetedItem targetedItem) {
		daoLog.debug("Updating Targeted Item: " + targetedItem.getAssetName());
		String task_sql = "UPDATE megaevent.targeted_items set asset_name=?,asset_typeID=? where targeted_itemsID=?";
		return getJdbcTemplate().update(task_sql,new Object[] {	targetedItem.getAssetName(),
																getAssetTypeId(targetedItem.getAssetType()),
																targetedItem.getId()
																
		});
	}
	
	private int getStatusId(EventStatus status) {
		String status_sql = "select event_statusID from megaevent.event_status where event_status=?";
		return getJdbcTemplate().queryForInt(status_sql,new Object[] {status.value()} );
	}
	
	private int getStatusId(TaskStatus status) {
		String status_sql = "select task_statusID from megaevent.task_status where task_status =?";
		return getJdbcTemplate().queryForInt(status_sql,new Object[] {status.value()} );
	}
	
	private int getStatusId(ChangeStatus status) {
		String status_sql = "select change_statusID from megaevent.change_status where change_status =?";
		return getJdbcTemplate().queryForInt(status_sql,new Object[] {status.value()} );
	}

	private int getResultId(TaskResult result) {
		String result_sql = "select task_resultID from megaevent.task_result where task_result=?";
		return getJdbcTemplate().queryForInt(result_sql,new Object[] {result.value()} );
	}
	
	private int getRoleId(Role role) {
		String role_sql = "select roleID from megaevent.roles where role=?";
		return getJdbcTemplate().queryForInt(role_sql,new Object[] {role.value()});	
	}

	private int getTargetedItemId(String assetName) {
		String role_sql = "select targeted_itemsID from megaevent.targeted_items where asset_name=?";
		return getJdbcTemplate().queryForInt(role_sql,new Object[] {assetName});	
	}
	
	private int getAssetTypeId(AssetType assetType) {
		String role_sql = "select asset_typeID from megaevent.asset_types where asset_type=?";
		return getJdbcTemplate().queryForInt(role_sql,new Object[] {assetType.value()});	
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
