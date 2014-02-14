package com.pahlsoft.megaevent.ui.controller;

import com.pahlsoft.megaevent.executor.EventClientImpl;
import com.pahlsoft.megaevent.ws.generated.Task;
import com.pahlsoft.megaevent.ws.generated.TaskArray;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuditorTaskController {

    Logger LOG = Logger.getLogger(AuditorTaskController.class);


    @RequestMapping(value = "/searchTaskGrid", method = RequestMethod.POST)
    public ModelMap searchEventGrid(@ModelAttribute(value="eventNumber") int eventNumber, ModelMap modelMap) {
        EventClientImpl ecl = new EventClientImpl();
        TaskArray tasks = new TaskArray();
        Task task = new Task();

        try {
            task = ecl.getTask(eventNumber);

             if (task.getTaskStatus() == null) {
                task.setId(0);
                task.setDescription("");
                 task.setActivatorId(0);
                 task.setAssetName("");
                 task.setChangeControlNumber("");
                 task.setChangeControlStatus("");
                 task.setDependencyId(0);
                 task.setEventId(0);
                 task.setName("");
                 task.setOwnerId(0);
                 task.setRole("");
                 task.setValidatorId(0);

                tasks.getItem().add(task);
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