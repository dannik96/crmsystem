package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.PersonDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProjectMapper {

    Project projectDtoToProject(ProjectDto projectDto);

    ProjectDto projectToProjectDto(Project project);

    List<Project> projectDtoToProject(List<ProjectDto> projectDto);

    List<ProjectDto> projectToProjectDto(List<Project> project);

    Set<Project> projectDtoToProject(Set<ProjectDto> projectDto);

    Set<ProjectDto> projectToProjectDto(Set<Project> project);


}
