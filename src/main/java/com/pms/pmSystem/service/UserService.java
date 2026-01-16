package com.pms.pmSystem.service;

import org.springframework.data.domain.Pageable;

import com.pms.pmSystem.data.dto.LocationDTO;
import com.pms.pmSystem.data.dto.PageDTO;
import com.pms.pmSystem.data.dto.UserCreateRequestDTO;
import com.pms.pmSystem.data.dto.UserDTO;
import com.pms.pmSystem.data.enums.AuditAction;

public interface UserService {

    UserCreateRequestDTO create(UserCreateRequestDTO userCreateRequestDTO, AuditAction auditAction, LocationDTO location);

    PageDTO<UserDTO> list(Pageable pageable);
}
