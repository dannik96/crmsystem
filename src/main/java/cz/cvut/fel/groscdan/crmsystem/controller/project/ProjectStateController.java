package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectStateDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskStateDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.ProjectStateMapper;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import cz.cvut.fel.groscdan.crmsystem.service.project.ProjectStateService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-state")
public class ProjectStateController {

    private final ProjectStateService projectStateService;
    private final ProjectStateMapper projectStateMapper = Mappers.getMapper(ProjectStateMapper.class);

    public ProjectStateController(ProjectStateService projectStateService) {
        this.projectStateService = projectStateService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectStateDto>> getAll() {
        List<ProjectState> projectStates = projectStateService.getAll();
        return new ResponseEntity<>(projectStateMapper.projectStateToProjectStateDto(projectStates), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectStateDto> createChannel(@RequestBody ProjectStateDto typeDto) {

        ProjectState type = projectStateMapper.projectStateDtoToProjectState(typeDto);
        type = projectStateService.create(type);
        typeDto = projectStateMapper.projectStateToProjectStateDto(type);
        return new ResponseEntity<>(typeDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskStateDto> delete(@PathVariable Long id) throws DeleteError {
        projectStateService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
