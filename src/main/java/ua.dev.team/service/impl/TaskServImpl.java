package ua.dev.team.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dev.team.entity.Task;
import ua.dev.team.dao.TaskDAO;
import ua.dev.team.service.TaskService;

import java.util.List;

@Service
public class TaskServImpl implements TaskService {

    TaskDAO taskDAO;

    @Autowired
    public TaskServImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public Task get(long id) {
        return taskDAO.findById(id);
    }

    public void delete(long id) {
        taskDAO.deleteById(id);
    }

    /*public List<Task> findByDateOrderByCrtDate(Date crtdate) {
        return taskRepository.findTasksByCrtTime((java.sql.Date) crtdate);
    }*/

    public Long update(Task entity) {
        taskDAO.save(entity);
        return entity.getId();
    }

    public List<Task> getAll() {
        return taskDAO.findAll();
    }
}
