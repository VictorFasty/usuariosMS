package com.ms.microservice.de.usuario.Services;

import com.ms.microservice.de.usuario.Controllers.DTOs.UserRecordDTO;
import com.ms.microservice.de.usuario.Controllers.Mappers.UserMapper;
import com.ms.microservice.de.usuario.Repository.UserRepostory;
import com.ms.microservice.de.usuario.model.UserModel;
import com.ms.microservice.de.usuario.producer.UserProducer;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class UsuarioService {

    private final UserRepostory repostory;
    private final UserModel usermodel;
    private final UserMapper mapper;
    private final UserProducer userProducer;


    public ResponseEntity<UserModel> create(UserRecordDTO dto){
        UserModel savedUser = mapper.toEntity(dto);
        repostory.save(savedUser);
        userProducer.publishMessageEmail(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
