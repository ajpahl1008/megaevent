package com.pahlsoft.megaevent.ui.controller;

import com.pahlsoft.megaevent.executor.EventClientImpl;
import com.pahlsoft.megaevent.ws.generated.EventArray;
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

    @RequestMapping(value={"/tasks"})
    public String showAuditor(ModelMap model) {
        EventClientImpl ecl = new EventClientImpl();
        TaskArray tasks = new TaskArray();
        try {
            tasks = ecl.getTasks(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("taskModel" , tasks.getItem());
        return "auditor";
    }


    @RequestMapping(value = {"/taskGrid"}, method = RequestMethod.POST)
    public ModelMap searchTaskGrid(@ModelAttribute(value="taskNumber") int taskNumber, ModelMap modelMap) {
        EventClientImpl ecl = new EventClientImpl();
        TaskArray tasks = new TaskArray();
        Task task = new Task();

        try {
            task = ecl.getTask(taskNumber);

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
                modelMap.addAttribute("taskModel", tasks.getItem());
            } else {
                 tasks.getItem().add(task);
                 modelMap.addAttribute("taskModel" , tasks.getItem());
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.debug("Searching for Task" + task.getId());
        return modelMap;
    }

}