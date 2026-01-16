package com.pms.pmSystem.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.pms.pmSystem.data.dto.UserCreateRequestDTO;
import com.pms.pmSystem.data.dto.UserDTO;
import com.pms.pmSystem.data.mapper.converter.LocalDateTimeToZonedDateTimeMapper;
import com.pms.pmSystem.data.mapper.converter.LocalDateToZonedDateTimeMapper;
import com.pms.pmSystem.entity.model.Users;

@Mapper(
        componentModel = "spring",
        uses = {
            LocalDateToZonedDateTimeMapper.class,
            LocalDateTimeToZonedDateTimeMapper.class
        }
)
public interface CoreMapper {

    UserCreateRequestDTO toDto(Users users);

    UserDTO toUserDto(Users users);

    Users toEntity(UserCreateRequestDTO userCreateRequestDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntity(UserCreateRequestDTO userCreateRequestDTO, @MappingTarget Users users);

}
