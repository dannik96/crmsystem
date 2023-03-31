package cz.cvut.fel.groscdan.crmsystem.controller.dto.crm;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.crm.Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final Integer price;
}