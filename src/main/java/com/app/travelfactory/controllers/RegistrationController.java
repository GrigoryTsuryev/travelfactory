package com.app.travelfactory.controllers;

import com.app.travelfactory.entities.Registration;
import com.app.travelfactory.exeptions.ContactNotFoundException;
import com.app.travelfactory.interfaces.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;

    @PostMapping("/marketing/ws/partner/campaign/create")
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration){
        return new ResponseEntity<>(registrationService.createRegistration(registration), HttpStatus.OK);
    }

}
