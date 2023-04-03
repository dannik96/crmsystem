package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.repository.project.ProjectRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import cz.cvut.fel.groscdan.crmsystem.service.channel.ChannelService;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends AbstractService<ProjectRepository, Project> {

    private final ChannelService channelService;

    public ProjectService(ProjectRepository repository, ChannelService channelService) {
        super(repository, "Project");
        this.channelService = channelService;
    }

    // TODO
    @Override
    protected Project updateExisting(Project existingRecord, Project record) {
        return null;
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
}
