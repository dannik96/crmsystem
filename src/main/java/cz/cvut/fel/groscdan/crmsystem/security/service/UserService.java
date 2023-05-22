package cz.cvut.fel.groscdan.crmsystem.security.service;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import cz.cvut.fel.groscdan.crmsystem.security.model.UserRole;
import cz.cvut.fel.groscdan.crmsystem.security.repository.UserRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import cz.cvut.fel.groscdan.crmsystem.service.project.PersonService;
import cz.cvut.fel.groscdan.crmsystem.util.UserToPersonMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService extends AbstractService<UserRepository, User> {

    public UserService(UserRepository repository, PersonService personService) {
        super(repository, "UserService");
    }

    @Override
    protected User updateExisting(User existingRecord, User record) {
        existingRecord.setEmail(record.getEmail());

        return repository.saveAndFlush(existingRecord);
    }

}
