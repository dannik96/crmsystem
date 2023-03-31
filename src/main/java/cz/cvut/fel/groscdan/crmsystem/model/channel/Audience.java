package cz.cvut.fel.groscdan.crmsystem.model.channel;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import javax.persistence.*;


import java.util.List;

@Entity
@Table(name = "audience")
public class Audience extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany
    private List<Project> projects;

}