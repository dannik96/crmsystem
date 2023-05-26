package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractPerson;

import javax.persistence.*;

import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter()
@Setter
@RequiredArgsConstructor
public class Person extends AbstractPerson {

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Task> tasks;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    public Person(Person person) {
        this(person.id, person.email, person.login, person.name, person.surname, person.phone);
    }
    public Person(User user) {
        super();
        this.login = user.getUsername();
        this.email = user.getEmail();
        this.user = user;
    }

    public Person(Long id, String email, String login, String name, String surname, String phone) {
        super();
        this.id = id;
        this.email = email;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return id != null && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}