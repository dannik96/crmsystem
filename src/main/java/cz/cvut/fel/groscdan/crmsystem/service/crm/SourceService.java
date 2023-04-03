package cz.cvut.fel.groscdan.crmsystem.service.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.Source;
import cz.cvut.fel.groscdan.crmsystem.repository.crm.SourceRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class SourceService extends AbstractService<SourceRepository, Source> {
    public SourceService(SourceRepository repository) {
        super(repository, "Source");
    }

    @Override
    protected Source updateExisting(Source existingRecord, Source record) {
        return null;
    }
}
