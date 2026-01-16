package com.pms.pmSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.pmSystem.config.annotation.Auditable;
import com.pms.pmSystem.data.dto.LocationDTO;
import com.pms.pmSystem.data.dto.PageDTO;
import com.pms.pmSystem.data.dto.UserCreateRequestDTO;
import com.pms.pmSystem.data.dto.UserDTO;
import com.pms.pmSystem.data.enums.AuditAction;
import com.pms.pmSystem.data.mapper.CoreMapper;
import com.pms.pmSystem.entity.model.Users;
import com.pms.pmSystem.repository.UserRepository;
import com.pms.pmSystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CoreMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Auditable(message = "'User ' + #userCreateRequestDTO.username + ' created a new account'",
            auditAction = "#auditAction", actor = "'username'",
            ipAddress = "#location.ipAddress",
            device = "#location.device", os = "#location.os", browser = "#location.browser"
    )
    @Override
    @Transactional
    public UserCreateRequestDTO create(UserCreateRequestDTO userCreateRequestDTO, AuditAction auditAction, LocationDTO location) {
        return mapper.toDto(userRepository.save(mapper.toEntity(userCreateRequestDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public PageDTO<UserDTO> list(Pageable pageable) {
        Page<Users> users = userRepository.findAll(pageable);
        Page<UserDTO> userDTOs = users.map(mapper::toUserDto);
        return PageDTO.newPageInfo(users, userDTOs.getContent());
    }

}
