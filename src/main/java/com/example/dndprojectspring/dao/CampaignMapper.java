package com.example.dndprojectspring.dao;

import com.example.dndprojectspring.entity.Campaign;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CampaignMapper implements CustomMapper<Campaign, CampaignDto>{

    public CampaignDto toDto(Campaign campaign){
        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(campaign.getId());
        campaignDto.setTitle(campaign.getTitle());
        campaignDto.setDescription(campaign.getDescription());
        campaignDto.setDungeonMasterId(campaign.getDungeonMaster().getId());
        campaignDto.setUserIds(campaign.getUsers().stream().map(s -> s.getId()).collect(Collectors.toList()));
        return campaignDto;
    }

    public Campaign toEntity(CampaignDto campaignDto){
        //TODO
        return null;
    }

}
