package cz.cvut.fel.groscdan.crmsystem.controller.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.TimeSpentDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.project.TimeSpentMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.TimeSpent;
import cz.cvut.fel.groscdan.crmsystem.service.project.TimeSpentService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-spent")
public class TimeSpentController {

    private final TimeSpentService timeSpentService;
    private final TimeSpentMapper labelMapper = Mappers.getMapper(TimeSpentMapper.class);

    public TimeSpentController(TimeSpentService timeSpentService) {
        this.timeSpentService = timeSpentService;
    }

    @GetMapping
    public ResponseEntity<List<TimeSpentDto>> getAll() {
        List<TimeSpent> timeSpents = timeSpentService.getAll();
        return new ResponseEntity<>(labelMapper.timeSpentToTimeSpentDto(timeSpents), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSpentDto> get(@PathVariable Long id) {
        TimeSpent timeSpent = timeSpentService.getOneById(id);
        TimeSpentDto timeSpentDto = labelMapper.timeSpentToTimeSpentDto(timeSpent);
        return new ResponseEntity<>(timeSpentDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TimeSpentDto> create(@RequestBody TimeSpentDto timeSpentDto) {

        TimeSpent timeSpent = labelMapper.timeSpentDtoToTimeSpent(timeSpentDto);
        timeSpent = timeSpentService.create(timeSpent);
        timeSpentDto = labelMapper.timeSpentToTimeSpentDto(timeSpent);
        return new ResponseEntity<>(timeSpentDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TimeSpentDto> update(@RequestBody TimeSpentDto timeSpentDto) {
        TimeSpent timeSpent = labelMapper.timeSpentDtoToTimeSpent(timeSpentDto);
        timeSpent = timeSpentService.update(timeSpent);
        timeSpentDto = labelMapper.timeSpentToTimeSpentDto(timeSpent);
        return new ResponseEntity<>(timeSpentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TimeSpentDto> delete(@PathVariable Long id) throws DeleteError {
        timeSpentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
