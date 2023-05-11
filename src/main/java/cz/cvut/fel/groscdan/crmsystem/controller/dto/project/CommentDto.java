package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Comment} entity
 */
@AllArgsConstructor
@Getter
public class CommentDto implements Serializable {
    private final Long id;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final String text;
    private final TaskDto1 task;
    private final CommentDto1 comment;
    private final PersonDto1 person;

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Task} entity
     */
    @AllArgsConstructor
    @Getter
    public static class TaskDto1 implements Serializable {
        private final Long id;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final LocalDateTime deadline;
        private final String description;
        private final String name;
        private final Integer priority;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Comment} entity
     */
    @AllArgsConstructor
    @Getter
    public static class CommentDto1 implements Serializable {
        private final Long id;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String text;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Person} entity
     */
    @AllArgsConstructor
    @Getter
    public static class PersonDto1 implements Serializable {
        private final Long id;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String email;
        private final String login;
        private final String name;
        private final String surname;
        private final String phone;
    }
}