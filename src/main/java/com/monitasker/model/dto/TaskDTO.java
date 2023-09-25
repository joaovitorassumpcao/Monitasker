package com.monitasker.model.dto;

import java.io.Serial;
import java.io.Serializable;

public record TaskDTO(Long id, UserDTO userDTO, Boolean isDone,
                      String content) implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;


}
