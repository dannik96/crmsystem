package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectTypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskStateDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.ProjectTypeMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import cz.cvut.fel.groscdan.crmsystem.service.project.ProjectTypeService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-type")
public class ProjectTypeController {
    private final ProjectTypeService projectTypeService;
    private final ProjectTypeMapper projectTypeMapper = Mappers.getMapper(ProjectTypeMapper.class);

    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectTypeDto>> getAll() {
        List<ProjectType> projectStates = projectTypeService.getAll();
        return new ResponseEntity<>(projectTypeMapper.projectTypeToProjectTypeDto(projectStates), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskStateDto> delete(@PathVariable Long id) throws DeleteError {
        projectTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
