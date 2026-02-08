package com.ms.microservice.de.usuario.Controllers.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public record UserRecordDTO(
        @NotNull
        String name,
        @Email
        @NotNull
        String email

) {}
