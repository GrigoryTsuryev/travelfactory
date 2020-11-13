package com.app.travelfactory.services;

import com.app.travelfactory.entities.Registration;
import com.app.travelfactory.exeptions.ContactNotFoundException;
import com.app.travelfactory.interfaces.IRegistrationService;
import com.app.travelfactory.repos.CampaignRepo;
import com.app.travelfactory.repos.ContactRepo;
import com.app.travelfactory.repos.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationImpl implements IRegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private CampaignRepo campaignRepo;

    @Override
    public Registration createRegistration(Registration registration) {
        contactRepo.findByEmail(registration.getEmail()).orElseThrow(ContactNotFoundException::new);
        return registrationRepo.save(registration);
    }
}
