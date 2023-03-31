package cz.cvut.fel.groscdan.crmsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;

    @Column
    protected LocalDateTime created;

    @Column
    protected LocalDateTime modified;

    public AbstractEntity() {
    }
}

