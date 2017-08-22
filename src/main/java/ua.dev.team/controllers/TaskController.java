package ua.dev.team.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.dev.team.entity.Task;
import ua.dev.team.service.StatusService;
import ua.dev.team.service.TaskService;
import ua.dev.team.service.UserService;

@Controller
@RequestMapping(value = "/")
public class TaskController {

    private TaskService taskService;
    private UserService userService;
    private StatusService statusService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ModelAndView viewAllProducts(ModelAndView modelAndView) {
        modelAndView.addObject("tasks", taskService.getAll());
        modelAndView.setViewName("tasks");
        return modelAndView;
    }

    @RequestMapping(value = "/add_page", method = RequestMethod.GET)
    public ModelAndView viewAddTaskPage(ModelAndView modelAndView) {
        modelAndView.setViewName("add_task");
        return modelAndView;
    }

    @RequestMapping(value = "/add_task", method = RequestMethod.POST)
    public String addTask(@RequestParam String title,
                                @RequestParam String content,
                                ModelAndView modelAndView) {
        Task task = new Task();
        task.setTitle(title);
        task.setContent(content);
        task.setStatus(statusService.getDefault());
        task.setAuthor(userService.findByUsername("Maria"));
        taskService.update(task);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/update_task", method = RequestMethod.POST)
    public String editTask(@RequestParam long id, @RequestParam String title,
                          @RequestParam String content) {
        Task task = taskService.get(id);
        task.setTitle(title);
        task.setContent(content);
       // task.setStatus();
       // task.setAuthor(userService.findByUsername("Maria"));
        taskService.update(task);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/task_{id}", method = RequestMethod.GET)
    public ModelAndView getEditTaskPage(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        Task task = taskService.get(id);
        modelAndView.setViewName("edit_task");
        modelAndView.addObject(task);
        return modelAndView;
    }

}
