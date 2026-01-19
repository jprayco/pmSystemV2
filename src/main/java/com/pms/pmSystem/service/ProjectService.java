package com.pms.pmSystem.service;

import com.pms.pmSystem.data.dto.LocationDTO;
import com.pms.pmSystem.data.dto.ProjectCreateRequestDTO;
import com.pms.pmSystem.data.enums.AuditAction;

public interface ProjectService {

    ProjectCreateRequestDTO create(ProjectCreateRequestDTO projectCreateRequestDTO, AuditAction createProject, LocationDTO location);

}
