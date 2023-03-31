package cz.cvut.fel.groscdan.crmsystem.security.repository;

import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}