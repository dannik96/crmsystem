package cz.cvut.fel.groscdan.crmsystem.service.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.PurchaseDetail;
import cz.cvut.fel.groscdan.crmsystem.repository.crm.PurchaseDetailRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDetailService extends AbstractService<PurchaseDetailRepository, PurchaseDetail> {
    public PurchaseDetailService(PurchaseDetailRepository repository) {
        super(repository, "PurchaseDetail");
    }

    @Override
    protected PurchaseDetail updateExisting(PurchaseDetail existingRecord, PurchaseDetail record) {
        return null;
    }
}
