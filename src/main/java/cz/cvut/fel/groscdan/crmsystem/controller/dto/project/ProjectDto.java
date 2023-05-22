package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Project} entity
 */
@AllArgsConstructor
@Getter
public class ProjectDto implements Serializable {
    private final Long id;
    private final Boolean deleted;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final LocalDateTime deadline;
    private final LocalDateTime start;
    private final String description;
    private final String name;
    private final PersonDto1 manager;
    private final ProjectTypeDto1 projectType;
    private final ProjectStateDto1 projectState;
    private final Set<ChannelDto> channels;

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Person} entity
     */
    @AllArgsConstructor
    @Getter
    public static class PersonDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String email;
        private final String login;
        private final String name;
        private final String surname;
        private final String phone;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType} entity
     */
    @AllArgsConstructor
    @Getter
    public static class ProjectTypeDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String description;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState} entity
     */
    @AllArgsConstructor
    @Getter
    public static class ProjectStateDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String description;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Channel} entity
     */
    @AllArgsConstructor
    @Getter
    public static class ChannelDto implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String description;
        private final String location;
        private final String name;
    }
}