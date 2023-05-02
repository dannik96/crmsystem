package cz.cvut.fel.groscdan.crmsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPerson extends AbstractEntity {

    @Column
    protected String email;

    @Column
    protected String login;

    @Column
    protected String name;

    @Column
    protected String surname;

    @Column
    protected String phone;
}
