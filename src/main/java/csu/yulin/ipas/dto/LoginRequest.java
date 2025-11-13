package csu.yulin.ipas.dto;

import lombok.Data;

/**
 * @author lp
 */
@Data
public class LoginRequest {
    private String phoneNumber;
    private String password;
}