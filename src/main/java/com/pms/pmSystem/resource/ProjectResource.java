package com.pms.pmSystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmSystem.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectResource {

    @Autowired
    ProjectService projectService;

/*     @PostMapping
    public ResponseEntity<> */
}
