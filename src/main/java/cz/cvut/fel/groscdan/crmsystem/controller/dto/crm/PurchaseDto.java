package cz.cvut.fel.groscdan.crmsystem.controller.dto.crm;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.crm.Purchase} entity
 */
@Data
public class PurchaseDto implements Serializable {
    private final Long id;
    private final LocalDateTime purchaseDate;
}