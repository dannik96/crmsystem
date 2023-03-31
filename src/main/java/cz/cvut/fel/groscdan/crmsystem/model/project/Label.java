package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@Table(name = "label")
public class Label extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany
    private List<Task> tasks;
}