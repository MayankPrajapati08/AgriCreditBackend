package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.FarmerProfile;

import java.util.List;
public interface FarmerProfileService {
    // Create Operation
    FarmerProfile saveFarmerProfile(FarmerProfile farmer);

    // Read Operation
    List<FarmerProfile> fetchFarmerProfile();

    // Update Operation
    FarmerProfile updateFarmerProfile(FarmerProfile farmer, Long farmerId);

    // Delete operation
    void deleteFarmerProfileById (Long farmerId);
}
