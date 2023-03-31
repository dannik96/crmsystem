package cz.cvut.fel.groscdan.crmsystem.model.event;

import cz.cvut.fel.groscdan.crmsystem.model.AbstractState;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "event_type")
@Getter
@Setter
public class EventType extends AbstractState {

    @ManyToMany
    private List<Event> events;
}