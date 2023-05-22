package cz.cvut.fel.groscdan.crmsystem.controller.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.event.Event} entity
 */
@AllArgsConstructor
@Getter
public class EventDto implements Serializable {
    private final Long id;
    private final String description;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String name;
    private final ProjectDto project;
    private final Boolean deleted;
    private final Set<EventTypeDto1> eventTypes;

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Project} entity
     */
    @AllArgsConstructor
    @Getter
    public static class ProjectDto implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final LocalDateTime deadline;
        private final LocalDateTime start;
        private final String description;
        private final String name;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.event.EventType} entity
     */
    @AllArgsConstructor
    @Getter
    public static class EventTypeDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String description;
    }
}