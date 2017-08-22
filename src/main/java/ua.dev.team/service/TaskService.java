package ua.dev.team.service;

import ua.dev.team.entity.Task;

public interface TaskService extends MainService<Task> {
    Task get(long id);
    void delete(long id);
    Long update(Task task);
}
