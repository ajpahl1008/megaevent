package com.pahlsoft.megaevent.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/manager")
public class ManagerController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		return "manager";
		
 
	}
 
}