package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.LabelDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.Label;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface LabelMapper {
    Label labelDtoToLabel(LabelDto labelDto);

    LabelDto labelToLabelDto(Label label);

    List<Label> labelDtoToLabel(List<LabelDto> labelDto);

    List<LabelDto> labelToLabelDto(List<Label> label);

    Set<Label> labelDtoToLabel(Set<LabelDto> labelDto);

    Set<LabelDto> labelToLabelDto(Set<Label> label);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Label updateLabelFromLabelDto(LabelDto labelDto, @MappingTarget Label label);
}
