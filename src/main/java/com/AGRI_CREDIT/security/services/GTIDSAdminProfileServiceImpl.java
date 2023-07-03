package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.GTIDSAdminProfile;
import com.AGRI_CREDIT.repository.GTIDSAdminProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class GTIDSAdminProfileServiceImpl implements GTIDSAdminProfileService {

    @Autowired
    private GTIDSAdminProfileRepository gtidsadminprofileRepository;

    // Create Operation
    @Override
    public GTIDSAdminProfile saveGTIDSAdminProfile(GTIDSAdminProfile gtidsadminprofile) {
        return gtidsadminprofileRepository.save(gtidsadminprofile);
    }

    // Read Operation
    @Override
    public List<GTIDSAdminProfile> fetchGTIDSAdminProfile() {
        return (List<GTIDSAdminProfile>) gtidsadminprofileRepository.findAll();
    }

    // Update Operation
    @Override
    public GTIDSAdminProfile updateGTIDSAdminProfile(GTIDSAdminProfile gtidsadminprofile, Long gtidsadminprofileId) {
        GTIDSAdminProfile gtidsadminprofileDB = gtidsadminprofileRepository.findById(gtidsadminprofileId).get();

        if (Objects.nonNull(gtidsadminprofile.getName())
                && !"".equalsIgnoreCase(
                gtidsadminprofile.getName())) {
            gtidsadminprofileDB.setName(
                    gtidsadminprofile.getName());

        }
        // Some error may occur due to type of age(String)
        if (Objects.nonNull(gtidsadminprofile.getAge())
                && !"".equals(
                gtidsadminprofile.getAge())) {
            gtidsadminprofileDB.setAge(
                    gtidsadminprofile.getAge());
        }

        if (Objects.nonNull(gtidsadminprofile.getPhoneNumber())
                && !"".equals(
                gtidsadminprofile.getPhoneNumber())) {
            gtidsadminprofileDB.setPhoneNumber(
                    gtidsadminprofile.getPhoneNumber());
        }

        if (Objects.nonNull(gtidsadminprofile.getBankDetails())
                && !"".equalsIgnoreCase(
                gtidsadminprofile.getBankDetails())) {
            gtidsadminprofileDB.setBankDetails(
                    gtidsadminprofile.getBankDetails());

        }

        if (Objects.nonNull(gtidsadminprofile.getAddress())
                && !"".equalsIgnoreCase(
                gtidsadminprofile.getAddress())) {
            gtidsadminprofileDB.setAddress(
                    gtidsadminprofile.getAddress());

        }
        
        if (Objects.nonNull(gtidsadminprofile.getKYC())
                && !"".equalsIgnoreCase(
                gtidsadminprofile.getKYC())) {
            gtidsadminprofileDB.setKYC(
                    gtidsadminprofile.getKYC());

        }

        return gtidsadminprofileRepository.save(gtidsadminprofileDB);
    }

    // Delete Operation
    @Override
    public void deleteGTIDSAdminProfileById(Long gtidsadminprofileId) {
        gtidsadminprofileRepository.deleteById(gtidsadminprofileId);
    }
}
