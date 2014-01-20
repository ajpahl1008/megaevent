package com.pahlsoft.megaevent.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pahlsoft.megaevent.executor.EventClientImpl;
import com.pahlsoft.megaevent.ws.generated.EventArray;

 
@Controller
public class AuditorController {
 
	@RequestMapping("/auditor")
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
 
	@RequestMapping(value = "/gridRefresh", method = RequestMethod.GET)
	public String updateGrid(ModelMap model) {
		EventClientImpl ecl = new EventClientImpl();
		EventArray events = null;
		try {
			events = ecl.getAllEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}
        model.addAttribute("eventModel" , events.getItem());
        System.out.println("Refreshing Grid");
		return "eventGrid";
	}
	
		
}