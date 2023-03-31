package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.model.channel.PostState;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostStateRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PostStateService extends AbstractService<PostStateRepository, PostState> {

    public PostStateService(PostStateRepository repository) {
        super(repository);
    }

    @Override
    protected PostState updateExisting(PostState existingRecord, PostState record) {
        // TODO
        return null;
    }
}
