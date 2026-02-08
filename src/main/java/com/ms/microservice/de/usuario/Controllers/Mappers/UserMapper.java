package com.ms.microservice.de.usuario.Controllers.Mappers;

import com.ms.microservice.de.usuario.Controllers.DTOs.UserRecordDTO;
import com.ms.microservice.de.usuario.model.UserModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRecordDTO toDTO(UserModel userModel);
    UserModel toEntity(UserRecordDTO userRecordDTO);
}
