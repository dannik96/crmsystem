package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel} entity
 */
@AllArgsConstructor
@Getter
public class TaskLabelDto implements Serializable {
    private final Long id;
    private final LocalDateTime created;
    private final Boolean deletable;
    private final Boolean deleted;
    private final LocalDateTime modified;
    private final String name;
    private final String description;
}