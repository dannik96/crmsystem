package cz.cvut.fel.groscdan.crmsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@MappedSuperclass
public abstract class AbstractState extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;
}