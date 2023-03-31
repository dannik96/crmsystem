package cz.cvut.fel.groscdan.crmsystem.security.dto;


import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
