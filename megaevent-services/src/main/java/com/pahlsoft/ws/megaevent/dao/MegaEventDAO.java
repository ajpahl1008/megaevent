package com.pahlsoft.ws.megaevent.dao;

import java.util.List;
import java.util.Map;

import com.pahlsoft.ws.megaevent.generated.Event;
import com.pahlsoft.ws.megaevent.generated.Person;
import com.pahlsoft.ws.megaevent.generated.TargetedItem;
import com.pahlsoft.ws.megaevent.generated.Task;

public interface MegaEventDAO {
	// The Getters
	public Event getEvent(int eventId);
	public List<Event> getEvents();
	
	public Task getTask(int taskId);  
	public List<Task> getTasks(int eventId);
	
	public Person getPerson(int personId);
	public List<Person> getPersons(int eventId);
	public List<Person> getPersons();
	
	public TargetedItem getTargetedItem(int taskId);
	public List<TargetedItem> getTargetedItems(int eventId);
	
	// The Adders
	public int addEvent(Event event) throws Exception;
	public int addTask(Task taskInfo) throws Exception;
	public int addPerson(Person person) throws Exception;
	public int addTargetedItem(TargetedItem targetedItem) throws Exception;
	
	// The Updaters
	public int updateEvent(Event event) throws Exception;
	public int updateTask(Task taskInfo) throws Exception;
	public int updatePerson(Person person) throws Exception ;
	public int updateTargetedItem(TargetedItem targetedItem) throws Exception;
	
	
	
}
