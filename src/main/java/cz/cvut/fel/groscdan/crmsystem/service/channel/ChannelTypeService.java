package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.ChannelTypeRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ChannelTypeService extends AbstractService<ChannelTypeRepository, ChannelType> {

    public ChannelTypeService(ChannelTypeRepository repository) {
        super(repository, "Type");
    }

    @Override
    protected ChannelType updateExisting(ChannelType existingRecord, ChannelType record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }
}
