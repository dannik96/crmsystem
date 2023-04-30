package cz.cvut.fel.groscdan.crmsystem.config;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostRepository;
import cz.cvut.fel.groscdan.crmsystem.security.model.ERole;
import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import cz.cvut.fel.groscdan.crmsystem.security.model.UserRole;
import cz.cvut.fel.groscdan.crmsystem.security.repository.UserRepository;
import cz.cvut.fel.groscdan.crmsystem.security.repository.UserRoleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class DataLoader implements ApplicationRunner {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public DataLoader(PostRepository tutorialRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.postRepository = tutorialRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public void run(ApplicationArguments args) {
        postRepository.save(new Post("lala"));
        User user = new User("admin", "admin", passwordEncoder.encode("admin"));
        UserRole userRole = userRoleRepository.getReferenceById(1L);
//        userRoleRepository.save(userRole);
        user.addRole(userRole);
        userRepository.save(user);
    }
}