package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.repository.project.PersonRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends AbstractService<PersonRepository, Person> {
    public PersonService(PersonRepository repository) {
        super(repository, "Person");
    }

    @Override
    protected Person updateExisting(Person existingRecord, Person record) {
        existingRecord.setSurname(record.getSurname());
        existingRecord.setName(record.getName());
        existingRecord.setEmail(record.getEmail());
        existingRecord.setLogin(record.getLogin());
        existingRecord.setPhone(record.getPhone());
        return repository.saveAndFlush(record);
    }
}
