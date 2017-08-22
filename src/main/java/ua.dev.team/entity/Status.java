package ua.dev.team.entity;

import lombok.Getter;
import lombok.Setter;
import ua.dev.team.enums.StatusEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "statuses")
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusEnum title;

    @Column
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status", cascade = CascadeType.REMOVE)
    private List<Task> tasks = new ArrayList<>();
}
