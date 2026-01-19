package com.pms.pmSystem.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public Long id;
    private String fname;
    private String lname;
    private String email;
    private int status;
    private String phone;
    private String role;

    public UserDTO(Long id){
        this.id = id;
    }
}
