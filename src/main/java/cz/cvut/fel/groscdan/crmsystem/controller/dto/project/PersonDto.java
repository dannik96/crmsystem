package cz.cvut.fel.groscdan.crmsystem.controller.dto.project;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Person} entity
 */
@Data
public class PersonDto implements Serializable {
    private final Long id;
    private final String email;
    private final String login;
    private final String name;
    private final String surname;
    private final String phone;
}