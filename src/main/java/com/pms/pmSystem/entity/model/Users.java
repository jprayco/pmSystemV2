package com.pms.pmSystem.entity.model;

import com.pms.pmSystem.entity.AbstractAuditableModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "USERS")
public class Users {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FNAME")
    private String fname;

    @Column(name = "LNAME")
    private String lname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;
}
