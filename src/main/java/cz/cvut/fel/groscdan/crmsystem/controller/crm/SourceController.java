package cz.cvut.fel.groscdan.crmsystem.controller.crm;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.crm.SourceDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.crm.SourceMapper;
import cz.cvut.fel.groscdan.crmsystem.model.crm.Source;
import cz.cvut.fel.groscdan.crmsystem.service.crm.SourceService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/source")
public class SourceController {

    private final SourceService sourceService;
    private final SourceMapper sourceMapper = Mappers.getMapper(SourceMapper.class);

    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @GetMapping
    public ResponseEntity<List<SourceDto>> getAll() {
        List<Source> sources = sourceService.getAll();
        return new ResponseEntity<>(sourceMapper.sourceToSourceDto(sources), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SourceDto> get(@PathVariable Long id) {
        Source source = sourceService.getOneById(id);
        SourceDto sourceDto = sourceMapper.sourceToSourceDto(source);
        return new ResponseEntity<>(sourceDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SourceDto> create(@RequestBody SourceDto sourceDto) {

        Source source = sourceMapper.sourceDtoToSource(sourceDto);
        source = sourceService.create(source);
        sourceDto = sourceMapper.sourceToSourceDto(source);
        return new ResponseEntity<>(sourceDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SourceDto> update(@RequestBody SourceDto sourceDto) {
        Source source = sourceMapper.sourceDtoToSource(sourceDto);
        source = sourceService.update(source);
        sourceDto = sourceMapper.sourceToSourceDto(source);
        return new ResponseEntity<>(sourceDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SourceDto> delete(@PathVariable Long id) {
        sourceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

