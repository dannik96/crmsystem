package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.LabelDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface LabelMapper {
    TaskLabel labelDtoToLabel(LabelDto labelDto);

    LabelDto labelToLabelDto(TaskLabel taskLabel);

    List<TaskLabel> labelDtoToLabel(List<LabelDto> labelDto);

    List<LabelDto> labelToLabelDto(List<TaskLabel> taskLabel);

    Set<TaskLabel> labelDtoToLabel(Set<LabelDto> labelDto);

    Set<LabelDto> labelToLabelDto(Set<TaskLabel> taskLabel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskLabel updateLabelFromLabelDto(LabelDto labelDto, @MappingTarget TaskLabel taskLabel);
}
