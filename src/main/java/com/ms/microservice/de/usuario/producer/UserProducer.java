package com.ms.microservice.de.usuario.producer;

import com.ms.microservice.de.usuario.Controllers.DTOs.EmailDto;
import com.ms.microservice.de.usuario.model.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        var emailDto = new EmailDto(
                userModel.getId(),
                userModel.getEmail(),
                "Cadastro realizado com sucesso!",
                userModel.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro..."
        );

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
