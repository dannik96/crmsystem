package cz.cvut.fel.groscdan.crmsystem.controller.mappers;

import cz.cvut.fel.groscdan.crmsystem.controller.dto.UserRoleDto;
import cz.cvut.fel.groscdan.crmsystem.security.model.UserRole;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserRoleMapper {
    UserRole userRoleDtoToUserRole(UserRoleDto userRoleDto);

    UserRoleDto userRoleToUserRoleDto(UserRole userRole);
    List<UserRole> userRoleDtoToUserRole(List<UserRoleDto> userRoleDto);

    List<UserRoleDto> userRoleToUserRoleDto(List<UserRole> userRole);
    Set<UserRole> userRoleDtoToUserRole(Set<UserRoleDto> userRoleDto);

    Set<UserRoleDto> userRoleToUserRoleDto(Set<UserRole> userRole);

}
