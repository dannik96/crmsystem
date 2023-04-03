package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.model.project.TimeSpent;
import cz.cvut.fel.groscdan.crmsystem.repository.project.TimeSpentRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSpentService extends AbstractService<TimeSpentRepository, TimeSpent> {
    public TimeSpentService(TimeSpentRepository repository) {
        super(repository, "TimeSpent");
    }

    @Override
    protected TimeSpent updateExisting(TimeSpent existingRecord, TimeSpent record) {
        return null;
    }

    public List<TimeSpent> findAllByTask(Task task) {
        return repository.findAllByTask(task);
    }
}
