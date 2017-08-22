package ua.dev.team.dao;

import ua.dev.team.entity.Status;
import ua.dev.team.enums.StatusEnum;

public interface StatusDAO extends MainDAO<Status   , Long> {
    /**
     * Возвращает статус из базы даных по названию, которое может принимать
     * одно из значений перечисления {@link StatusEnum}.
     *
     * @param title Название статуса.
     * @return Объект класса {@link StatusEnum} - статус с уникальным названием.
     */
    Status findByTitle(StatusEnum title);

}
