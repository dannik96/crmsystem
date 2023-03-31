package cz.cvut.fel.groscdan.crmsystem.controller.mappers.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.TypeDto;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Type;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface TypeMapper {

    TypeDto typeToTypeDTO(Type entity);

    Type typeDTOtoType(TypeDto dto);


    Set<TypeDto> typeToTypeDto(Set<Type> types);
}
