package com.pms.pmSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmSystem.config.annotation.Auditable;
import com.pms.pmSystem.data.dto.LocationDTO;
import com.pms.pmSystem.data.dto.ProjectCreateRequestDTO;
import com.pms.pmSystem.data.enums.AuditAction;
import com.pms.pmSystem.data.mapper.CoreMapper;
import com.pms.pmSystem.data.mapper.converter.CreatedByMapper;
import com.pms.pmSystem.entity.model.Project;
import com.pms.pmSystem.repository.ProjectRepository;
import com.pms.pmSystem.service.ProjectService;

import jakarta.transaction.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private CoreMapper mapper;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CreatedByMapper createdByMapper;

    @Auditable(message = "'User ' + #projectCreateRequestDTO.createdBy + ' created a new project'",
            auditAction = "#auditAction", actor = "'username'",
            ipAddress = "#location.ipAddress",
            device = "#location.device", os = "#location.os", browser = "#location.browser"
    )
    @Override
    @Transactional
    public ProjectCreateRequestDTO create(ProjectCreateRequestDTO projectCreateRequestDTO, AuditAction auditAction, LocationDTO location) {
        // Convert DTO to entity
        Project project = mapper.toEntity(projectCreateRequestDTO);

        // Set createdBy using helper
        project = createdByMapper.setCreatedBy(project, projectCreateRequestDTO.getCreatedBy());

        return mapper.toDto(projectRepository.save(project));
    }

}
