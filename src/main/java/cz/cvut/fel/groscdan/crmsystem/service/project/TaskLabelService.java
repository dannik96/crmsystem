package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.TaskLabel;
import cz.cvut.fel.groscdan.crmsystem.repository.project.TaskLabelRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TaskLabelService extends AbstractService<TaskLabelRepository, TaskLabel> {

    public TaskLabelService(TaskLabelRepository repository) {
        super(repository, "Label");
    }

    @Override
    protected TaskLabel updateExisting(TaskLabel existingRecord, TaskLabel record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }
}
