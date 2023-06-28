package com.AGRI_CREDIT.repository;

import com.AGRI_CREDIT.models.BCAgentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BCAgentProfileRepository extends JpaRepository<BCAgentProfile, Long>{
}