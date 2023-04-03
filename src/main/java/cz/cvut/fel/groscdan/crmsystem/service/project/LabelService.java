package cz.cvut.fel.groscdan.crmsystem.service.project;

import cz.cvut.fel.groscdan.crmsystem.model.project.Label;
import cz.cvut.fel.groscdan.crmsystem.repository.project.LabelRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class LabelService extends AbstractService<LabelRepository, Label> {

    public LabelService(LabelRepository repository) {
        super(repository, "Label");
    }

    @Override
    protected Label updateExisting(Label existingRecord, Label record) {
        return null;
    }
}
