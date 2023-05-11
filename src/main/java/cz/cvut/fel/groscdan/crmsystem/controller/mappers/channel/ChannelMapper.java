package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface ChannelMapper {

    Channel channelDtoToChannel(ChannelDto channelDto);

    ChannelDto channelToChannelDto(Channel channel);

    Set<Channel> channelDtoToChannel(Set<ChannelDto> channelDto);

    Set<ChannelDto> channelToChannelDto(Set<Channel> channel);

    List<Channel> channelDtoToChannel(List<ChannelDto> channelDto);

    List<ChannelDto> channelToChannelDto(List<Channel> channel);
}
