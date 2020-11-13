package com.app.travelfactory.services;

import com.app.travelfactory.entities.Campaign;
import com.app.travelfactory.interfaces.ICampaignService;
import com.app.travelfactory.repos.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignImpl implements ICampaignService {

    @Autowired
    private CampaignRepo campaignRepo;

    @Override
    public Campaign createCampaign(Campaign campaign) {
        return campaignRepo.save(campaign);
    }
}
