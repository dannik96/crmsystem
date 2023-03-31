package cz.cvut.fel.groscdan.crmsystem.controller.dto.crm;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.crm.Source} entity
 */
@Data
public class SourceDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}