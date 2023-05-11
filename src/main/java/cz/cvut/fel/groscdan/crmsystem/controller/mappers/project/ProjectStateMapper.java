package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectStateDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProjectStateMapper {
    ProjectState projectStateDtoToProjectState(ProjectStateDto projectStateDto);

    ProjectStateDto projectStateToProjectStateDto(ProjectState projectState);

    List<ProjectState> projectStateDtoToProjectState(List<ProjectStateDto> projectStateDto);

    List<ProjectStateDto> projectStateToProjectStateDto(List<ProjectState> projectState);


    Set<ProjectState> projectStateDtoToProjectState(Set<ProjectStateDto> projectStateDto);

    Set<ProjectStateDto> projectStateToProjectStateDto(Set<ProjectState> projectState);


}
