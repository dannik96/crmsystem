package cz.cvut.fel.groscdan.crmsystem.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractState extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;
}