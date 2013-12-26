package com.pahlsoft.megaevent.ui.controller;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pahlsoft.megaevent.executor.EventClientImpl;
import com.pahlsoft.megaevent.ws.Event;
 
@Controller
@RequestMapping("/auditor")
public class AuditorController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		EventClientImpl ecl = new EventClientImpl();
		Event[] event = null;
		try {
			event = ecl.getEvents();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		List<Event> events = Arrays.asList(event);
        model.addAttribute("eventModel" , events);
		return "auditor";
		
 
	}
 
}