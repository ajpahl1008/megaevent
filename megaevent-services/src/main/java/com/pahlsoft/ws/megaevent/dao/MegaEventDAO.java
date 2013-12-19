package com.pahlsoft.ws.megaevent.dao;

import java.util.List;

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
	public int addEvent(Event event);
	public int addTask(Task taskInfo, int eventId);
	public int addPerson(Person person);
	public int addTargetedItem(TargetedItem targetedItem);
	
	// The Updaters
	public int updateEvent(Event event);
	public int updateTask(Task taskInfo);
	public int updatePerson(Person person);
	public int updateTargetedItem(TargetedItem targetedItem);
	
	
	
}
