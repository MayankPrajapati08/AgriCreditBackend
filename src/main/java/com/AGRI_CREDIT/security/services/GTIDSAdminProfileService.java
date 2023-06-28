package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.GTIDSAdminProfile;

import java.util.List;
public interface GTIDSAdminProfileService {
    // Create Operation
    GTIDSAdminProfile saveGTIDSAdminProfile(GTIDSAdminProfile gtidsadminprofile);

    // Read Operation
    List<GTIDSAdminProfile> fetchGTIDSAdminProfile();

    // Update Operation
    GTIDSAdminProfile updateGTIDSAdminProfile(GTIDSAdminProfile gtidsadminprofile, Long gtidsadminprofileId);

    // Delete operation
    void deleteGTIDSAdminProfileById (Long gtidsadminprofileId);
}
