package ua.dev.team.service;

import ua.dev.team.entity.Task;

public interface TaskService extends MainService<Task> {
    Task get(String number);
    void delete(String number);
    Long update(Task task);
}
