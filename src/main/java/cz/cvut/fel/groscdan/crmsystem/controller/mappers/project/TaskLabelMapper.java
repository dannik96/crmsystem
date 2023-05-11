package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskLabelDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel;
import org.mapstruct.*;

import java.util.List;

@Mapper()
public interface TaskLabelMapper {
    TaskLabel taskLabelDtoToTaskLabel(TaskLabelDto taskLabelDto);

    TaskLabelDto taskLabelToTaskLabelDto(TaskLabel taskLabel);

    List<TaskLabel> taskLabelDtoToTaskLabel(List<TaskLabelDto> taskLabelDto);

    List<TaskLabelDto> taskLabelToTaskLabelDto(List<TaskLabel> taskLabel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskLabel updateTaskLabelFromTaskLabelDto(TaskLabelDto taskLabelDto, @MappingTarget TaskLabel taskLabel);
}
