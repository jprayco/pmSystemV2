package com.pms.pmSystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmSystem.data.dto.LocationDTO;
import com.pms.pmSystem.data.dto.ProjectCreateRequestDTO;
import com.pms.pmSystem.data.enums.AuditAction;
import com.pms.pmSystem.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectResource {

    @Autowired
    ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectCreateRequestDTO> create(@RequestBody ProjectCreateRequestDTO projectCreateRequestDTO, LocationDTO location){
        log.debug("Creating Project object={}", projectCreateRequestDTO);
        return new ResponseEntity<>(projectService.create(projectCreateRequestDTO,AuditAction.CREATE_PROJECT, location), HttpStatus.CREATED);
    }
}
