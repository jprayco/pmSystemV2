package com.pms.pmSystem.data.dto;

import lombok.Data;

@Data
public class UserDTO {
    public Long id;
    private String fname;
    private String lname;
    private String email;
    private int status;
    private String phone;
    private String role;
}
