package cz.cvut.fel.groscdan.crmsystem.util;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import cz.cvut.fel.groscdan.crmsystem.security.model.UserRole;
import cz.cvut.fel.groscdan.crmsystem.security.repository.UserRepository;
import cz.cvut.fel.groscdan.crmsystem.security.service.UserService;
import cz.cvut.fel.groscdan.crmsystem.service.project.PersonService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class UserToPersonMapper {

    private final UserService userService;
    private final UserRepository userRepository;

    private final PersonService personService;

    public UserToPersonMapper(UserService userService, UserRepository userRepository, PersonService personService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.personService = personService;
    }

    private void deletePerson(Long id) {
        personService.delete(id);
    }

    private void deleteUser(Long id) {
        userService.delete(id);
    }

    public void delete(Long userId) {
        User user = userService.getOneById(userId);

        deleteUser(user.getId());
        deletePerson(user.getPerson().getId());
    }

    public User update(User newUser) {
        newUser.getPerson().setUser(newUser);
        personService.update(newUser.getPerson());

        return userService.update(newUser);
    }

    public User setRoles(Long userId,List<UserRole> roles) {
        User user = userService.getOneById(userId, new PatchError());

        user.setRoles(new HashSet<>(roles));

        return userRepository.saveAndFlush(user);
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public User getOneById(Long id) {
        return userService.getOneById(id);
    }

    public User create(User user) {
        Person person = new Person(user.getPerson());
        user.setPerson(null);
        User newUser = userService.create(user);
        person.setUser(newUser);
        personService.create(person);
        return getOneById(newUser.getId());
    }



}
