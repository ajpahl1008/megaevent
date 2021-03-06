package com.pahlsoft.ws.megaevent.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import com.pahlsoft.ws.megaevent.exceptions.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pahlsoft.ws.megaevent.beans.AssetMapBean;
import com.pahlsoft.ws.megaevent.beans.ChangeStatusMapBean;
import com.pahlsoft.ws.megaevent.beans.EventStatusMapBean;
import com.pahlsoft.ws.megaevent.beans.RoleMapBean;
import com.pahlsoft.ws.megaevent.beans.TaskResultMapBean;
import com.pahlsoft.ws.megaevent.beans.TaskStatusMapBean;
import com.pahlsoft.ws.megaevent.dao.MegaEventDAO;
import com.pahlsoft.ws.megaevent.generated.Event;
import com.pahlsoft.ws.megaevent.generated.Person;
import com.pahlsoft.ws.megaevent.generated.TargetedItem;
import com.pahlsoft.ws.megaevent.generated.Task;
import com.pahlsoft.ws.megaevent.mappers.PersonMapper;
import com.pahlsoft.ws.megaevent.mappers.TargetedItemMapper;
import com.pahlsoft.ws.megaevent.mappers.TaskRowMapper;

public class MegaEventDAOImpl implements MegaEventDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public Logger daoLog = Logger.getLogger(MegaEventDAOImpl.class);
	
	@Autowired
	AssetMapBean assetMapBean;
	@Autowired
	ChangeStatusMapBean changeStatusMapBean;
	@Autowired
	EventStatusMapBean eventStatusMapBean;
	@Autowired
	RoleMapBean roleMapBean;
	@Autowired
	TaskResultMapBean taskResultMapBean;
	@Autowired
	TaskStatusMapBean taskStatusMapBean;
		
	public Event getEvent(int eventId) {

		daoLog.debug("Querying for Event: " + eventId);
		String sql = "select * from megaevent.megaevent_events_j01 where eventID='" + eventId + "'";
		Map<String, Object> attributes = getJdbcTemplate().queryForMap(sql);
		Event event = new Event();
		event.setId(eventId);
		event.setTitle((String)attributes.get("title"));
		event.setDescription((String)attributes.get("description"));
		event.setEventStatus((String)attributes.get("status"));
		return event;
	}

	public List<Event> getAllEvents() {
		daoLog.debug("Querying for all Events");
		String sql = "select * from megaevent.megaevent_events_j01 order by eventID";
		List<Event> events = new ArrayList<Event>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Event event= new Event();
			event.setId((Integer)row.get("eventID"));
			event.setTitle((String)row.get("title"));
			event.setDescription((String)row.get("description"));
			event.setEventStatus((String)row.get("status"));
			
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
			task.setTaskStatus((String)row.get("task_status"));
			task.setTaskResult((String)row.get("task_result"));
			task.setDependencyId((Integer)row.get("dependency_taskID"));
			task.setEventId((Integer)row.get("eventID"));
			task.setOwnerId((Integer)row.get("ownerID"));
			task.setActivatorId((Integer)row.get("activatorID"));
			task.setValidatorId((Integer)row.get("validatorID"));
			task.setRole((String)row.get("role"));
			task.setDescription(((String)row.get("description")));
			task.setChangeControlNumber((((String)row.get("change_control"))));
			task.setChangeControlStatus((String)row.get("change_status"));
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
	
	public List<Person> getPersons() {
		daoLog.debug("Querying for Persons for All persons");
		String sql = "select * from megaevent.megaevent_persons_j01";
		List<Person> persons = new ArrayList<Person>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Person person = new Person();
			person.setId((Integer)row.get("personID"));
			person.setFirstName((String) row.get("first_name"));
			person.setLastName((String)row.get("last_name"));
			person.setLogin((String)row.get("login"));
			person.setRole((String)row.get("role"));
			person.setWorkPhone((String)row.get("work_phone"));
			person.setCellPhone((String)row.get("cell_phone"));
			person.setPager((String)row.get("pager"));
			persons.add(person);
		}

		return persons;
		
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
			person.setRole((String)row.get("role"));
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
			item.setAssetType((String)row.get("asset_type"));
			items.add(item);
		}
		return items;
	}
	
	
	public List<Event> getClosedEvents() {
		daoLog.debug("Querying for Closed Events");
		String sql = "SELECT * FROM megaevent.megaevent_events_j01 where status='CLOSED'";
		List<Event> events = new ArrayList<Event>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Event event = new Event();
			event.setId((Integer)row.get("eventID"));
			event.setTitle((String)row.get("title"));
			event.setDescription((String)row.get("description"));
			event.setEventStatus((String)row.get("status"));
			events.add(event);
		}
		return events;
	}

	public List<Event> getCanceledEvents() {
		daoLog.debug("Querying for Canceled Events");
		String sql = "SELECT * FROM megaevent.megaevent_events_j01 where status='CANCELED'";
		List<Event> events = new ArrayList<Event>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Event event = new Event();
			event.setId((Integer)row.get("eventID"));
			event.setTitle((String)row.get("title"));
			event.setDescription((String)row.get("description"));
			event.setEventStatus((String)row.get("status"));
			events.add(event);
		}
		return events;
	}

	public List<Event> getInactiveEvents() {
		daoLog.debug("Querying for Inactive Events");
		String sql = "SELECT * FROM megaevent.megaevent_events_j01 where status='CANCELED' or status='CLOSED' or status='NOT_STARTED'";
		List<Event> events = new ArrayList<Event>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Event event = new Event();
			event.setId((Integer)row.get("eventID"));
			event.setTitle((String)row.get("title"));
			event.setDescription((String)row.get("description"));
			event.setEventStatus((String)row.get("status"));
			events.add(event);
		}
		return events;
	}

	public List<Event> getMyAssignedEvents(int personId) {
		List<Event> events = new ArrayList<Event>();
		for (int eventId : getEventIdsByPerson(personId) ) {
			daoLog.debug("Querying for assigned event  " + eventId);
			events.add(getEvent(eventId));
		}
		return events;
	}
	
	private List<Integer> getEventIdsByPerson(int personId) {
		daoLog.debug("Querying for Events assigned to person with Id " + personId);
		String sql = "SELECT * FROM megaevent.megaevent_persons_event_j01 where personID='" + personId + "'";
		List<Integer> eventIds = new ArrayList<Integer>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			eventIds.add((Integer)row.get("eventID"));
		}
		return eventIds;
	}
	
	public List<Task> getMyAssignedTasks(int personId) {
		daoLog.debug("Querying for Tasks for Person ID: " + personId);
		String sql = "select * from megaevent.megaevent_tasks_j01 where ownerID='" + personId + "'";
		List<Task> tasks = new ArrayList<Task>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Task task = new Task();
			task.setId((Integer)row.get("taskID"));
			task.setName((String)row.get("task_name"));
			task.setTaskStatus((String)row.get("task_status"));
			task.setTaskResult((String)row.get("task_result"));
			task.setDependencyId((Integer)row.get("dependency_taskID"));
			task.setEventId((Integer)row.get("eventID"));
			task.setOwnerId((Integer)row.get("ownerID"));
			task.setActivatorId((Integer)row.get("activatorID"));
			task.setValidatorId((Integer)row.get("validatorID"));
			task.setRole((String)row.get("role"));
			task.setDescription(((String)row.get("description")));
			task.setChangeControlNumber((((String)row.get("change_control"))));
			task.setChangeControlStatus((String)row.get("change_status"));
			task.setAssetName((String)row.get("asset_name"));
			tasks.add(task);
		}

		return tasks;
	}

	public List<Task> getMyAssignedTasksForEvent(int personId, int eventId) {
		daoLog.debug("Querying for Tasks for Person ID: " + personId + " Event ID: " + eventId);
		String sql = "select * from megaevent.megaevent_tasks_j01 where eventID='" + eventId + "' and ownerID='" + personId + "'";
		List<Task> tasks = new ArrayList<Task>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Task task = new Task();
			task.setId((Integer)row.get("taskID"));
			task.setName((String)row.get("task_name"));
			task.setTaskStatus((String)row.get("task_status"));
			task.setTaskResult((String)row.get("task_result"));
			task.setDependencyId((Integer)row.get("dependency_taskID"));
			task.setEventId((Integer)row.get("eventID"));
			task.setOwnerId((Integer)row.get("ownerID"));
			task.setActivatorId((Integer)row.get("activatorID"));
			task.setValidatorId((Integer)row.get("validatorID"));
			task.setRole((String)row.get("role"));
			task.setDescription(((String)row.get("description")));
			task.setChangeControlNumber((((String)row.get("change_control"))));
			task.setChangeControlStatus((String)row.get("change_status"));
			task.setAssetName((String)row.get("asset_name"));
			tasks.add(task);
		}

		return tasks;
	}
		

	public List<Task> getMyCompletedTasksForEvent(int personId, int eventId) {

		daoLog.debug("Querying for Closed Tasks for Person ID: " + personId + " for Event ID: " + eventId);
		String sql = "select * from megaevent.megaevent_tasks_j01 where ownerID='" + personId + "' and eventID='" + eventId + "' and task_status='COMPLETED'";
		List<Task> tasks = new ArrayList<Task>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Task task = new Task();
			task.setId((Integer)row.get("taskID"));
			task.setName((String)row.get("task_name"));
			task.setTaskStatus((String)row.get("task_status"));
			task.setTaskResult((String)row.get("task_result"));
			task.setDependencyId((Integer)row.get("dependency_taskID"));
			task.setEventId((Integer)row.get("eventID"));
			task.setOwnerId((Integer)row.get("ownerID"));
			task.setActivatorId((Integer)row.get("activatorID"));
			task.setValidatorId((Integer)row.get("validatorID"));
			task.setRole((String)row.get("role"));
			task.setDescription(((String)row.get("description")));
			task.setChangeControlNumber((((String)row.get("change_control"))));
			task.setChangeControlStatus((String)row.get("change_status"));
			task.setAssetName((String)row.get("asset_name"));
			tasks.add(task);
		}

		return tasks;
	}

	public List<Task> getMyTaskHistory(int personId) {
		daoLog.debug("Querying for Task History for Person ID: " + personId );
		String sql = "select * from megaevent.megaevent_tasks_j01 where ownerID='" + personId + "'";
		List<Task> tasks = new ArrayList<Task>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<?, ?> row : rows) {
			Task task = new Task();
			task.setId((Integer)row.get("taskID"));
			task.setName((String)row.get("task_name"));
			task.setTaskStatus((String)row.get("task_status"));
			task.setTaskResult((String)row.get("task_result"));
			task.setDependencyId((Integer)row.get("dependency_taskID"));
			task.setEventId((Integer)row.get("eventID"));
			task.setOwnerId((Integer)row.get("ownerID"));
			task.setActivatorId((Integer)row.get("activatorID"));
			task.setValidatorId((Integer)row.get("validatorID"));
			task.setRole((String)row.get("role"));
			task.setDescription(((String)row.get("description")));
			task.setChangeControlNumber((((String)row.get("change_control"))));
			task.setChangeControlStatus((String)row.get("change_status"));
			task.setAssetName((String)row.get("asset_name"));
			tasks.add(task);
		}

		return tasks;		
	}
		
	public int addEvent(Event event) {
		daoLog.debug("Adding Event Entitled: " + event.getTitle());
		String event_sql = "INSERT INTO megaevent.events VALUES (default,?,?,?)";
		return getJdbcTemplate().update(event_sql,new Object[] { event.getTitle(),
																 event.getDescription(),
																 getEventStatusId(event.getEventStatus())});
	}

	public int addTask(Task taskInfo) throws Exception {
		daoLog.debug("Adding Task to Event ID: " + taskInfo.getEventId());
		String event_sql = "INSERT INTO megaevent.tasks VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return getJdbcTemplate().update(event_sql,new Object[] { 
																 taskInfo.getName(),
																 getTaskStatusId(taskInfo.getTaskStatus()),
																 getTaskResultId(taskInfo.getTaskResult()),
																 taskInfo.getDependencyId(),
																 taskInfo.getEventId(),
																 taskInfo.getOwnerId(),
																 taskInfo.getActivatorId(),
																 taskInfo.getValidatorId(),
																 getRoleId(taskInfo.getRole()),
																 taskInfo.getDescription(),
																 taskInfo.getChangeControlNumber(),
																 getChangeStatusId(taskInfo.getChangeControlStatus()),
																 getTargetedItemId(taskInfo.getAssetName())
		});
	}

	public int addPerson(Person person) throws Exception {
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

	public int addTargetedItem(TargetedItem targetedItem) throws Exception {

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
																	  event.getEventStatus(),
																	  event.getId()
		});
	}

	public int updateTask(Task taskInfo) throws Exception {
		daoLog.debug("Updating Task : " + taskInfo.getId());
		String task_sql = "UPDATE megaevent.tasks set name=?,task_status=?,task_result=?,dependency_taskID=?,eventID=?,ownerID=?,activatorID=?,validatorID=?,role=?,description=?,change_control=?,change_status=?,targeted_itemID=? where taskID=?";
		return getJdbcTemplate().update(task_sql,new Object[] {taskInfo.getName(),
																 getTaskStatusId(taskInfo.getTaskStatus()),
																 getTaskResultId(taskInfo.getTaskResult()),
																 taskInfo.getDependencyId(),
																 taskInfo.getEventId(),
																 taskInfo.getOwnerId(),
																 taskInfo.getActivatorId(),
																 taskInfo.getValidatorId(),
																 getRoleId(taskInfo.getRole()),
																 taskInfo.getDescription(),
																 taskInfo.getChangeControlNumber(),
																 getChangeStatusId(taskInfo.getChangeControlStatus()),
																 getTargetedItemId(taskInfo.getAssetName()),
																 taskInfo.getId()
		});
	}

	public int updatePerson(Person person) throws Exception {
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
																targetedItem.getAssetType(),
																targetedItem.getId()
		});
	}
	
	private int getEventStatusId(String statusName) {
		Integer key=null;
		for (Entry<Integer,String> entry : eventStatusMapBean.getEventStatusTypes().entrySet() ) {
			if (statusName.equalsIgnoreCase(entry.getValue())){
				key=entry.getKey();
			}
		}
		return key;
	}
	
	private int getTaskStatusId(String taskStatusName) throws InvalidTaskException {
		Integer key = null;
		for (Entry<Integer,String> entry : taskStatusMapBean.getTaskStatusTypes().entrySet() ) {
			if (taskStatusName.equalsIgnoreCase(entry.getValue())){
				key=entry.getKey();
			}
		}
		if (key==null) throw new InvalidTaskException("Not a valid Task Status");
		return key;

	}
	
	private int getChangeStatusId(String changeStatusName) throws InvalidChangeStatusException {
		Integer key= null;
		for (Entry<Integer,String> entry : changeStatusMapBean.getChangeStatusTypes().entrySet() ) {
			if (changeStatusName.equalsIgnoreCase(entry.getValue())){
				key=entry.getKey();
			}
		}
		if (key==null) throw new InvalidChangeStatusException("Not a valid Change Status");
		return key;
	}

	private int getTaskResultId(String taskResultName) throws InvalidTaskException {
		Integer key= null;
		for (Entry<Integer,String> entry : taskResultMapBean.getTaskResultTypes().entrySet() ) {
			if (taskResultName.equalsIgnoreCase(entry.getValue())){
				key=entry.getKey();
			}
		}
		if (key==null) throw new InvalidTaskException("Not a valid Task Result");
		return key;
	}
	
	private int getRoleId(String roleName) throws InvalidRoleException {
		Integer key=null;
		
		for (Entry<Integer,String> entry : roleMapBean.getRoleTypes().entrySet() ) {
			if (roleName.equalsIgnoreCase(entry.getValue())){
				key=entry.getKey();
			}
		}
		if (key==null) throw new InvalidRoleException("Not a valid role");
		
		return key;
	}

	private int getAssetTypeId(String assetTypeName) throws InvalidAssetTypeException {
		Integer key=null;
		for (Entry<Integer,String> entry : assetMapBean.getAssetTypes().entrySet() ) {
			if (assetTypeName.equalsIgnoreCase(entry.getValue())){
				key=entry.getKey();
			}
		}
		if (key==null) throw new InvalidAssetTypeException("Not a valid Asset Type");
		return key;
	}
	
	private int getTargetedItemId(String assetName) throws InvalidTargetedItemException {
        Integer serverId= null;
		String target_sql = "select targeted_itemsID from megaevent.targeted_items where asset_name=? limit 1";

        try {
            serverId = getJdbcTemplate().queryForInt(target_sql,new Object[] {assetName});

        } catch (Exception e) {
            throw new InvalidTargetedItemException("Not a valid Targeted Item");
        }
        if (serverId==null) throw new InvalidTargetedItemException("Not a valid Targeted Item");
        return serverId;
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
