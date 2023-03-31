package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskStateDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskState;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper
public interface TaskStateMapper {
    TaskState taskStateDtoToTaskState(TaskStateDto taskStateDto);

    TaskStateDto taskStateToTaskStateDto(TaskState taskState);

    List<TaskState> taskStateDtoToTaskState(List<TaskStateDto> taskStateDto);

    List<TaskStateDto> taskStateToTaskStateDto(List<TaskState> taskState);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskState updateTaskStateFromTaskStateDto(TaskStateDto taskStateDto, @MappingTarget TaskState taskState);
}
