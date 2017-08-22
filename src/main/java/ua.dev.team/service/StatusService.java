package ua.dev.team.service;

import ua.dev.team.entity.Status;
import ua.dev.team.enums.StatusEnum;

public interface StatusService extends MainService<Status> {
    Status get(StatusEnum title);
    Status getDefault();
}
