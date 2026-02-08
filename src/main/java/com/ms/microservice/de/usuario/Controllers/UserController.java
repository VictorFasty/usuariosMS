package com.ms.microservice.de.usuario.Controllers;

import com.ms.microservice.de.usuario.Controllers.DTOs.UserRecordDTO;
import com.ms.microservice.de.usuario.Services.UsuarioService;
import com.ms.microservice.de.usuario.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UsuarioService usuarioService;



    @PostMapping("/users")
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserRecordDTO dto){
        return usuarioService.create(dto);
    }


}
