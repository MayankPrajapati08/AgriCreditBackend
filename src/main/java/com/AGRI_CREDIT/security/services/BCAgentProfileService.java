package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.BCAgentProfile;

import java.util.List;
public interface BCAgentProfileService {
    // Create Operation
    BCAgentProfile saveBCAgentProfile(BCAgentProfile bcagent);

    // Read Operation
    List<BCAgentProfile> fetchBCAgentProfile();

    // Update Operation
    BCAgentProfile updateBCAgentProfile(BCAgentProfile bcagent, Long bcagentId);

    // Delete operation
    void deleteBCAgentProfileById (Long bcagentId);
}
