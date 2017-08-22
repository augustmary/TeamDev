package ua.dev.team.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dev.team.dao.StatusDAO;
import ua.dev.team.entity.Status;
import ua.dev.team.enums.StatusEnum;
import ua.dev.team.service.StatusService;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    StatusDAO statusDAO;

    @Autowired
    public StatusServiceImpl(StatusDAO statusDAO) {
        this.statusDAO = statusDAO;
    }

    @Override
    public Status get(StatusEnum title) {
        return statusDAO.findByTitle(title);
    }

    @Override
    public Status getDefault() {
        return statusDAO.findOne((long) 1);
    }

    @Override
    public List<Status> getAll() {
        return statusDAO.findAll();
    }
}
