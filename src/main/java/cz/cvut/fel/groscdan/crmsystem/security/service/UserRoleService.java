package cz.cvut.fel.groscdan.crmsystem.security.service;

import cz.cvut.fel.groscdan.crmsystem.security.model.UserRole;
import cz.cvut.fel.groscdan.crmsystem.security.repository.UserRoleRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends AbstractService<UserRoleRepository,UserRole> {
    public UserRoleService(UserRoleRepository repository) {
        super(repository, "User role");
    }

    @Override
    protected UserRole updateExisting(UserRole existingRecord, UserRole record) {
        return null;
    }
}
