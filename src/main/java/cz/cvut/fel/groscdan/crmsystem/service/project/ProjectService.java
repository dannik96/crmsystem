package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectState;
import cz.cvut.fel.groscdan.crmsystem.model.project.ProjectType;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import cz.cvut.fel.groscdan.crmsystem.service.channel.ChannelService;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends AbstractService<ProjectRepository, Project> {

    private final ChannelService channelService;
    private final ProjectStateService projectStateService;
    private final ProjectTypeService projectTypeService;

    public ProjectService(ProjectRepository repository, ChannelService channelService, ProjectStateService projectStateService, ProjectTypeService projectTypeService) {
        super(repository, "Project");
        this.channelService = channelService;
        this.projectStateService = projectStateService;
        this.projectTypeService = projectTypeService;
    }

    // TODO
    @Override
    protected Project updateExisting(Project existingRecord, Project record) {
        existingRecord.setDescription(record.getDescription());
        existingRecord.setName(record.getName());
        existingRecord.setStart(record.getStart());
        existingRecord.setDeadline(record.getDeadline());

        return repository.saveAndFlush(existingRecord);
    }

    public void addChannel(Long idProject, Long idChannel) {
        Channel channel = channelService.getOneById(idChannel, new PatchError());
        Project project = getOneById(idProject, new PatchError());

        project.addChannel(channel);

        repository.saveAndFlush(project);
    }

    public void removeChannel(Long idProject, Long idChannel) {
        Channel channel = channelService.getOneById(idChannel, new PatchError());
        Project project = getOneById(idProject, new PatchError());

        project.removeChannel(channel);

        repository.saveAndFlush(project);
    }

    public void setState(Long idProject, Long stateId) {
        Project project = getOneById(idProject, new PatchError());
        ProjectState projectState = projectStateService.getOneById(stateId, new PatchError());

        project.setProjectState(projectState);

        repository.saveAndFlush(project);
    }

    public void setType(Long idProject, Long typeId) {
        Project project = getOneById(idProject, new PatchError());
        ProjectType projectType = projectTypeService.getOneById(typeId, new PatchError());

        project.setProjectType(projectType);

        repository.saveAndFlush(project);
    }
}
