package com.example.dndprojectspring.repository;

import com.example.dndprojectspring.entity.DndCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DndCharacterJpaRepository extends JpaRepository<DndCharacter, Long> {
}
