package com.pms.pmSystem.data.dto;

import lombok.Data;

@Data
public class UserCreateRequestDTO {
    public Long id;
    private String fname;
    private String lname;
    private String email;
    private int status;
    private String phone;
    private String role;
    private String username;
    private String password;
}
