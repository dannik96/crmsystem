package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.model.project.TimeSpent;
import cz.cvut.fel.groscdan.crmsystem.repository.project.TimeSpentRepository;
import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import cz.cvut.fel.groscdan.crmsystem.util.UserToPersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSpentService extends AbstractService<TimeSpentRepository, TimeSpent> {

    private final UserToPersonMapper userToPersonMapper;

    public TimeSpentService(TimeSpentRepository repository, UserToPersonMapper userToPersonMapper) {
        super(repository, "TimeSpent");
        this.userToPersonMapper = userToPersonMapper;
    }

    @Override
    protected TimeSpent updateExisting(TimeSpent existingRecord, TimeSpent record) {
        return null;
    }

    public TimeSpent create(TimeSpent record, Long userId) {
        User user = userToPersonMapper.getOneById(userId);
        record.setPerson(user.getPerson());
        return super.create(record);
    }

    public List<TimeSpent> findAllByTask(Task task) {
        return repository.findAllByTask(task);
    }
}
