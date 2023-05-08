package com.example.dndprojectspring.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CampaignDto extends ObjectDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("dungeon-master-id")
    private Long dungeonMasterId;

    @JsonProperty("user-ids")
    private List<Long> UserIds;
}
