package com.pahlsoft.test.ws.megaevent.service;

import static org.testng.AssertJUnit.*;


import com.pahlsoft.ws.megaevent.generated.Event;
import com.pahlsoft.ws.megaevent.generated.Person;
import com.pahlsoft.ws.megaevent.generated.Task;
import com.pahlsoft.ws.megaevent.service.MegaEventServicesEndpoint;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MegaEventServicesTest {

	Person person;
	Event event;
	Task task;
	MegaEventServicesEndpoint meTest;

	@BeforeClass
	public void initialize() {
		 person = new Person();
		 event = new Event();
		 task = new Task();
		 meTest = new MegaEventServicesEndpoint();

	}

	@Test(threadPoolSize = 3, invocationCount = 1, timeOut = 1)
	public void basicLoadTestThatDoesNothing() {
		String hi = "hi";
		assert (hi == "hi");
	}


}
