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
    public void delete(Long id) throws DeleteError {
        ProjectState postState = getOneById(id, new DeleteError());
        List<Project> projects = projectRepository.findByProjectState(postState);
        projects.forEach(project -> {
            project.setProjectState(null);
            projectRepository.saveAndFlush(project);
        });
        repository.delete(postState);
    }

    @Override
    protected ProjectState updateExisting(ProjectState existingRecord, ProjectState record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }
}
