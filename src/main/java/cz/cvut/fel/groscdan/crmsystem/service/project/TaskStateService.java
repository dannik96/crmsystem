package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.TaskState;
import cz.cvut.fel.groscdan.crmsystem.repository.project.TaskStateRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TaskStateService extends AbstractService<TaskStateRepository, TaskState> {
    public TaskStateService(TaskStateRepository repository) {
        super(repository, "TaskState");
    }

    @Override
    protected TaskState updateExisting(TaskState existingRecord, TaskState record) {
        return null;
    }
}
