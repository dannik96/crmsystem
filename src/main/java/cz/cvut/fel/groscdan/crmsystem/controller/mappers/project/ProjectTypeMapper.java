package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectTypeDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import org.mapstruct.*;

import java.util.List;

@Mapper
public interface ProjectTypeMapper {
    ProjectType projectTypeDtoToProjectType(ProjectTypeDto projectTypeDto);

    ProjectTypeDto projectTypeToProjectTypeDto(ProjectType projectType);

    List<ProjectType> projectTypeDtoToProjectType(List<ProjectTypeDto> projectTypeDto);

    List<ProjectTypeDto> projectTypeToProjectTypeDto(List<ProjectType> projectType);
}
