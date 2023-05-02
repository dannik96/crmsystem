package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.LabelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.LabelMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel;
import cz.cvut.fel.groscdan.crmsystem.service.project.TaskLabelService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/label")
public class LabelController {

    private final TaskLabelService taskLabelService;
    private final LabelMapper labelMapper = Mappers.getMapper(LabelMapper.class);

    public LabelController(TaskLabelService taskLabelService) {
        this.taskLabelService = taskLabelService;
    }

    @GetMapping
    public ResponseEntity<List<LabelDto>> getAll() {
        List<TaskLabel> taskLabels = taskLabelService.getAll();
        return new ResponseEntity<>(labelMapper.labelToLabelDto(taskLabels), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabelDto> get(@PathVariable Long id) {
        TaskLabel taskLabel = taskLabelService.getOneById(id);
        LabelDto labelDto = labelMapper.labelToLabelDto(taskLabel);
        return new ResponseEntity<>(labelDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LabelDto> create(@RequestBody LabelDto labelDto) {

        TaskLabel taskLabel = labelMapper.labelDtoToLabel(labelDto);
        taskLabel = taskLabelService.create(taskLabel);
        labelDto = labelMapper.labelToLabelDto(taskLabel);
        return new ResponseEntity<>(labelDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LabelDto> update(@RequestBody LabelDto labelDto) {
        TaskLabel taskLabel = labelMapper.labelDtoToLabel(labelDto);
        taskLabel = taskLabelService.update(taskLabel);
        labelDto = labelMapper.labelToLabelDto(taskLabel);
        return new ResponseEntity<>(labelDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LabelDto> delete(@PathVariable Long id) throws DeleteError {
        taskLabelService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
