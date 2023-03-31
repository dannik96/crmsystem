package cz.cvut.fel.groscdan.crmsystem.controller.dto.crm;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.crm.PurchaseDetail} entity
 */
@Data
public class PurchaseDetailDto implements Serializable {
    private final Long id;
    private final Integer price;
    private final Integer count;
}