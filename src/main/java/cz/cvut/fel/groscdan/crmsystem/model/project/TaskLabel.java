package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "task_labels")
public class TaskLabel extends AbstractState {

    @ManyToMany(mappedBy = "taskLabels")
    private List<Task> tasks;

    public void removeTaskLabel(Task task) {
        tasks.remove(task);
        task.removeLabel(this);
    }
}