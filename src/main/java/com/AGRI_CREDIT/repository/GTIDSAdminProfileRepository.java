package com.AGRI_CREDIT.repository;

import com.AGRI_CREDIT.models.GTIDSAdminProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GTIDSAdminProfileRepository extends JpaRepository<GTIDSAdminProfile, Long>{
}
