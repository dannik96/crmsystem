package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectTypeRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ProjectTypeService extends AbstractService<ProjectTypeRepository, ProjectType> {

    public ProjectTypeService(ProjectTypeRepository repository) {
        super(repository, "ProjectTypeService");
    }

    @Override
    protected ProjectType updateExisting(ProjectType existingRecord, ProjectType record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }
}
