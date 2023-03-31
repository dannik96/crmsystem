package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Task} entity
 */
@Data
public class TaskDto implements Serializable {
    private final Long id;
    private final LocalDateTime deadline;
    private final String description;
    private final String name;
    private final Integer priority;
}