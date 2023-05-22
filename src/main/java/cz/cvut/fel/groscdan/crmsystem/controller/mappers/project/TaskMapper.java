package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface TaskMapper {

    Task taskDtoToTask(TaskDto taskDto);

    TaskDto taskToTaskDto(Task task);

    List<Task> taskDtoToTask(List<TaskDto> taskDto);

    List<TaskDto> taskToTaskDto(List<Task> task);


    Set<Task> taskDtoToTask(Set<TaskDto> taskDto);

    Set<TaskDto> taskToTaskDto(Set<Task> task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task updateTaskFromTaskDto(TaskDto taskDto, @MappingTarget Task task);

}
