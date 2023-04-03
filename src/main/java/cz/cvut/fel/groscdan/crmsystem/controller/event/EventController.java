package cz.cvut.fel.groscdan.crmsystem.controller.event;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.event.EventDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.event.EventMapper;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.service.event.EventService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;
    private final EventMapper labelMapper = Mappers.getMapper(EventMapper.class);

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getAll() {
        List<Event> events = eventService.getAll();
        return new ResponseEntity<>(labelMapper.eventToEventDto(events), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> get(@PathVariable Long id) {
        Event event = eventService.getOneById(id);
        EventDto eventDto = labelMapper.eventToEventDto(event);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventDto> create(@RequestBody EventDto eventDto) {

        Event event = labelMapper.eventDtoToEvent(eventDto);
        event = eventService.create(event);
        eventDto = labelMapper.eventToEventDto(event);
        return new ResponseEntity<>(eventDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EventDto> update(@RequestBody EventDto eventDto) {
        Event event = labelMapper.eventDtoToEvent(eventDto);
        event = eventService.update(event);
        eventDto = labelMapper.eventToEventDto(event);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventDto> delete(@PathVariable Long id) throws DeleteError {
        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
