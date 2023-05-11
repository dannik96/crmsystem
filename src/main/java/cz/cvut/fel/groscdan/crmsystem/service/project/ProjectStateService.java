package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectStateRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ProjectStateService extends AbstractService<ProjectStateRepository, ProjectState> {
    public ProjectStateService(ProjectStateRepository repository) {
        super(repository, "ProjectStateService");
    }

    @Override
    protected ProjectState updateExisting(ProjectState existingRecord, ProjectState record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }
}
