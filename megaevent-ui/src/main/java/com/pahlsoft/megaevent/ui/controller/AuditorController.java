package com.pahlsoft.megaevent.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pahlsoft.megaevent.executor.EventClientImpl;
import com.pahlsoft.megaevent.ws.generated.EventArray;

 
@Controller
@RequestMapping("/auditor")
public class AuditorController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		EventClientImpl ecl = new EventClientImpl();
		EventArray events = null;
		try {
			events = ecl.getAllEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}
        model.addAttribute("eventModel" , events.getItem());
		return "auditor";
		
 
	}
 
}