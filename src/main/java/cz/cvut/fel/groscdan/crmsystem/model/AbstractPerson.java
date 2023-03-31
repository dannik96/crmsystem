package cz.cvut.fel.groscdan.crmsystem.model;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPerson extends AbstractEntity {

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phone;
}
