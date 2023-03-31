package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends AbstractService<ProjectRepository, Project> {

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }

    // TODO
    @Override
    protected Project updateExisting(Project existingRecord, Project record) {
        return null;
    }
}
