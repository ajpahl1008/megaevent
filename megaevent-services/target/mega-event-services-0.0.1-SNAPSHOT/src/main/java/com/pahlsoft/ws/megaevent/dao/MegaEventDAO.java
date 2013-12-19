package com.pahlsoft.ws.megaevent.dao;

import java.util.List;

import com.pahlsoft.ws.megaevent.exceptions.InvalidEventException;
import com.pahlsoft.ws.megaevent.exceptions.InvalidPersonException;
import com.pahlsoft.ws.megaevent.exceptions.InvalidTargetedItemException;
import com.pahlsoft.ws.megaevent.exceptions.InvalidTaskException;
import com.pahlsoft.ws.megaevent.generated.Event;
import com.pahlsoft.ws.megaevent.generated.Person;
import com.pahlsoft.ws.megaevent.generated.TargetedItem;
import com.pahlsoft.ws.megaevent.generated.Task;

public interface MegaEventDAO {
	// The Getters
	public Event getEvent(int eventId) throws InvalidEventException;
	public List<Event> getEvents() throws InvalidEventException;
	public Task getTask(int taskId) throws InvalidTaskException;
	public List<Task> getTasks(int eventId) throws InvalidTaskException;
	public Person getPerson(int personId) throws InvalidPersonException;
	public List<Person> getPersons(int eventId) throws InvalidPersonException;
	public TargetedItem getTargetedItem(int taskId) throws InvalidTargetedItemException;
	public List<TargetedItem> getTargetedItems(int eventId) throws InvalidTargetedItemException;
	
	// The Adders
	public int addEvent(Event event) throws InvalidEventException;
	public int addTask(Task taskInfo, int eventId) throws InvalidTaskException;
	public int addPerson(Person person) throws InvalidPersonException;
	public int addTargetedItem(TargetedItem targetedItem) throws InvalidTargetedItemException;
	
	// The Updaters
	public int updateEvent(Event event) throws InvalidEventException;
	public int updateTask(Task taskInfo) throws InvalidTaskException;
	public int updatePerson(Person person) throws InvalidPersonException;
	public int updateTargetedItem(TargetedItem targetedItem) throws InvalidTargetedItemException;
	
	
	
}
