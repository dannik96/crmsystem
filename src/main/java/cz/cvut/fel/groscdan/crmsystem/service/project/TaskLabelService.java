package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import cz.cvut.fel.groscdan.crmsystem.model.project.Task;
import cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel;
import cz.cvut.fel.groscdan.crmsystem.repository.project.TaskLabelRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskLabelService extends AbstractService<TaskLabelRepository, TaskLabel> {

    public TaskLabelService(TaskLabelRepository repository) {
        super(repository, "Label");
    }

    @Override
    public TaskLabel create(TaskLabel record) {
        record.setDeletable(true);
        return super.create(record);
    }
    @Override
    protected TaskLabel updateExisting(TaskLabel existingRecord, TaskLabel record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }

}
