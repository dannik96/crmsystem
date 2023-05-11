package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Project} entity
 */
@Data
public class ProjectDto implements Serializable {
    private final Long id;
    private final LocalDateTime deadline;
    private final LocalDateTime start;
    private final String description;
    private final String name;
    private final LocalDateTime created;
    private final ProjectState projectState;
    private final ProjectType projectType;
    private final Person manager;
}