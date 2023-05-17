package cz.cvut.fel.groscdan.crmsystem.service.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.ShopAssistant;
import cz.cvut.fel.groscdan.crmsystem.repository.crm.ShopAssistantRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ShopAssistantService extends AbstractService<ShopAssistantRepository, ShopAssistant> {
    public ShopAssistantService(ShopAssistantRepository repository) {
        super(repository, "ShopAssistant");
    }

    @Override
    protected ShopAssistant updateExisting(ShopAssistant existingRecord, ShopAssistant record) {
        return null;
    }
}
