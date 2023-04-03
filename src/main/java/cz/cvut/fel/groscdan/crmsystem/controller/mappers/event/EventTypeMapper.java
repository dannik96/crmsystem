package cz.cvut.fel.groscdan.crmsystem.controller.mappers.event;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.event.EventTypeDto;
import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface EventTypeMapper {
    EventType eventTypeDtoToEventType(EventTypeDto eventTypeDto);

    EventTypeDto eventTypeToEventTypeDto(EventType eventType);

    List<EventType> eventTypeDtoToEventType(List<EventTypeDto> eventTypeDto);

    List<EventTypeDto> eventTypeToEventTypeDto(List<EventType> eventType);

    Set<EventType> eventTypeDtoToEventType(Set<EventTypeDto> eventTypeDto);

    Set<EventTypeDto> eventTypeToEventTypeDto(Set<EventType> eventType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventType updateEventTypeFromEventTypeDto(EventTypeDto eventTypeDto, @MappingTarget EventType eventType);
}
