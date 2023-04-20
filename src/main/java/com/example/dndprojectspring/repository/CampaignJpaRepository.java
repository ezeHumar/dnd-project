package com.example.dndprojectspring.repository;

import com.example.dndprojectspring.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignJpaRepository extends JpaRepository<Campaign, Long> {
}
