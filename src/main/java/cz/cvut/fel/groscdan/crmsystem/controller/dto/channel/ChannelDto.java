package cz.cvut.fel.groscdan.crmsystem.controller.dto.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.AudienceDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.PostDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.TypeDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link Channel} entity
 */
@Data
public class ChannelDto implements Serializable {
    private final Long id;
    private final String description;
    private final String location;
    private final String name;
}