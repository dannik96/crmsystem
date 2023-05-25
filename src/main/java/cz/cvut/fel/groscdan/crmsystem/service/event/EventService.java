package cz.cvut.fel.groscdan.crmsystem.service.event;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.repository.event.EventRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import cz.cvut.fel.groscdan.crmsystem.service.project.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService extends AbstractService<EventRepository, Event> {

    private final EventTypeService eventTypeService;
    private final ProjectService projectService;

    public EventService(EventRepository repository, EventTypeService eventTypeService, ProjectService projectService) {
        super(repository, "Event");
        this.eventTypeService = eventTypeService;
        this.projectService = projectService;
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

    public void unsetProject(Long eventId) {
        Event event = getOneById(eventId, new PatchError());

        event.setProject(null);

        repository.saveAndFlush(event);
    }

    public void setProject(Long eventId, Long projectId) {
        Event event = getOneById(eventId, new PatchError());
        Project project = projectService.getOneById(projectId, new PatchError());

        event.setProject(project);

        repository.saveAndFlush(event);
    }

    public List<Event> getEventsByProject(Long projectId) {
        Project project = projectService.getOneById(projectId);

        return repository.getEventsByProject(project);
    }
}
