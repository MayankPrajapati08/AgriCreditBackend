package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.BCAgentProfile;
import com.AGRI_CREDIT.repository.BCAgentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class BCAgentProfileServiceImpl implements BCAgentProfileService {

    @Autowired
    private BCAgentProfileRepository bcagentprofileRepository;

    // Create Operation
    @Override
    public BCAgentProfile saveBCAgentProfile(BCAgentProfile bcagentprofile) {
        return bcagentprofileRepository.save(bcagentprofile);
    }

    // Read Operation
    @Override
    public List<BCAgentProfile> fetchBCAgentProfile() {
        return (List<BCAgentProfile>) bcagentprofileRepository.findAll();
    }

    // Update Operation
    @Override
    public BCAgentProfile updateBCAgentProfile(BCAgentProfile bcagentprofile, Long bcagentprofileId) {
        BCAgentProfile bcagentprofileDB = bcagentprofileRepository.findById(bcagentprofileId).get();

        if (Objects.nonNull(bcagentprofile.getName())
                && !"".equalsIgnoreCase(
                bcagentprofile.getName())) {
            bcagentprofileDB.setName(
                    bcagentprofile.getName());
        }
        // Some error may occur due to type of Date(String)
        if (Objects.nonNull(bcagentprofile.getAge())
                && !"".equals(
                bcagentprofile.getAge())) {
            bcagentprofileDB.setAge(
                    bcagentprofile.getAge());
        }

        if (Objects.nonNull(bcagentprofile.getAddress())
                && !"".equalsIgnoreCase(
                bcagentprofile.getAddress())) {
            bcagentprofileDB.setAddress(
                    bcagentprofile.getAddress());
        }

        if (Objects.nonNull(bcagentprofile.getPhoneNumber())
                && !"".equals(
                bcagentprofile.getPhoneNumber())) {
            bcagentprofileDB.setPhoneNumber(
                    bcagentprofile.getPhoneNumber());
        }

        if (Objects.nonNull(bcagentprofile.getBankDetails())
                && !"".equalsIgnoreCase(
                bcagentprofile.getBankDetails())) {
            bcagentprofileDB.setBankDetails(
                    bcagentprofile.getBankDetails());

        }

        if (Objects.nonNull(bcagentprofile.getKYC())
                && !"".equalsIgnoreCase(
                bcagentprofile.getKYC())) {
            bcagentprofileDB.setKYC(
                    bcagentprofile.getKYC());

        }

        if (Objects.nonNull(bcagentprofile.getPlotNumber())
                && !"".equalsIgnoreCase(
                bcagentprofile.getPlotNumber())) {
            bcagentprofileDB.setPlotNumber(
                    bcagentprofile.getPlotNumber());
        }

        if (Objects.nonNull(bcagentprofile.getVillage())
                && !"".equalsIgnoreCase(
                bcagentprofile.getVillage())) {
            bcagentprofileDB.setVillage(
                    bcagentprofile.getVillage());
        }

        if (Objects.nonNull(bcagentprofile.getRI())
                && !"".equalsIgnoreCase(
                bcagentprofile.getRI())) {
            bcagentprofileDB.setRI(
                    bcagentprofile.getRI());
        }

        if (Objects.nonNull(bcagentprofile.getTehsil())
                && !"".equalsIgnoreCase(
                bcagentprofile.getTehsil())) {
            bcagentprofileDB.setTehsil(
                    bcagentprofile.getTehsil());
        }

        if (Objects.nonNull(bcagentprofile.getBlock())
                && !"".equalsIgnoreCase(
                bcagentprofile.getBlock())) {
            bcagentprofileDB.setBlock(
                    bcagentprofile.getBlock());
        }

        if (Objects.nonNull(bcagentprofile.getDistrict())
                && !"".equalsIgnoreCase(
                bcagentprofile.getDistrict())) {
            bcagentprofileDB.setDistrict(
                    bcagentprofile.getDistrict());
        }

        return bcagentprofileRepository.save(bcagentprofileDB);
    }

    // Delete Operation
    @Override
    public void deleteBCAgentProfileById(Long bcagentprofileId) {
        bcagentprofileRepository.deleteById(bcagentprofileId);
    }
}
