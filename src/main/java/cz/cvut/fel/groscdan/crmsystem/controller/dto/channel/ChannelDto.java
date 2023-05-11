package cz.cvut.fel.groscdan.crmsystem.controller.dto.channel;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Channel} entity
 */
@AllArgsConstructor
@Getter
public class ChannelDto implements Serializable {
    private final Long id;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final String description;
    private final String location;
    private final String name;
    private final Set<PostDto1> posts;
    private final Set<ChannelTypeDto> channelTypes;
    private final Set<AudienceDto1> audiences;
    private final Set<ProjectDto> projects;

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Post} entity
     */
    @AllArgsConstructor
    @Getter
    public static class PostDto1 implements Serializable {
        private final Long id;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String content;
        private final LocalDateTime postDate;
        private final PostStateDto1 postState;
        private final PersonDto author;

        /**
         * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.PostState} entity
         */
        @AllArgsConstructor
        @Getter
        public static class PostStateDto1 implements Serializable {
            private final Long id;
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
            private final LocalDateTime created;
            private final LocalDateTime modified;
            private final String email;
            private final String login;
            private final String name;
            private final String surname;
            private final String phone;
        }
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType} entity
     */
    @AllArgsConstructor
    @Getter
    public static class ChannelTypeDto implements Serializable {
        private final Long id;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String name;
        private final String description;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Audience} entity
     */
    @AllArgsConstructor
    @Getter
    public static class AudienceDto1 implements Serializable {
        private final Long id;
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
    public static class ProjectDto implements Serializable {
        private final Long id;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final LocalDateTime deadline;
        private final LocalDateTime start;
        private final String description;
        private final String name;
        private final PersonDto manager;
        private final ProjectTypeDto projectType;
        private final ProjectStateDto projectState;

        /**
         * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Person} entity
         */
        @AllArgsConstructor
        @Getter
        public static class PersonDto implements Serializable {
            private final Long id;
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
        public static class ProjectTypeDto implements Serializable {
            private final Long id;
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
        public static class ProjectStateDto implements Serializable {
            private final Long id;
            private final LocalDateTime created;
            private final LocalDateTime modified;
            private final String name;
            private final String description;
        }
    }
}