package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.AudienceDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface AudienceMapper {

    Audience audienceDtoToAudience(AudienceDto channelDto);

    AudienceDto audienceToAudienceDto(Audience channel);

    Set<AudienceDto> audienceToAudienceDto(Set<Audience> types);
    Set<Audience> audienceDtoToAudience(Set<AudienceDto> types);
    List<AudienceDto> audienceToAudienceDto(List<Audience> types);
    List<Audience> audienceDtoToAudience(List<AudienceDto> types);

}
