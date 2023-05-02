package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractState;

import javax.persistence.*;


import java.util.List;

@Entity
@Table(name = "task_labels")
public class TaskLabel extends AbstractState {

    @ManyToMany
    private List<Task> tasks;
}