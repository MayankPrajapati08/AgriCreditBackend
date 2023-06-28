package com.AGRI_CREDIT.repository;

import com.AGRI_CREDIT.models.BankProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankProfileRepository extends JpaRepository<BankProfile, Long>{
}