package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Task} entity
 */
@AllArgsConstructor
@Getter
public class TaskDto implements Serializable {
    private final Long id;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final LocalDateTime deadline;
    private final String description;
    private final String name;
    private final Integer priority;
    private final Set<TaskLabelDto1> taskLabels;
    private final PostDto post;
    private final TaskStateDto1 taskState;
    private final ProjectDto1 project;
    private final PersonDto1 createdByPerson;
    private final PersonDto1 assignedPerson;

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Post} entity
     */
    @AllArgsConstructor
    @Getter
    public static class PostDto implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String content;
        private final LocalDateTime postDate;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel} entity
     */
    @AllArgsConstructor
    @Getter
    public static class TaskLabelDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String description;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.TaskState} entity
     */
    @AllArgsConstructor
    @Getter
    public static class TaskStateDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String description;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Project} entity
     */
    @AllArgsConstructor
    @Getter
    public static class ProjectDto1 implements Serializable {
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
}