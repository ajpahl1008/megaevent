package com.pahlsoft.megaevent.ws.test;

import static org.junit.Assert.*;

import com.pahlsoft.megaevent.ws.generated.Event;
import org.junit.Before;
import org.junit.Test;

import com.pahlsoft.megaevent.executor.EventClientImpl;

import java.util.UUID;


public class TestClient {
	
	EventClientImpl eci;
    Event event;

	@Before
	public void setup() {
		eci = new EventClientImpl();
        event = new Event();
	}

    @Test
    public void addNewEventShouldPass() throws Exception {
        event.setDescription("UnitTestDescription");
        event.setEventStatus("GREEN");
        event.setTitle("TestEvent: " + UUID.randomUUID());
        assertEquals(1, eci.addEvent(event));
    }

	@Test
	public void test() throws Exception {
		assertEquals("ThirdEventEver",eci.getEvent(2).getDescription());
	}



}
