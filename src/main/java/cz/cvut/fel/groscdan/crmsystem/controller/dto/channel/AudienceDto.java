package cz.cvut.fel.groscdan.crmsystem.controller.dto.channel;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.Audience} entity
 */
@Data
public class AudienceDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}