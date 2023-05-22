package cz.cvut.fel.groscdan.crmsystem.controller.dto.crm;

import cz.cvut.fel.groscdan.crmsystem.model.crm.Customer;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Customer} entity
 */
@Data
public class CustomerDto implements Serializable {
    private final Long id;
    private final String email;
    private final String login;
    private final String name;
    private final String surname;
    private final String phone;
    private final Boolean deleted;

}