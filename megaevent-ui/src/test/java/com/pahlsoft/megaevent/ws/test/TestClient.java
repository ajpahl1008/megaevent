package com.pahlsoft.megaevent.ws.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

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
	public void test() throws RemoteException {
		assertEquals("SecondEventEver",eci.getEvent(1).getDescription());
	}

}
