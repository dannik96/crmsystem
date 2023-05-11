package cz.cvut.fel.groscdan.crmsystem.controller.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.event.EventType} entity
 */
@AllArgsConstructor
@Getter
public class EventTypeDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}