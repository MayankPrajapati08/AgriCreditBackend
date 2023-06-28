package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.WarehouseProfile;

import java.util.List;
public interface WarehouseProfileService {
    // Create Operation
    WarehouseProfile saveWarehouseProfile(WarehouseProfile warehouse);

    // Read Operation
    List<WarehouseProfile> fetchWarehouseProfile();

    // Update Operation
    WarehouseProfile updateWarehouseProfile(WarehouseProfile warehouse, Long warehouseId);

    // Delete operation
    void deleteWarehouseProfileById (Long warehouseId);
}
