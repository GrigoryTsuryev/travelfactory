package com.app.travelfactory.repos;

import com.app.travelfactory.entities.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<Registration, Long> {
}
