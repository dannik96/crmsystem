package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TimeSpentDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.TimeSpent;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper
public interface TimeSpentMapper {
    TimeSpent timeSpentDtoToTimeSpent(TimeSpentDto timeSpentDto);

    TimeSpentDto timeSpentToTimeSpentDto(TimeSpent timeSpent);

    List<TimeSpent> timeSpentDtoToTimeSpent(List<TimeSpentDto> timeSpentDto);

    List<TimeSpentDto> timeSpentToTimeSpentDto(List<TimeSpent> timeSpent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TimeSpent updateTimeSpentFromTimeSpentDto(TimeSpentDto timeSpentDto, @MappingTarget TimeSpent timeSpent);
}
