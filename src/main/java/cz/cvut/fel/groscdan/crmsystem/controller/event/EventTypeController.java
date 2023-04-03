package cz.cvut.fel.groscdan.crmsystem.controller.event;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.event.EventTypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.event.EventTypeMapper;
import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import cz.cvut.fel.groscdan.crmsystem.service.event.EventTypeService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-type")
public class EventTypeController {

    private final EventTypeService eventTypeService;
    private final EventTypeMapper eventTypeMapper = Mappers.getMapper(EventTypeMapper.class);

    public EventTypeController(EventTypeService eventTypeService) {
        this.eventTypeService = eventTypeService;
    }

    @GetMapping
    public ResponseEntity<List<EventTypeDto>> getAll() {
        List<EventType> eventTypes = eventTypeService.getAll();
        return new ResponseEntity<>(eventTypeMapper.eventTypeToEventTypeDto(eventTypes), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventTypeDto> get(@PathVariable Long id) {
        EventType eventType = eventTypeService.getOneById(id);
        EventTypeDto eventTypeDto = eventTypeMapper.eventTypeToEventTypeDto(eventType);
        return new ResponseEntity<>(eventTypeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventTypeDto> create(@RequestBody EventTypeDto eventTypeDto) {

        EventType eventType = eventTypeMapper.eventTypeDtoToEventType(eventTypeDto);
        eventType = eventTypeService.create(eventType);
        eventTypeDto = eventTypeMapper.eventTypeToEventTypeDto(eventType);
        return new ResponseEntity<>(eventTypeDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EventTypeDto> update(@RequestBody EventTypeDto eventTypeDto) {
        EventType eventType = eventTypeMapper.eventTypeDtoToEventType(eventTypeDto);
        eventType = eventTypeService.update(eventType);
        eventTypeDto = eventTypeMapper.eventTypeToEventTypeDto(eventType);
        return new ResponseEntity<>(eventTypeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventTypeDto> delete(@PathVariable Long id) {
        eventTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
