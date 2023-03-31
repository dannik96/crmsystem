package cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.SourceDto;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Source;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface SourceMapper {
    Source sourceDtoToSource(SourceDto sourceDto);

    SourceDto sourceToSourceDto(Source source);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Source updateSourceFromSourceDto(SourceDto sourceDto, @MappingTarget Source source);
}
