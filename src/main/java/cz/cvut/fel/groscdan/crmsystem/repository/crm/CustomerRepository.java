package cz.cvut.fel.groscdan.crmsystem.repository.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}