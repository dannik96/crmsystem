package cz.cvut.fel.groscdan.crmsystem.security.service;

import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import cz.cvut.fel.groscdan.crmsystem.security.repository.UserRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<UserRepository, User> {

    public UserService(UserRepository repository) {
        super(repository, "UserService");
    }

    @Override
    protected User updateExisting(User existingRecord, User record) {
        existingRecord.setRoles(record.getRoles());
        existingRecord.setEmail(record.getEmail());
        existingRecord.setPassword(record.getPassword());
        existingRecord.setUsername(record.getUsername());

        return repository.save(existingRecord);
    }
}
