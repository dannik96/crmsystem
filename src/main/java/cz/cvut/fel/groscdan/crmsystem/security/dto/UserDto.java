package cz.cvut.fel.groscdan.crmsystem.security.dto;

import cz.cvut.fel.groscdan.crmsystem.security.model.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.security.model.User} entity
 */
@AllArgsConstructor
@Getter
public class UserDto implements Serializable {
    private final Long id;
    private final Boolean deleted;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final String username;
    private final String email;
    private final String password;
    private final PersonDto person;
    private final Set<UserRoleDto1> roles;

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.model.project.Person} entity
     */
    @AllArgsConstructor
    @Getter
    public static class PersonDto implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final String email;
        private final String login;
        private final String name;
        private final String surname;
        private final String phone;
    }

    /**
     * A DTO for the {@link cz.cvut.fel.groscdan.crmsystem.security.model.UserRole} entity
     */
    @AllArgsConstructor
    @Getter
    public static class UserRoleDto1 implements Serializable {
        private final Long id;
        private final Boolean deleted;
        private final LocalDateTime created;
        private final LocalDateTime modified;
        private final ERole name;
    }
}