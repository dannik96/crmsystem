package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.AudienceDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.TypeDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Type;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface AudienceMapper {

    Audience audienceDtoToAudience(AudienceDto channelDto);

    AudienceDto audienceToAudienceDto(Audience channel);

    Set<AudienceDto> audienceToAudienceDto(Set<Audience> types);

}
