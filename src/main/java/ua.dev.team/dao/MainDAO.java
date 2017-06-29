package ua.dev.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MainDAO<T, E extends Number> extends JpaRepository<T, E> {
}
