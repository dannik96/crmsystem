package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Type;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.TypeRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends AbstractService<TypeRepository, Type> {

    public TypeService(TypeRepository repository) {
        super(repository);
    }

    @Override
    protected Type updateExisting(Type existingRecord, Type record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return repository.saveAndFlush(existingRecord);
    }
}
