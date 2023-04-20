package com.example.dndprojectspring.repository;

import com.example.dndprojectspring.entity.DungeonMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DungeonMasterJpaRepository extends JpaRepository<DungeonMaster, Long> {
}
