package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelTypeDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface ChannelTypeMapper {
    ChannelType channelTypeDtoToChannelType(ChannelTypeDto channelTypeDto);

    ChannelTypeDto channelTypeToChannelTypeDto(ChannelType channelType);

    List<ChannelType> channelTypeDtoToChannelType(List<ChannelTypeDto> channelTypeDto);

    List<ChannelTypeDto> channelTypeToChannelTypeDto(List<ChannelType> channelType);

    Set<ChannelType> channelTypeDtoToChannelType(Set<ChannelTypeDto> channelTypeDto);

    Set<ChannelTypeDto> channelTypeToChannelTypeDto(Set<ChannelType> channelType);
}
