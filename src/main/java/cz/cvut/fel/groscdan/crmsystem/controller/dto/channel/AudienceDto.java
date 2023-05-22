package cz.cvut.fel.groscdan.crmsystem.controller.dto.channel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Audience} entity
 */
@AllArgsConstructor
@Getter
public class AudienceDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final Boolean deleted;
    private final Set<ChannelDto> channels;

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