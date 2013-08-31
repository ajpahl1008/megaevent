package com.pahlsoft.test.ws.megaevent.service;

import static org.junit.Assert.*;

import com.pahlsoft.ws.megaevent.dao.MegaEventDAO;
import com.pahlsoft.ws.megaevent.exceptions.InvalidEventException;
import com.pahlsoft.ws.megaevent.generated.EventStatus;
import org.junit.Before;
import org.junit.Test;

import com.pahlsoft.ws.megaevent.generated.Event;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:testApplicationContext.xml","classpath:TestMegaEvent-EventDAO.xml","classpath:TestMegaEvent-DataSource.xml"})
public class MegaEventServicesTest {


    @Autowired
    MegaEventDAO megaEventDAO;


	@Before 
	public void initialize() {

	}
	
	@Test
	public void basicTestThatDoesNothing() {
		String hi = "hi";
		assert (hi == "hi");
	}

    @Test
    public void addEventShouldPass() throws Exception {
        Event event = new Event();
        event.setDescription("This is a test event 123");
        event.setEventStatus(EventStatus.GREEN);
        event.setTitle("TestEvent123");
        assertEquals(1, megaEventDAO.addEvent(event));
    }

    @Test(expected = InvalidEventException.class)
    public void addEventWithNoDescription() throws Exception{
        Event event = new Event();
        event.setDescription("");
        event.setEventStatus(EventStatus.GREEN);
        event.setTitle("TitleText");
        megaEventDAO.addEvent(event);
    }

    @Test(expected = InvalidEventException.class)
    public void addEventWithNoTitle() throws Exception{
        Event event = new Event();
        event.setDescription("EventDescriptionTest");
        event.setEventStatus(EventStatus.GREEN);
        event.setTitle("");
        megaEventDAO.addEvent(event);
    }

    @Test(expected = InvalidEventException.class)
    public void addEventWithNullStatus() throws Exception{
        Event event = new Event();
        event.setDescription("NullEventDescriptionTest");
        event.setEventStatus(null);
        event.setTitle("NullEventStatus Test");
        megaEventDAO.addEvent(event);
    }

}
