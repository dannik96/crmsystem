package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.repository.project.PersonRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractService<PersonRepository, Person> {
    public PersonService(PersonRepository repository) {
        super(repository, "Person");
    }

    @Override
    protected Person updateExisting(Person existingRecord, Person record) {
        return null;
    }
}
