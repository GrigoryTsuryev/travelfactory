package com.app.travelfactory.controllers;

import com.app.travelfactory.entities.Campaign;
import com.app.travelfactory.interfaces.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("campaign")
public class CampaignController {

    @Autowired
    private ICampaignService campaignService;

    @PostMapping("/marketing/ws/partner/campaign/create")
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign){
        return new ResponseEntity<>(campaignService.createCampaign(campaign), HttpStatus.CREATED);
    }

}
