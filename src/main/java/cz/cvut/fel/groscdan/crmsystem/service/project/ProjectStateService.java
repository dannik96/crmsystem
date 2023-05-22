package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectStateRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectStateService extends AbstractService<ProjectStateRepository, ProjectState> {

    private final ProjectRepository projectRepository;

    public ProjectStateService(ProjectStateRepository repository, ProjectRepository projectRepository) {
        super(repository, "ProjectStateService");
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectState create(ProjectState record) {
        record.setDeletable(true);
        return super.create(record);
    }

    @Override
    protected ProjectState updateExisting(ProjectState existingRecord, ProjectState record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }

    public ProjectState getOneByStateName(String name) {
        return repository.getProjectStateByNameContains(name);
    }
}
