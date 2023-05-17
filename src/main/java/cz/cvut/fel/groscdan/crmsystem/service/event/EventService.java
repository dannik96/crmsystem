package cz.cvut.fel.groscdan.crmsystem.service.event;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import cz.cvut.fel.groscdan.crmsystem.repository.event.EventRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class EventService extends AbstractService<EventRepository, Event> {

    private final EventTypeService eventTypeService;

    public EventService(EventRepository repository, EventTypeService eventTypeService) {
        super(repository, "Event");
        this.eventTypeService = eventTypeService;
    }

    @Override
    protected Event updateExisting(Event existingRecord, Event record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        existingRecord.setStartDate(record.getStartDate());
        existingRecord.setEndDate(record.getEndDate());
        return repository.saveAndFlush(existingRecord);
    }

    public void addEventType(Long eventId, Long eventTypeId) {
        Event event = getOneById(eventId, new PatchError());
        EventType eventType = eventTypeService.getOneById(eventTypeId, new PatchError());

        if (!event.addEventType(eventType)) {
            throw new PatchError();
        }

        update(event);
    }

    public void removeEventType(Long eventId, Long eventTypeId) {
        Event event = getOneById(eventId, new PatchError());
        EventType eventType = eventTypeService.getOneById(eventTypeId, new PatchError());

        if (!event.removeEventType(eventType)) {
            throw new PatchError();
        }

        update(event);
    }
}
