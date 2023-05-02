package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.TypeDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface TypeMapper {

    TypeDto typeToTypeDTO(ChannelType entity);

    ChannelType typeDTOtoType(TypeDto dto);


    Set<TypeDto> typeToTypeDto(Set<ChannelType> channelTypes);
}
