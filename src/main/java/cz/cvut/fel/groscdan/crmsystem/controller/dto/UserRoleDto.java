package cz.cvut.fel.groscdan.crmsystem.controller.dto;

import cz.cvut.fel.groscdan.crmsystem.security.model.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.security.model.UserRole} entity
 */
@AllArgsConstructor
@Getter
public class UserRoleDto implements Serializable {
    private final Long id;
    private final Boolean deleted;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final ERole name;
}