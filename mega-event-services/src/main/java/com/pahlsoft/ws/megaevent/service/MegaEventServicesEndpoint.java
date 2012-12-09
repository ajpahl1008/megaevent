package com.pahlsoft.ws.megaevent.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.pahlsoft.ws.megaevent.dao.MegaEventDAO;
import com.pahlsoft.ws.megaevent.generated.Event;
import com.pahlsoft.ws.megaevent.generated.Person;
import com.pahlsoft.ws.megaevent.generated.TargetedItem;
import com.pahlsoft.ws.megaevent.generated.Task;

@Service
@WebService(name ="MegaEventServiceEndpoint",targetNamespace="http://megaevent.ws.pahlsoft.com")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class MegaEventServicesEndpoint extends SpringBeanAutowiringSupport {
	
	// Required to Autowire the DAOs into a JAX-WS service
		@PostConstruct
		public void init() {
		    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}
	
	@Autowired
	MegaEventDAO megaEventDao;
	 
	public Logger serviceEndpointLogger = Logger.getLogger(MegaEventServicesEndpoint.class);
	
	@WebMethod
	public int addTask(@WebParam(name="taskInfo", targetNamespace="http://megaevent.ws.pahlsoft.com") Task taskInfo, 
					   @WebParam(name="eventId", targetNamespace="http://megaevent.ws.pahlsoft.com") int eventId) throws Exception {
		serviceEndpointLogger.debug("addTask");
		return megaEventDao.addTask(taskInfo, eventId);
	}
	
	@WebMethod
	public int addEvent(@WebParam(name="eventInfo", targetNamespace="http://megaevent.ws.pahlsoft.com") Event eventInfo) throws Exception {
		serviceEndpointLogger.debug("Me: addEvent");
		return megaEventDao.addEvent(eventInfo);
	}
	
	@WebMethod
	public int addPerson(@WebParam(name="personInfo", targetNamespace="http://megaevent.ws.pahlsoft.com") Person personInfo) throws Exception {
		serviceEndpointLogger.debug("Me: addPerson");
		return megaEventDao.addPerson(personInfo);
	}
	
	@WebMethod
	public int addTargetedItem(@WebParam(name="targetedItemInfo", targetNamespace="http://megaevent.ws.pahlsoft.com") TargetedItem itemInfo) throws Exception {
		serviceEndpointLogger.debug("Me: addTargetedItem");
		return megaEventDao.addTargetedItem(itemInfo);
	}
	
	@WebMethod
	public int updateEvent(@WebParam(name="eventInfo", targetNamespace="http://megaevent.ws.pahlsoft.com") Event eventInfo) throws Exception {
		serviceEndpointLogger.debug("Me: updateEvent");
		return megaEventDao.updateEvent(eventInfo);
	}

	@WebMethod
	public int updateTask(@WebParam(name="taskInfo", targetNamespace="http://megaevent.ws.pahlsoft.com") Task taskInfo) throws Exception {
		serviceEndpointLogger.debug("Me: updateTask");
		return megaEventDao.updateTask(taskInfo);
	}
	
	
	@WebMethod
	public int updatePerson(@WebParam(name="personInfo", targetNamespace="http://megaevent.ws.pahlsoft.com") Person personInfo) throws Exception {
		serviceEndpointLogger.debug("Me: updatePerson");
		return megaEventDao.updatePerson(personInfo);
	}
	
	@WebMethod
	public int updateTargetedItem(@WebParam(name="targetedItemInfo", targetNamespace="http://megaevent.ws.pahlsoft.com") TargetedItem targetedItemInfo) throws Exception {
		serviceEndpointLogger.debug("Me: updateTargetedItem");
		return megaEventDao.updateTargetedItem(targetedItemInfo);
	}
	
	@WebMethod
	public Task getTask(@WebParam(name="taskId", targetNamespace="http://megaevent.ws.pahlsoft.com") int taskId  ) throws Exception {
		serviceEndpointLogger.debug("Me: getTask");
		return megaEventDao.getTask(taskId);
	}
	
	@WebMethod
	public List<Task> getTasks(@WebParam(name="eventId", targetNamespace="http://megaevent.ws.pahlsoft.com") int eventId) throws Exception {
		serviceEndpointLogger.debug("Me: getTask");
		return megaEventDao.getTasks(eventId);
		
	}
	
	@WebMethod
	public Event getEvent(@WebParam(name="eventId", targetNamespace="http://megaevent.ws.pahlsoft.com") int eventId) throws Exception {
		serviceEndpointLogger.debug("Me: getEvent");
		return megaEventDao.getEvent(eventId); 
	}
	
	@WebMethod
	public List<Event> getEvents() throws Exception {
		serviceEndpointLogger.debug("Me: getEvent");
		return megaEventDao.getEvents(); 
	}
	
	@WebMethod
	public Person getPerson(@WebParam(name="personId", targetNamespace="http://megaevent.ws.pahlsoft.com") int personId) throws Exception {
		serviceEndpointLogger.debug("Me: getPerson");
		return megaEventDao.getPerson(personId);
	}
	
	@WebMethod
	public List<Person> getPersons(@WebParam(name="eventId", targetNamespace="http://megaevent.ws.pahlsoft.com") int eventId) throws Exception {
		serviceEndpointLogger.debug("Me: getPersons");
		return megaEventDao.getPersons(eventId);
	}
	
	@WebMethod
	public TargetedItem getTargetedItem(@WebParam(name="taskId", targetNamespace="http://megaevent.ws.pahlsoft.com") int taskId) throws Exception {
		serviceEndpointLogger.debug("Me: getTargetedItem");
		return megaEventDao.getTargetedItem(taskId);
	}

	@WebMethod
	public List<TargetedItem> getTargetedItems(@WebParam(name="eventId", targetNamespace="http://megaevent.ws.pahlsoft.com") int eventId) throws Exception {
		serviceEndpointLogger.debug("Me: getTargetedItems");
		return megaEventDao.getTargetedItems(eventId);
	}
	
}
