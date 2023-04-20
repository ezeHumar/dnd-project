package com.example.dndprojectspring.repository;

import com.example.dndprojectspring.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteJpaRepository extends JpaRepository<Note, Long> {
}
