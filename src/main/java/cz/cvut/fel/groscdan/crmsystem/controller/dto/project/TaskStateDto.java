package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.TaskState} entity
 */
@Data
public class TaskStateDto implements Serializable {
    private final Long id;
    private final Boolean deletable;
    private final Boolean deleted;
    private final String name;
    private final String description;
}