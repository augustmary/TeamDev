package ua.dev.team.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.dev.team.entity.Task;
import ua.dev.team.entity.User;
import ua.dev.team.service.TaskService;
import ua.dev.team.service.UserService;

@Controller
@RequestMapping(value = "/")
public class TaskController {

    private TaskService taskService;
    private UserService userService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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
    public ModelAndView addTask(@RequestParam String title,
                                @RequestParam String content,
                                ModelAndView modelAndView) {
        Task task = new Task();
        task.setTitle(title);
        task.setContent(content);
        User maria = userService.findByUsername("Maria");
        task.setAuthor(maria);
        taskService.update(task);
        modelAndView.setViewName("tasks");
        return modelAndView;
    }

}
