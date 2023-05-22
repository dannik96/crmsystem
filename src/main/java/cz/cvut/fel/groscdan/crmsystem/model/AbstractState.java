package cz.cvut.fel.groscdan.crmsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractState extends AbstractEntity {

    @Column
    protected String name;

    @Column
    protected String description;

    @Column(columnDefinition = "boolean default true")
    protected Boolean deletable = true;
}