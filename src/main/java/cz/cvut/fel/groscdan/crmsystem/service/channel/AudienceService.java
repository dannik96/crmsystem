package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Audience;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.AudienceRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AudienceService extends AbstractService<AudienceRepository, Audience> {
    public AudienceService(AudienceRepository repository) {
        super(repository);
    }

    @Override
    protected Audience updateExisting(Audience existingRecord, Audience record) {
        // TODO
        return null;
    }
}
