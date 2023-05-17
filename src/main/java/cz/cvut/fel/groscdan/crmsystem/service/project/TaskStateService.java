package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskState;
import cz.cvut.fel.groscdan.crmsystem.repository.project.TaskRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.project.TaskStateRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStateService extends AbstractService<TaskStateRepository, TaskState> {

    private final TaskRepository taskRepository;

    public TaskStateService(TaskStateRepository repository, TaskRepository taskRepository) {
        super(repository, "TaskState");
        this.taskRepository = taskRepository;
    }

    @Override
    protected TaskState updateExisting(TaskState existingRecord, TaskState record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }

}
