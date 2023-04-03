package cz.cvut.fel.groscdan.crmsystem.controller.project;


import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.PersonDto;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.PersonMapper;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.service.project.PersonService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;
    private final PersonMapper labelMapper = Mappers.getMapper(PersonMapper.class);

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        List<Person> persons = personService.getAll();
        return new ResponseEntity<>(labelMapper.personToPersonDto(persons), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> get(@PathVariable Long id) {
        Person person = personService.getOneById(id);
        PersonDto personDto = labelMapper.personToPersonDto(person);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {

        Person person = labelMapper.personDtoToPerson(personDto);
        person = personService.create(person);
        personDto = labelMapper.personToPersonDto(person);
        return new ResponseEntity<>(personDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PersonDto> update(@RequestBody PersonDto personDto) {
        Person person = labelMapper.personDtoToPerson(personDto);
        person = personService.update(person);
        personDto = labelMapper.personToPersonDto(person);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonDto> delete(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

