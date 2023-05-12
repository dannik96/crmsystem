package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.ChannelRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.ChannelTypeRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelTypeService extends AbstractService<ChannelTypeRepository, ChannelType> {


    private final ChannelRepository channelRepository;

    public ChannelTypeService(ChannelTypeRepository repository, ChannelRepository channelRepository) {
        super(repository, "Type");
        this.channelRepository = channelRepository;
    }

    @Override
    protected ChannelType updateExisting(ChannelType existingRecord, ChannelType record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }

    @Override
    public void delete(Long id) throws DeleteError {
        ChannelType channelType = getOneById(id, new DeleteError());
        List<Channel> channelList = channelType.getChannels().stream().toList();
        channelList.forEach(channelType::removeChannel);
        repository.delete(channelType);
    }
}
