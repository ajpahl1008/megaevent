package com.pahlsoft.megaevent.ui.controller;

import com.pahlsoft.megaevent.ws.generated.Event;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pahlsoft.megaevent.executor.EventClientImpl;
import com.pahlsoft.megaevent.ws.generated.EventArray;

@Controller
public class AuditorEventController {

    Logger LOG = Logger.getLogger(AuditorEventController.class);
 
	@RequestMapping(value={"/auditor","/events"})
	public String showAuditor(ModelMap model) {
		EventClientImpl ecl = new EventClientImpl();
		EventArray events = new EventArray();
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
		EventArray events = new EventArray();
		try {
			events = ecl.getAllEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}
        model.addAttribute("eventModel" , events.getItem());
        LOG.debug("Retrieving Update" );
		return "eventGrid";
	}

    @RequestMapping(value = "/searchGrid", method = RequestMethod.POST)
    public ModelMap searchEventGrid(@ModelAttribute(value="eventNumber") int eventNumber, ModelMap modelMap) {
        EventClientImpl ecl = new EventClientImpl();
        EventArray events = new EventArray();
        Event event = new Event();

        try {
            event = ecl.getEvent(eventNumber);

             if (event.getEventStatus() == null) {
                event.setTitle("");
                event.setId(0);
                event.setEventStatus("");
                event.setDescription("");
                events.getItem().add(event);
                modelMap.addAttribute("eventModel" , events.getItem());
            } else {
                 events.getItem().add(event);
                 modelMap.addAttribute("eventModel" , events.getItem());
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.debug("Searching for Event" + event.getId());
        return modelMap;
    }

}