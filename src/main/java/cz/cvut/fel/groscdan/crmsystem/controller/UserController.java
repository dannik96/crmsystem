package cz.cvut.fel.groscdan.crmsystem.controller;


import cz.cvut.fel.groscdan.crmsystem.controller.dto.UserRoleDto;
import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.UserMapper;
import cz.cvut.fel.groscdan.crmsystem.controller.mappers.UserRoleMapper;
import cz.cvut.fel.groscdan.crmsystem.security.dto.UserDto;
import cz.cvut.fel.groscdan.crmsystem.security.model.User;
import cz.cvut.fel.groscdan.crmsystem.security.model.UserRole;
import cz.cvut.fel.groscdan.crmsystem.security.service.UserRoleService;
import cz.cvut.fel.groscdan.crmsystem.util.UserToPersonMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserToPersonMapper userToPersonMapper;
    private final UserRoleService userRoleService;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRoleMapper userRoleMapper = Mappers.getMapper(UserRoleMapper.class);

    public UserController(UserToPersonMapper userService, UserRoleService userRoleService) {
        this.userToPersonMapper = userService;
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        List<User> users = userToPersonMapper.getAll();
        return new ResponseEntity<>(userMapper.userToUserDto(users), HttpStatus.OK);
    }

    @GetMapping("/user-roles")
    public ResponseEntity<List<UserRoleDto>> getRoles(){
        List<UserRole> userRoles = userRoleService.getAll();
        return new ResponseEntity<>(userRoleMapper.userRoleToUserRoleDto(userRoles), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id){
        User user = userToPersonMapper.getOneById(id);
        return new ResponseEntity<>(userMapper.userToUserDto(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        user = userToPersonMapper.create(user);
        return new ResponseEntity<>(userMapper.userToUserDto(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto typeDto) {
        User user = userMapper.userDtoToUser(typeDto);
        user = userToPersonMapper.update(user);
        return new ResponseEntity<>(userMapper.userToUserDto(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable Long id) throws DeleteError {
        userToPersonMapper.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping("/{id}/set-roles")
    public ResponseEntity<UserDto> updateRoles(@PathVariable Long id, @RequestBody List<UserRoleDto> userRoleDtos) throws DeleteError {
        List<UserRole> userRole = userRoleMapper.userRoleDtoToUserRole(userRoleDtos);
        User user = userToPersonMapper.setRoles(id, userRole);
        return new ResponseEntity<>(userMapper.userToUserDto(user), HttpStatus.OK);
    }
}
