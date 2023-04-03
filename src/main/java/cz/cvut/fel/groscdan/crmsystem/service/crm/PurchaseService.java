package cz.cvut.fel.groscdan.crmsystem.service.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.Purchase;
import cz.cvut.fel.groscdan.crmsystem.repository.crm.PurchaseRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService extends AbstractService<PurchaseRepository, Purchase> {
    public PurchaseService(PurchaseRepository repository) {
        super(repository, "Purchase");
    }

    @Override
    protected Purchase updateExisting(Purchase existingRecord, Purchase record) {
        return null;
    }
}
