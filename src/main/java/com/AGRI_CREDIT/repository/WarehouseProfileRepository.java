package com.AGRI_CREDIT.repository;

import com.AGRI_CREDIT.models.WarehouseProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseProfileRepository extends JpaRepository<WarehouseProfile, Long>{
}