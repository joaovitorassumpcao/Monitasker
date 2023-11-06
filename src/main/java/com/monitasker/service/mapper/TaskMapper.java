package com.monitasker.service.mapper;

import com.monitasker.model.dto.TaskDTO;
import com.monitasker.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
    TaskDTO ToDTO(Task task);
    Task fromDTO(TaskDTO taskDTO);
}
