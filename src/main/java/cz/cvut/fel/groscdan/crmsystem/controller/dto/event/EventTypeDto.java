package cz.cvut.fel.groscdan.crmsystem.controller.dto.event;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.event.EventType} entity
 */
@Data
public class EventTypeDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}