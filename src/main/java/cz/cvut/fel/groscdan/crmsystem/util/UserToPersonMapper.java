package cz.cvut.fel.groscdan.crmsystem.util;

import cz.cvut.fel.groscdan.crmsystem.model.project.Person;
import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import cz.cvut.fel.groscdan.crmsystem.security.service.UserService;
import cz.cvut.fel.groscdan.crmsystem.service.project.PersonService;

public class UserToPersonMapper {

    private final UserService userService;
    private final PersonService personService;

    public UserToPersonMapper(UserService userService, PersonService personService) {
        this.userService = userService;
        this.personService = personService;
    }

    public Person getPerson(User user){
        Person person = personService.getOneById(user.getId());

        return person;
    }

    public User getUser(Person person) {
        return userService.getOneById(person.getId());
    }
}
