package cz.cvut.fel.groscdan.crmsystem.controller.dto.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Post} entity
 */
@AllArgsConstructor
@Getter
public class PostDto implements Serializable {
    private final Long id;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final String name;
    private final String content;
    private final LocalDateTime postDate;
    private final Boolean deleted;
    private final List<ChannelDto1> channels;
    private final List<TaskDto1> tasks;
    private final PostStateDto1 postState;
    private final PersonDto author;

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Channel} entity
     */
    @AllArgsConstructor
    @Getter
    public static class ChannelDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String description;
        private final String location;
        private final String name;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.PostState} entity
     */
    @AllArgsConstructor
    @Getter
    public static class PostStateDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String description;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Person} entity
     */
    @AllArgsConstructor
    @Getter
    public static class PersonDto implements Serializable {
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


    @AllArgsConstructor
    @Getter
    public static class TaskDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final LocalDateTime deadline;
        private final String description;
        private final String name;
        private final Integer priority;
    }
}