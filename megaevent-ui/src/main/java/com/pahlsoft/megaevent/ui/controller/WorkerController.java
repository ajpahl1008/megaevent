package com.pahlsoft.megaevent.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/worker")
public class WorkerController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
//		EventClientImpl ecl = new EventClientImpl();
//		Event[] event = null;
//		try {
//			event = ecl.getEvents();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//
//		List<Event> events = Arrays.asList(event);
//        model.addAttribute("eventModel" , events);
		return "worker";
		
 
	}
 
}