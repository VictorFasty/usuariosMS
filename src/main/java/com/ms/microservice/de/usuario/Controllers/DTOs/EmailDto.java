package com.ms.microservice.de.usuario.Controllers.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


public record EmailDto(
        Long userid,
        String emailTo,
        String subject,
        String text
) {
}
