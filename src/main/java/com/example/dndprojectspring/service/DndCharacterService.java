package com.example.dndprojectspring.service;

import com.example.dndprojectspring.entity.Campaign;
import com.example.dndprojectspring.entity.DndCharacter;
import com.example.dndprojectspring.entity.User;
import com.example.dndprojectspring.exception.NoContentException;
import com.example.dndprojectspring.repository.CampaignJpaRepository;
import com.example.dndprojectspring.repository.DndCharacterJpaRepository;
import com.example.dndprojectspring.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DndCharacterService {

    DndCharacterJpaRepository dndCharacterRepository;
    CampaignJpaRepository campaignRepository;
    UserJpaRepository userRepository;

    @Autowired
    public DndCharacterService(DndCharacterJpaRepository dndCharacterRepository,
                               CampaignJpaRepository campaignRepository,
                               UserJpaRepository userRepository) {
        this.dndCharacterRepository = dndCharacterRepository;
        this.campaignRepository = campaignRepository;
        this.userRepository = userRepository;
    }

    public DndCharacter findById(Long id){
        return dndCharacterRepository.findById(id).orElseThrow(() -> new NoContentException(null, null));
    }

    public List<DndCharacter> findAll(){
        return dndCharacterRepository.findAll();
    }

    public DndCharacter add(DndCharacter dndCharacter) {

        Campaign campaign = campaignRepository.findById(dndCharacter.getCampaign().getId())
                .orElseThrow(() -> new NoContentException(null, null));

        //TODO: Use the email from the authentication
        String userCreatorEmail = dndCharacter.getUser().getEmail();
        User userCreator = userRepository.findByEmail(userCreatorEmail).get();

        dndCharacter.setCampaign(campaign);
        dndCharacter.setUser(userCreator);

        campaign.getUsers().add(userCreator);

        campaignRepository.save(campaign);

        return dndCharacterRepository.save(dndCharacter);
    }

    public void remove(Long id){
        try{
            dndCharacterRepository.deleteById(id);
        }
        catch(IllegalArgumentException e){
            throw new NoContentException(null, null);
        }

    }

    public DndCharacter addCharacterToCampaign(Long dndCharacterId, Long campaignId){
        Optional<DndCharacter> dndCharacter = dndCharacterRepository.findById(dndCharacterId);

        if (dndCharacter.isEmpty()){
            throw new NoContentException(null, null);
        }

        Optional<Campaign> campaign = campaignRepository.findById(campaignId);

        if(campaign.isEmpty()){
            throw new NoContentException(null, null);
        }

        DndCharacter updatedDndCharacter = dndCharacter.get();
        updatedDndCharacter.setCampaign(campaign.get());
        dndCharacterRepository.save(updatedDndCharacter);

        return updatedDndCharacter;
    }
}
