package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskStateDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.TaskStateMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskState;
import cz.cvut.fel.groscdan.crmsystem.service.project.TaskStateService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-state")
public class TaskStateController {

    private final TaskStateService taskStateService;
    private final TaskStateMapper taskStateMapper = Mappers.getMapper(TaskStateMapper.class);

    public TaskStateController(TaskStateService taskStateService) {
        this.taskStateService = taskStateService;
    }

    @GetMapping
    public ResponseEntity<List<TaskStateDto>> getAll() {
        List<TaskState> labels = taskStateService.getAll();
        return new ResponseEntity<>(taskStateMapper.taskStateToTaskStateDto(labels), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskStateDto> get(@PathVariable Long id) {
        TaskState taskState = taskStateService.getOneById(id);
        TaskStateDto taskStateDto = taskStateMapper.taskStateToTaskStateDto(taskState);
        return new ResponseEntity<>(taskStateDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskStateDto> create(@RequestBody TaskStateDto taskStateDto) {
        TaskState taskState = taskStateMapper.taskStateDtoToTaskState(taskStateDto);

        taskState = taskStateService.create(taskState);
        taskStateDto = taskStateMapper.taskStateToTaskStateDto(taskState);

        return new ResponseEntity<>(taskStateDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TaskStateDto> update(@RequestBody TaskStateDto taskStateDto) {
        TaskState taskState = taskStateMapper.taskStateDtoToTaskState(taskStateDto);

        taskState = taskStateService.update(taskState);
        taskStateDto = taskStateMapper.taskStateToTaskStateDto(taskState);

        return new ResponseEntity<>(taskStateDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskStateDto> delete(@PathVariable Long id) throws DeleteError {
        taskStateService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
