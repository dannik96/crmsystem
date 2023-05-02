package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link TaskLabel} entity
 */
@Data
public class LabelDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}