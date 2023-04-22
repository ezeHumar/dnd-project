package com.example.dndprojectspring.service;

import com.example.dndprojectspring.entity.Campaign;
import com.example.dndprojectspring.entity.DungeonMaster;
import com.example.dndprojectspring.entity.User;
import com.example.dndprojectspring.exception.NoContentException;
import com.example.dndprojectspring.repository.CampaignJpaRepository;
import com.example.dndprojectspring.repository.DungeonMasterJpaRepository;
import com.example.dndprojectspring.repository.UserJpaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    CampaignJpaRepository campaignRepository;
    DungeonMasterJpaRepository dungeonMasterRepository;
    UserJpaRepository userRepository;
    @Autowired
    public CampaignService(CampaignJpaRepository campaignRepository,
                           DungeonMasterJpaRepository dungeonMasterRepository,
                           UserJpaRepository userRepository){
        this.campaignRepository = campaignRepository;
        this.dungeonMasterRepository = dungeonMasterRepository;
        this.userRepository = userRepository;
    }

    public Campaign add(@Valid Campaign campaign, String userEmail){

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new NoContentException(null, null));

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
