package com.AGRI_CREDIT.repository;

import com.AGRI_CREDIT.models.FarmerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerProfileRepository extends JpaRepository<FarmerProfile, Long>{
}