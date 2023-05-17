package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.project.Project;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.AudienceRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.ChannelRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Service
public class ChannelService extends AbstractService<ChannelRepository, Channel> {

    private final ChannelTypeService channelTypeService;
    private final AudienceService audienceService;

    public ChannelService(ChannelRepository repository, ChannelTypeService channelTypeService, AudienceService audienceService) {
        super(repository, "Channel");
        this.channelTypeService = channelTypeService;
        this.audienceService = audienceService;
    }

    @Override
    protected Channel updateExisting(Channel existingRecord, Channel record) {
        existingRecord.setDescription(record.getDescription());
        existingRecord.setName(record.getName());
        existingRecord.setLocation(record.getLocation());
        return repository.saveAndFlush(existingRecord);
    }

    public void removeType(Long channelId, Long typeId) {
        Channel channel = getOneById(channelId, new PatchError());
        ChannelType channelType = channelTypeService.getOneById(typeId, new PatchError());

        channel.removeType(channelType);

        repository.saveAndFlush(channel);
    }

    public void addType(Long channelId, Long typeId) {
        Channel channel = getOneById(channelId, new PatchError());
        ChannelType channelType = channelTypeService.getOneById(typeId, new PatchError());

        channel.addType(channelType);


        repository.saveAndFlush(channel);
    }

    public void addAudience(Long channelId, Long audienceId) {
        Channel channel = getOneById(channelId, new PatchError());
        Audience type = audienceService.getOneById(audienceId, new PatchError());

        channel.addAudience(type);

        repository.saveAndFlush(channel);
    }

    public void removeAudience(Long channelId, Long audienceId) {
        Channel channel = getOneById(channelId, new PatchError());
        Audience type = audienceService.getOneById(audienceId, new PatchError());

        channel.removeAudience(type);

        repository.saveAndFlush(channel);
    }

    public Set<Post> getAllPosts(Long id) {
        Channel channel = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Channel with id " + id + " not found."));
        return channel.getPosts();
    }

    public Set<Audience> getAllAudiences(Long id) {
        Channel channel = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Channel with id " + id + " not found."));
        return channel.getAudiences();
    }

    public Set<ChannelType> getAllTypes(Long id) {
        Channel channel = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Channel with id " + id + " not found."));
        return channel.getChannelTypes();
    }

    public void addProject(Project project) {
    }
}
