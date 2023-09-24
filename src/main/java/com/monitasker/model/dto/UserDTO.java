package com.monitasker.model.dto;

import com.monitasker.model.entity.Task;
import com.monitasker.model.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record UserDTO(Long id, String username, @Email String email,
                      byte[] passwordHash, List<Task> tasks,
                      @Enumerated(EnumType.STRING) UserRole userRole) implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
}
