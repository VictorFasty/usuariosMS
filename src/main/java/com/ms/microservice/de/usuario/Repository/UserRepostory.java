package com.ms.microservice.de.usuario.Repository;

import com.ms.microservice.de.usuario.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostory extends JpaRepository<UserModel, Long> {
}
