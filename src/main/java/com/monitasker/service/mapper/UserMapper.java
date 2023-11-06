package com.monitasker.service.mapper;

import com.monitasker.model.dto.UserDTO;
import com.monitasker.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);
    User fromDTO(UserDTO userDTO);
}
