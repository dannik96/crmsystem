package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import org.mapstruct.Mapper;

@Mapper
public interface ChannelMapper {

    Channel channelDtoToChannel(ChannelDto channelDto);

    ChannelDto channelToChannelDto(Channel channel);

}
