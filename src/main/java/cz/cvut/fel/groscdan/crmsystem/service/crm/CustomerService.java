package cz.cvut.fel.groscdan.crmsystem.service.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.Customer;
import cz.cvut.fel.groscdan.crmsystem.repository.crm.CustomerRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<CustomerRepository, Customer> {

    public CustomerService(CustomerRepository repository) {
        super(repository, "Customer");
    }

    @Override
    protected Customer updateExisting(Customer existingRecord, Customer record) {
        return null;
    }
}
