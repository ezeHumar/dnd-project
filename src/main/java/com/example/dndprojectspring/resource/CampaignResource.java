package com.example.dndprojectspring.resource;

import com.example.dndprojectspring.entity.Campaign;
import com.example.dndprojectspring.exception.ValidationException;
import com.example.dndprojectspring.service.CampaignService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/campaigns",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class CampaignResource {

    CampaignService campaignService;

    @Autowired
    public CampaignResource(CampaignService campaignService){
        this.campaignService = campaignService;
    }

    public CampaignResource() {
    }

    @PostMapping
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        try {
            //TODO: Get user email from authentication
            String userEmail = campaign.getUsers().get(0).getEmail();
            return campaignService.add(campaign, userEmail);
        }
        catch(ConstraintViolationException e){
            throw new ValidationException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getUserCampaigns(){
        return new ResponseEntity<>(campaignService.listUserCampaigns(), HttpStatus.OK);
    }
}
