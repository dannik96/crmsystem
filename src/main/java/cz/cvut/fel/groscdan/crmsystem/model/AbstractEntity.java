package cz.cvut.fel.groscdan.crmsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

