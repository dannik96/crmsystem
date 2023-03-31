package cz.cvut.fel.groscdan.crmsystem.repository.event;

import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {
}