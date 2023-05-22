package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectTypeRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeService extends AbstractService<ProjectTypeRepository, ProjectType> {

    private final ProjectRepository projectRepository;

    public ProjectTypeService(ProjectTypeRepository repository, ProjectRepository projectRepository) {
        super(repository, "ProjectTypeService");
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectType create(ProjectType record) {
        record.setDeletable(true);
        return super.create(record);
    }
    @Override
    protected ProjectType updateExisting(ProjectType existingRecord, ProjectType record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }

}
