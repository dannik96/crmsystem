package cz.cvut.fel.groscdan.crmsystem.service.event;

import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.repository.event.EventRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class EventService extends AbstractService<EventRepository, Event> {
    public EventService(EventRepository repository) {
        super(repository, "Event");
    }

    @Override
    protected Event updateExisting(Event existingRecord, Event record) {
        return null;
    }
}
