package cz.cvut.fel.groscdan.crmsystem.security.repository;

import cz.cvut.fel.groscdan.crmsystem.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}