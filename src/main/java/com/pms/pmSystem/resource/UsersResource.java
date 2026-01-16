package com.pms.pmSystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmSystem.data.dto.LocationDTO;
import com.pms.pmSystem.data.dto.PageDTO;
import com.pms.pmSystem.data.dto.UserCreateRequestDTO;
import com.pms.pmSystem.data.dto.UserDTO;
import com.pms.pmSystem.data.enums.AuditAction;
import com.pms.pmSystem.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UsersResource {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserCreateRequestDTO> create(@RequestBody UserCreateRequestDTO userCreateRequestDTO, LocationDTO location) {
        log.debug("Creating User object={}", userCreateRequestDTO);
        return new ResponseEntity<>(userService.create(userCreateRequestDTO, AuditAction.CREATE_USER,
                location), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageDTO<UserDTO>> list(Pageable pageable) {
        log.debug("Fetching faq list with pageable={}", pageable);
        return new ResponseEntity<>(userService.list(pageable), HttpStatus.OK);
    }
}
