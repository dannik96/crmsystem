package cz.cvut.fel.groscdan.crmsystem.service.event;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.channel.ChannelType;
import cz.cvut.fel.groscdan.crmsystem.model.event.Event;
import cz.cvut.fel.groscdan.crmsystem.model.event.EventType;
import cz.cvut.fel.groscdan.crmsystem.repository.event.EventTypeRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeService extends AbstractService<EventTypeRepository, EventType> {
    public EventTypeService(EventTypeRepository repository) {
        super(repository, "EventType");
    }

    @Override
    protected EventType updateExisting(EventType existingRecord, EventType record) {
        existingRecord.setDescription(record.getDescription());
        existingRecord.setName(record.getName());
        return repository.saveAndFlush(existingRecord);
    }

}
