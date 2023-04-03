package cz.cvut.fel.groscdan.crmsystem.service.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import cz.cvut.fel.groscdan.crmsystem.repository.crm.ProductRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<ProductRepository, Product> {
    public ProductService(ProductRepository repository) {
        super(repository, "Product");
    }

    @Override
    protected Product updateExisting(Product existingRecord, Product record) {
        return null;
    }
}
