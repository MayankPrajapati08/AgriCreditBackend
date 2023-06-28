package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.FarmerProfile;
import com.AGRI_CREDIT.repository.FarmerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class FarmerProfileServiceImpl implements FarmerProfileService {

    @Autowired
    private FarmerProfileRepository farmerprofileRepository;

    // Create Operation
    @Override
    public FarmerProfile saveFarmerProfile(FarmerProfile farmerprofile) {
        return farmerprofileRepository.save(farmerprofile);
    }

    // Read Operation
    @Override
    public List<FarmerProfile> fetchFarmerProfile() {
        return (List<FarmerProfile>) farmerprofileRepository.findAll();
    }

    // Update Operation
    @Override
    public FarmerProfile updateFarmerProfile(FarmerProfile farmerprofile, Long farmerprofileId) {
        FarmerProfile farmerprofileDB = farmerprofileRepository.findById(farmerprofileId).get();

        if (Objects.nonNull(farmerprofile.getName())
                && !"".equalsIgnoreCase(
                farmerprofile.getName())) {
            farmerprofileDB.setName(
                    farmerprofile.getName());
        }
        // Some error may occur due to type of age(String)
        if (Objects.nonNull(farmerprofile.getAge())
                && !"".equals(
                farmerprofile.getAge())) {
            farmerprofileDB.setAge(
                    farmerprofile.getAge());
        }

        if (Objects.nonNull(farmerprofile.getAddress())
                && !"".equalsIgnoreCase(
                farmerprofile.getAddress())) {
            farmerprofileDB.setAddress(
                    farmerprofile.getAddress());
        }

        if (Objects.nonNull(farmerprofile.getPhoneNumber())
                && !"".equals(
                farmerprofile.getPhoneNumber())) {
            farmerprofileDB.setPhoneNumber(
                    farmerprofile.getPhoneNumber());
        }

        if (Objects.nonNull(farmerprofile.getBankDetails())
                && !"".equalsIgnoreCase(
                farmerprofile.getBankDetails())) {
            farmerprofileDB.setBankDetails(
                    farmerprofile.getBankDetails());

        }

        if (Objects.nonNull(farmerprofile.getKYC())
                && !"".equalsIgnoreCase(
                farmerprofile.getKYC())) {
            farmerprofileDB.setKYC(
                    farmerprofile.getKYC());

        }

        if (Objects.nonNull(farmerprofile.getPlotNumber())
                && !"".equalsIgnoreCase(
                farmerprofile.getPlotNumber())) {
            farmerprofileDB.setPlotNumber(
                    farmerprofile.getPlotNumber());
        }

        if (Objects.nonNull(farmerprofile.getVillage())
                && !"".equalsIgnoreCase(
                farmerprofile.getVillage())) {
            farmerprofileDB.setVillage(
                    farmerprofile.getVillage());
        }

        if (Objects.nonNull(farmerprofile.getRI())
                && !"".equalsIgnoreCase(
                farmerprofile.getRI())) {
            farmerprofileDB.setRI(
                    farmerprofile.getRI());
        }

        if (Objects.nonNull(farmerprofile.getTehsil())
                && !"".equalsIgnoreCase(
                farmerprofile.getTehsil())) {
            farmerprofileDB.setTehsil(
                    farmerprofile.getTehsil());
        }

        if (Objects.nonNull(farmerprofile.getBlock())
                && !"".equalsIgnoreCase(
                farmerprofile.getBlock())) {
            farmerprofileDB.setBlock(
                    farmerprofile.getBlock());
        }

        if (Objects.nonNull(farmerprofile.getDistrict())
                && !"".equalsIgnoreCase(
                farmerprofile.getDistrict())) {
            farmerprofileDB.setDistrict(
                    farmerprofile.getDistrict());
        }

        return farmerprofileRepository.save(farmerprofileDB);
    }

    // Delete Operation
    @Override
    public void deleteFarmerProfileById(Long farmerprofileId) {
        farmerprofileRepository.deleteById(farmerprofileId);
    }
}
