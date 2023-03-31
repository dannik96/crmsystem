package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import javax.persistence.*;


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