package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.ProjectMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.TaskMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.service.project.ProjectService;
import cz.cvut.fel.groscdan.crmsystem.service.project.TaskService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);
    private final TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

    public ProjectController(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAll() {
        List<Project> projects = projectService.getAll();
        return new ResponseEntity<>(projectMapper.projectToProjectDto(projects), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> get(@PathVariable Long id) {
        Project project = projectService.getOneById(id);
        ProjectDto projectDto = projectMapper.projectToProjectDto(project);
        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> create(@RequestBody ProjectDto projectDto) {

        Project project = projectMapper.projectDtoToProject(projectDto);
        project = projectService.create(project);
        projectDto = projectMapper.projectToProjectDto(project);
        return new ResponseEntity<>(projectDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProjectDto> update(@RequestBody ProjectDto projectDto) {
        Project project = projectMapper.projectDtoToProject(projectDto);
        project = projectService.update(project);
        projectDto = projectMapper.projectToProjectDto(project);
        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectDto> delete(@PathVariable Long id) throws DeleteError {
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskDto>> getTasks(@PathVariable Long id) {
        List<Task> tasks = taskService.getProjectTasks(id);
        return new ResponseEntity<>(taskMapper.taskToTaskDto(tasks), HttpStatus.OK);
    }

    @PatchMapping("/{idProject}/add-task/{idTask}")
    public ResponseEntity<?> addTask(@PathVariable Long idProject, @PathVariable Long idTask) {
        taskService.addLabel(idProject, idTask);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{idProject}/remove-task/{idTask}")
    public ResponseEntity<?> removeTask(@PathVariable Long idProject, @PathVariable Long idTask) {
        taskService.removeLabel(idProject, idTask);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
