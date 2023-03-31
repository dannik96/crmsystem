package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper
public interface TaskMapper {
    Task taskDtoToTask(TaskDto taskDto);

    TaskDto taskToTaskDto(Task task);
    List<Task> taskDtoToTask(List<TaskDto> taskDto);

    List<TaskDto> taskToTaskDto(List<Task> task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task updateTaskFromTaskDto(TaskDto taskDto, @MappingTarget Task task);
}
