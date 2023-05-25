package cz.cvut.fel.groscdan.crmsystem.repository.event;

import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> getEventsByProject(Project project);
}