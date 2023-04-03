package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Type;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.AudienceRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.ChannelRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.TypeRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Service
public class ChannelService extends AbstractService<ChannelRepository, Channel> {

    private final TypeRepository typeRepository;
    private final AudienceRepository audienceRepository;

    public ChannelService(ChannelRepository repository, TypeRepository typeRepository, AudienceRepository audienceRepository) {
        super(repository, "Channel");
        this.typeRepository = typeRepository;
        this.audienceRepository = audienceRepository;
    }

    @Override
    protected Channel updateExisting(Channel existingRecord, Channel record) {
        existingRecord.setDescription(record.getDescription());
        existingRecord.setName(record.getName());
        existingRecord.setLocation(record.getLocation());
        return repository.saveAndFlush(existingRecord);
    }

    public void removeType(Long channelId, Long typeId) {
        Channel channel = repository.findById(channelId).orElseThrow(PatchError::new);
        Type type = typeRepository.findById(typeId).orElseThrow(PatchError::new);

        if (channel.removeType(type)) {
            throw new PatchError();
        }

        repository.saveAndFlush(channel);
    }

    public void addType(Long channelId, Long typeId) {
        Channel channel = repository.findById(channelId).orElseThrow(PatchError::new);
        Type type = typeRepository.findById(typeId).orElseThrow(PatchError::new);

        if (channel.addType(type)) {
            throw new PatchError();
        }

        repository.saveAndFlush(channel);
    }

    public void addAudience(Long channelId, Long audienceId) {
        Channel channel = repository.findById(channelId).orElseThrow(PatchError::new);
        Audience type = audienceRepository.findById(audienceId).orElseThrow(PatchError::new);

        if (channel.addAudience(type)) {
            throw new PatchError();
        }

        repository.saveAndFlush(channel);
    }

    public void removeAudience(Long channelId, Long audienceId) {
        Channel channel = repository.findById(channelId).orElseThrow(PatchError::new);
        Audience type = audienceRepository.findById(audienceId).orElseThrow(PatchError::new);

        if (channel.removeAudience(type)) {
            throw new PatchError();
        }

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

    public Set<Type> getAllTypes(Long id) {
        Channel channel = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Channel with id " + id + " not found."));
        return channel.getTypes();
    }
}
