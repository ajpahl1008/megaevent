package com.pahlsoft.megaevent.executor;

import com.pahlsoft.megaevent.ws.generated.Event;
import com.pahlsoft.megaevent.ws.generated.EventArray;
import com.pahlsoft.megaevent.ws.generated.Exception_Exception;
import com.pahlsoft.megaevent.ws.generated.MegaEventServiceEndpoint;
import com.pahlsoft.megaevent.ws.generated.MegaEventServicesEndpointService;
import com.pahlsoft.megaevent.ws.generated.Person;
import com.pahlsoft.megaevent.ws.generated.PersonArray;
import com.pahlsoft.megaevent.ws.generated.TargetedItem;
import com.pahlsoft.megaevent.ws.generated.TargetedItemArray;
import com.pahlsoft.megaevent.ws.generated.Task;
import com.pahlsoft.megaevent.ws.generated.TaskArray;


public class EventClientImpl implements MegaEventServiceEndpoint {

	MegaEventServicesEndpointService me = new MegaEventServicesEndpointService();
	
	public PersonArray getAllPersons() throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getAllPersons();
	}

	public Event getEvent(int eventId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getEvent(eventId);
	}

	public TaskArray getMyAssignedTasksForEvent(int personId, int eventId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getMyAssignedTasksForEvent(personId, eventId);
	}

	public int updateTargetedItem(TargetedItem targetedItemInfo) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().updateTargetedItem(targetedItemInfo);
	}

	public EventArray getClosedEvents() throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getClosedEvents();
	}

	public Task getTask(int taskId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getTask(taskId);
	}

	public int updatePerson(Person personInfo) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().updatePerson(personInfo);
	}

	public TaskArray getMyAssignedTasks(int personId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getMyAssignedTasks(personId);
	}

	public EventArray getMyAssignedEvents(int personId)	throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getMyAssignedEvents(personId);
	}

	public TaskArray getTasks(int eventId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getTasks(eventId);
	}

	public TargetedItemArray getTargetedItems(int eventId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getTargetedItems(eventId);
	}

	public int updateEvent(Event eventInfo) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().updateEvent(eventInfo);
	}

	public Person getPerson(int personId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getPerson(personId);
	}

	public int addEvent(Event eventInfo) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().addEvent(eventInfo);
	}

	public EventArray getCanceledEvents() throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getCanceledEvents();
	}

	public TaskArray getMyTaskHistory(int personId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getMyTaskHistory(personId);
	}

	public TargetedItem getTargetedItem(int taskId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getTargetedItem(taskId);
	}

	public TaskArray getMyCompletedTasksForEvent(int personId, int eventId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getMyCompletedTasksForEvent(personId, eventId);
	}

	public int addPerson(Person personInfo) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().addPerson(personInfo);
	}

	public int addTargetedItem(TargetedItem targetedItemInfo) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().addTargetedItem(targetedItemInfo);
	}

	public int addTask(Task taskInfo) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().addTask(taskInfo);
	}

	public EventArray getAllEvents() throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getAllEvents();
	}

	public PersonArray getInvolvedPersons(int eventId) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getInvolvedPersons(eventId);
	}

	public int updateTask(Task taskInfo) throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().updateTask(taskInfo);
	}

	public EventArray getInactiveEvents() throws Exception_Exception {
		return me.getMegaEventServiceEndpointPort().getInactiveEvents();
	}

	public void init() {
		
	}
	
	
	
}
