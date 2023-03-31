package cz.cvut.fel.groscdan.crmsystem.controller.dto.event;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.event.Event} entity
 */
@Data
public class EventDto implements Serializable {
    private final Long id;
    private final String description;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String name;
}