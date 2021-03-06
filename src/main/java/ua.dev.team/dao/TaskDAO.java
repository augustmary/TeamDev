package ua.dev.team.dao;

import org.springframework.stereotype.Repository;
import ua.dev.team.entity.Task;

@Repository
public interface TaskDAO extends MainDAO<Task, Long> {

    Task findById(long id);

    void deleteById(long id);
    /*@Query("SELECT t FROM tasks t WHERE t.crtdate = ?1 ORDER BY t.crtdate ASC")
    List<Task> findTasksByCrtTime(Date dummyVal);*/
}