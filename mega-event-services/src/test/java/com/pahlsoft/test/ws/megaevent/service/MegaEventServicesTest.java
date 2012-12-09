package com.pahlsoft.test.ws.megaevent.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pahlsoft.ws.megaevent.generated.Event;
import com.pahlsoft.ws.megaevent.generated.Person;
import com.pahlsoft.ws.megaevent.generated.Task;
import com.pahlsoft.ws.megaevent.service.MegaEventServicesEndpoint;

public class MegaEventServicesTest {

	Person person;
	Event event;
	Task task;
	MegaEventServicesEndpoint meTest;

	@Before 
	public void initialize() {
		 person = new Person();
		 event = new Event();
		 task = new Task();
		 meTest = new MegaEventServicesEndpoint();
		
	}
	
	@Test
	public void basicTestThatDoesNothing() {
		String hi = "hi";
		assert (hi == "hi");
	}


}
