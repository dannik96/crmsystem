package cz.cvut.fel.groscdan.crmsystem.repository.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}