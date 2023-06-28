package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.WarehouseProfile;
import com.AGRI_CREDIT.repository.WarehouseProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class WarehouseProfileServiceImpl implements WarehouseProfileService {

    @Autowired
    private WarehouseProfileRepository warehouseprofileRepository;

    // Create Operation
    @Override
    public WarehouseProfile saveWarehouseProfile(WarehouseProfile warehouseprofile) {
        return warehouseprofileRepository.save(warehouseprofile);
    }

    // Read Operation
    @Override
    public List<WarehouseProfile> fetchWarehouseProfile() {
        return (List<WarehouseProfile>) warehouseprofileRepository.findAll();
    }

    // Update Operation
    @Override
    public WarehouseProfile updateWarehouseProfile(WarehouseProfile warehouseprofile, Long warehouseprofileId) {
        WarehouseProfile warehouseprofileDB = warehouseprofileRepository.findById(warehouseprofileId).get();

        if (Objects.nonNull(warehouseprofile.getOrganisation())
                && !"".equalsIgnoreCase(
                warehouseprofile.getOrganisation())) {
            warehouseprofileDB.setOrganisation(
                    warehouseprofile.getOrganisation());
        }
        // Some error may occur due to type of Date(String)
        if (Objects.nonNull(warehouseprofile.getName())
                && !"".equalsIgnoreCase(
                warehouseprofile.getName())) {
            warehouseprofileDB.setName(
                    warehouseprofile.getName());
        }

        if (Objects.nonNull(warehouseprofile.getAddress())
                && !"".equalsIgnoreCase(
                warehouseprofile.getAddress())) {
            warehouseprofileDB.setAddress(
                    warehouseprofile.getAddress());
        }

        if (Objects.nonNull(warehouseprofile.getTinNumber())
                && !"".equalsIgnoreCase(
                warehouseprofile.getTinNumber())) {
            warehouseprofileDB.setTinNumber(
                    warehouseprofile.getTinNumber());
        }

        if (Objects.nonNull(warehouseprofile.getGstinNumber())
                && !"".equalsIgnoreCase(
                warehouseprofile.getGstinNumber())) {
            warehouseprofileDB.setGstinNumber(
                    warehouseprofile.getGstinNumber());

        }

        return warehouseprofileRepository.save(warehouseprofileDB);
    }

    // Delete Operation
    @Override
    public void deleteWarehouseProfileById(Long warehouseprofileId) {
        warehouseprofileRepository.deleteById(warehouseprofileId);
    }
}
