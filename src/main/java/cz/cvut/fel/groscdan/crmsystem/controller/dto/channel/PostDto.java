package cz.cvut.fel.groscdan.crmsystem.controller.dto.channel;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Post} entity
 */
@Data
public class PostDto implements Serializable {
    private final Long id;
    private final String content;
}