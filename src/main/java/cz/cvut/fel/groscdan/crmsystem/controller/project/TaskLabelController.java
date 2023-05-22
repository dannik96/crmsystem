package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.channel.ChannelTypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.ProjectTypeDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskLabelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TaskStateDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.ProjectTypeMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.TaskLabelMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel;
import cz.cvut.fel.groscdan.crmsystem.service.project.TaskLabelService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<TaskLabelDto> createChannel(@RequestBody TaskLabelDto typeDto) {

        TaskLabel type = taskLabelMapper.taskLabelDtoToTaskLabel(typeDto);
        type = taskLabelService.create(type);
        typeDto = taskLabelMapper.taskLabelToTaskLabelDto(type);
        return new ResponseEntity<>(typeDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskStateDto> delete(@PathVariable Long id) throws DeleteError {
        taskLabelService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
