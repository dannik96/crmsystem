package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskLabelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.ProjectTypeMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.TaskLabelMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel;
import cz.cvut.fel.groscdan.crmsystem.service.project.TaskLabelService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task-label")
public class TaskLabelController {
    private final TaskLabelService taskLabelService;
    private final TaskLabelMapper taskLabelMapper = Mappers.getMapper(TaskLabelMapper.class);

    public TaskLabelController(TaskLabelService taskLabelService) {
        this.taskLabelService = taskLabelService;
    }

    @GetMapping
    public ResponseEntity<List<TaskLabelDto>> getAll() {
        List<TaskLabel> taskLabels = taskLabelService.getAll();
        return new ResponseEntity<>(taskLabelMapper.taskLabelToTaskLabelDto(taskLabels), HttpStatus.OK);
    }
}