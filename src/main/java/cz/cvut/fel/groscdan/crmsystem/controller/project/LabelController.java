package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.LabelDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.LabelMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.Label;
import cz.cvut.fel.groscdan.crmsystem.service.project.LabelService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/label")
public class LabelController {

    private final LabelService labelService;
    private final LabelMapper labelMapper = Mappers.getMapper(LabelMapper.class);

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping
    public ResponseEntity<List<LabelDto>> getAll() {
        List<Label> labels = labelService.getAll();
        return new ResponseEntity<>(labelMapper.labelToLabelDto(labels), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabelDto> get(@PathVariable Long id) {
        Label label = labelService.getOneById(id);
        LabelDto labelDto = labelMapper.labelToLabelDto(label);
        return new ResponseEntity<>(labelDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LabelDto> create(@RequestBody LabelDto labelDto) {

        Label label = labelMapper.labelDtoToLabel(labelDto);
        label = labelService.create(label);
        labelDto = labelMapper.labelToLabelDto(label);
        return new ResponseEntity<>(labelDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LabelDto> update(@RequestBody LabelDto labelDto) {
        Label label = labelMapper.labelDtoToLabel(labelDto);
        label = labelService.update(label);
        labelDto = labelMapper.labelToLabelDto(label);
        return new ResponseEntity<>(labelDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LabelDto> delete(@PathVariable Long id) throws DeleteError {
        labelService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
