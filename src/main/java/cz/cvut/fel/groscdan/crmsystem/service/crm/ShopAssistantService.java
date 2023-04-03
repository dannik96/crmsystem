package cz.cvut.fel.groscdan.crmsystem.service.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.ShopAssistant;
import cz.cvut.fel.groscdan.crmsystem.repository.crm.ShopAssisantRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ShopAssistantService extends AbstractService<ShopAssisantRepository, ShopAssistant> {
    public ShopAssistantService(ShopAssisantRepository repository) {
        super(repository, "ShopAssistant");
    }

    @Override
    protected ShopAssistant updateExisting(ShopAssistant existingRecord, ShopAssistant record) {
        return null;
    }
}
