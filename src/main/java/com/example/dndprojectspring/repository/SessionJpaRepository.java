package com.example.dndprojectspring.repository;

import com.example.dndprojectspring.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionJpaRepository extends JpaRepository<Session, Long> {
}
