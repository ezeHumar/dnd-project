package com.example.dndprojectspring.service;

import com.example.dndprojectspring.entity.Campaign;
import com.example.dndprojectspring.entity.DungeonMaster;
import com.example.dndprojectspring.entity.User;
import com.example.dndprojectspring.exception.NoContentException;
import com.example.dndprojectspring.repository.CampaignJpaRepository;
import com.example.dndprojectspring.repository.DungeonMasterJpaRepository;
import com.example.dndprojectspring.repository.UserJpaRepository;
import com.example.dndprojectspring.utils.AuthUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    CampaignJpaRepository campaignRepository;
    DungeonMasterJpaRepository dungeonMasterRepository;
    UserJpaRepository userRepository;

    AuthUtils authUtils;

    @Autowired
    public CampaignService(CampaignJpaRepository campaignRepository,
                           DungeonMasterJpaRepository dungeonMasterRepository,
                           UserJpaRepository userRepository,
                           AuthUtils authUtils){
        this.campaignRepository = campaignRepository;
        this.dungeonMasterRepository = dungeonMasterRepository;
        this.userRepository = userRepository;
        this.authUtils = authUtils;
    }

    public Campaign add(@Valid Campaign campaign){

        User user = userRepository.findByEmail(
                authUtils.getAuthenticatedEmail())
                .orElseThrow(() -> new NoContentException(null, null));

        campaign.setDungeonMaster(
                dungeonMasterRepository.save(
                        createDungeonMasterForUser(user)
                )
        );

        campaign.addUser(campaign.getDungeonMaster().getUser());
        Campaign addedCampaign = campaignRepository.save(campaign);
        user.addCampaign(addedCampaign);
        userRepository.save(user);
        return addedCampaign;
    }

    public List<Campaign> listUserCampaigns(){
//        return campaignRepository.findAllByUsers_Email(sessionContext.getEmail()).get();
        return campaignRepository.findAll();
//        return null;
    }

    private DungeonMaster createDungeonMasterForUser(User user){
        DungeonMaster dungeonMaster = new DungeonMaster();
        dungeonMaster.setUser(user);
        return dungeonMaster;
    }

}
