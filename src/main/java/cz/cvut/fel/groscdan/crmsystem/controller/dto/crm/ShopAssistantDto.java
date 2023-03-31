package cz.cvut.fel.groscdan.crmsystem.controller.dto.crm;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.crm.ShopAssistant} entity
 */
@Data
public class ShopAssistantDto implements Serializable {
    private final Long id;
    private final String email;
    private final String login;
    private final String name;
    private final String surname;
    private final String phone;
}