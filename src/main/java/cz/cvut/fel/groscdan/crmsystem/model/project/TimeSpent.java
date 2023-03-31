package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import javax.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "time_spent")
public class TimeSpent extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person person;

    @Column
    private LocalDate date;

    @Column
    private Integer time;



}