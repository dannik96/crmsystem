package cz.cvut.fel.groscdan.crmsystem.repository.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
