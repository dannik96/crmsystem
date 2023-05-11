package cz.cvut.fel.groscdan.crmsystem.controller.mappers.project;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.project.PersonDto;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper
public interface PersonMapper {
    Person personDtoToPerson(PersonDto personDto);

    PersonDto personToPersonDto(Person person);

    List<Person> personDtoToPerson(List<PersonDto> personDto);
    List<PersonDto> personToPersonDto(List<Person> person);

    Set<PersonDto> personToPersonDto(Set<Person> person);
    Set<Person> personDtoToPerson(Set<PersonDto> personDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Person updatePersonFromPersonDto(PersonDto personDto, @MappingTarget Person person);
}
