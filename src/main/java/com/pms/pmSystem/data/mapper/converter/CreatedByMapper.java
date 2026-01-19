package com.pms.pmSystem.data.mapper.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pms.pmSystem.entity.model.Users;
import com.pms.pmSystem.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class CreatedByMapper {

    @Autowired
    private UserRepository userRepository;

    public <T> T setCreatedBy(T entity, Long createdById) {
        if (createdById == null) return entity;
        
        Users user = userRepository.findById(createdById)
                .orElseThrow(() -> new EntityNotFoundException(
                "User not found with id: " + createdById));

        try {
            // Use reflection to set createdBy field
            var method = entity.getClass().getMethod("setCreatedBy", Users.class);
            method.invoke(entity, user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set createdBy on entity", e);
        }

        return entity;
    }
}
