package com.AGRI_CREDIT.repository;

import com.AGRI_CREDIT.models.ERole;
import com.AGRI_CREDIT.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
