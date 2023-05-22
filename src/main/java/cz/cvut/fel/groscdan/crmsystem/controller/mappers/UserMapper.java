package cz.cvut.fel.groscdan.crmsystem.controller.mappers;

import cz.cvut.fel.groscdan.crmsystem.security.dto.UserDto;
import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapper {
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    List<User> userDtoToUser(List<UserDto> userDto);

    List<UserDto> userToUserDto(List<User> user);

    Set<User> userDtoToUser(Set<UserDto> userDto);

    Set<UserDto> userToUserDto(Set<User> user);


}
