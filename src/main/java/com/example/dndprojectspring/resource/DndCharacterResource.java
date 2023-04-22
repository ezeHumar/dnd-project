package com.example.dndprojectspring.resource;

import com.example.dndprojectspring.entity.DndCharacter;
import com.example.dndprojectspring.service.DndCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/characters",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class DndCharacterResource {

    private DndCharacterService service;

    @Autowired
    public DndCharacterResource(DndCharacterService service) {
        this.service = service;
    }

    @GetMapping
    public List<DndCharacter> getDndCharacters(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DndCharacter getDndCharacterById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping
    public DndCharacter addDndCharacter(DndCharacter dndCharacter){
        return service.add(dndCharacter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeDndCharacter(@PathVariable("id") Long id){
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{dndCharacterId}/campaign/{campaignId}")
    public ResponseEntity addDndCharacterToCampaign(@PathVariable("dndCharacterId") Long dndCharacterId,
                                              @PathVariable("campaignId") Long campaignId){
        DndCharacter updatedDndCharacter = service.addCharacterToCampaign(dndCharacterId, campaignId);

        return new ResponseEntity<>("Character added to the campaign", HttpStatus.OK);
    }
}
