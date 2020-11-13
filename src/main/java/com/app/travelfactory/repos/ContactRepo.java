package com.app.travelfactory.repos;

import com.app.travelfactory.entities.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactRepo extends CrudRepository<Contact, Long> {
    Optional<Contact> findByEmail(String email);
}
