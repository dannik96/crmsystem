package cz.cvut.fel.groscdan.crmsystem.repository.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
