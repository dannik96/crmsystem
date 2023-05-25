package cz.cvut.fel.groscdan.crmsystem.controller.event;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.event.EventDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.event.EventTypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.event.EventMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.event.EventTypeMapper;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.service.event.EventService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper = Mappers.getMapper(EventMapper.class);
    private final EventTypeMapper eventTypeMapper = Mappers.getMapper(EventTypeMapper.class);

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getAll() {
        List<Event> events = eventService.getAll();
        return new ResponseEntity<>(eventMapper.eventToEventDto(events), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> get(@PathVariable Long id) {
        Event event = eventService.getOneById(id);
        EventDto eventDto = eventMapper.eventToEventDto(event);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventDto> create(@RequestBody EventDto eventDto) {

        Event event = eventMapper.eventDtoToEvent(eventDto);
        event = eventService.create(event);
        eventDto = eventMapper.eventToEventDto(event);
        return new ResponseEntity<>(eventDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EventDto> update(@RequestBody EventDto eventDto) {
        Event event = eventMapper.eventDtoToEvent(eventDto);
        event = eventService.update(event);
        eventDto = eventMapper.eventToEventDto(event);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventDto> delete(@PathVariable Long id) throws DeleteError {
        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{eventId}/event-types/")
    public ResponseEntity<Set<EventTypeDto>> getEventTypes(@PathVariable Long eventId) {
        Event event = eventService.getOneById(eventId);
        Set<EventTypeDto> eventTypeDtos = eventTypeMapper.eventTypeToEventTypeDto(event.getEventTypes());
        return new ResponseEntity<>(eventTypeDtos, HttpStatus.OK);
    }

    @PatchMapping("/{eventId}/add-type/{eventTypeId}")
    public ResponseEntity<EventDto> addEventType(@PathVariable Long eventId, @PathVariable Long eventTypeId) {
        eventService.addEventType(eventId, eventTypeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{eventId}/remove-type/{eventTypeId}")
    public ResponseEntity<EventDto> removeEventType(@PathVariable Long eventId, @PathVariable Long eventTypeId) {
        eventService.removeEventType(eventId, eventTypeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{eventId}/unset-project")
    public ResponseEntity<EventDto> unsetProject(@PathVariable Long eventId) {
        eventService.unsetProject(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{eventId}/set-project/{projectId}")
    public ResponseEntity<EventDto> setProject(@PathVariable Long eventId, @PathVariable Long projectId) {
        eventService.setProject(eventId, projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-by-project/{projectId}")
    public ResponseEntity<List<EventDto>> getEventsByProject(@PathVariable Long projectId) {
        List<Event> events = eventService.getEventsByProject(projectId);
        List<EventDto> eventDtos = eventMapper.eventToEventDto(events);
        return new ResponseEntity<>(eventDtos, HttpStatus.OK);
    }
}
