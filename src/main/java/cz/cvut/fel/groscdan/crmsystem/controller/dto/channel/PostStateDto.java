package cz.cvut.fel.groscdan.crmsystem.controller.dto.channel;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.channel.PostState} entity
 */
@Data
public class PostStateDto implements Serializable {
    private final Long id;
    private final Boolean deletable;
    private final String name;
    private final Boolean deleted;
    private final String description;
}