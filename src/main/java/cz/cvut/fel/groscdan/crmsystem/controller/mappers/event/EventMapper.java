package cz.cvut.fel.groscdan.crmsystem.controller.mappers.event;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.event.EventDto;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface EventMapper {
    Event eventDtoToEvent(EventDto eventDto);

    EventDto eventToEventDto(Event event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event updateEventFromEventDto(EventDto eventDto, @MappingTarget Event event);
}
