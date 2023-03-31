package cz.cvut.fel.groscdan.crmsystem.repository.event;

import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}