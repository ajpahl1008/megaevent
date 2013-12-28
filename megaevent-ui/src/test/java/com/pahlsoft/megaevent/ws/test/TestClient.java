package com.pahlsoft.megaevent.ws.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pahlsoft.megaevent.executor.EventClientImpl;


public class TestClient {
	
	EventClientImpl eci;
	
	@Before
	public void setup() {
		eci = new EventClientImpl();
	}

	@Test
	public void test() throws Exception {
		assertEquals("SecondEventEver",eci.getEvent(1).getDescription());
	}

}
