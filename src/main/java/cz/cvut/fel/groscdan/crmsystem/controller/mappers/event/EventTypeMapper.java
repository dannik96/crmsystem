package cz.cvut.fel.groscdan.crmsystem.controller.mappers.event;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.event.EventTypeDto;
import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import org.mapstruct.*;

@Mapper
public interface EventTypeMapper {
    EventType eventTypeDtoToEventType(EventTypeDto eventTypeDto);

    EventTypeDto eventTypeToEventTypeDto(EventType eventType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventType updateEventTypeFromEventTypeDto(EventTypeDto eventTypeDto, @MappingTarget EventType eventType);
}
