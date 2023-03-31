package cz.cvut.fel.groscdan.crmsystem.model.project;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractPerson;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Person extends AbstractPerson {

    @ManyToMany
    @ToString.Exclude
    private Set<Task> tasks;


    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
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