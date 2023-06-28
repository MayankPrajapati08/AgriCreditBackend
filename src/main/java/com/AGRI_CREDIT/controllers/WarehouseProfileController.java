package com.AGRI_CREDIT.controllers;
import com.AGRI_CREDIT.models.WarehouseProfile;
import com.AGRI_CREDIT.security.services.WarehouseProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseProfileController {

    @Autowired
    private WarehouseProfileService warehouseProfileService;

    // Create Operation
    @PostMapping("/warehouse")
    public WarehouseProfile saveWarehouseProfile(
            @Valid @RequestBody WarehouseProfile warehouseprofile) {
        return warehouseProfileService.saveWarehouseProfile(warehouseprofile);
    }

    // Read Operation
    @GetMapping("/warehouse")
    public List<WarehouseProfile> fetchWarehouseProfile(){
        return warehouseProfileService.fetchWarehouseProfile();
    }

    // Update Operation
    @PutMapping("warehouse/{id}")
    public WarehouseProfile updateWarehouseProfile(@RequestBody WarehouseProfile warehouseprofile,
                                             @PathVariable("id") Long warehouseprofileId) {
        return warehouseProfileService.updateWarehouseProfile(warehouseprofile,warehouseprofileId);
    }

    // Delete Operation
    @DeleteMapping("/warehouse/{id}")
    public String deleteWarehouseProfileById(@PathVariable("id") Long warehouseprofileId) {
        warehouseProfileService.deleteWarehouseProfileById(warehouseprofileId);
        return "The WarehouseProfile id Deleted Successfully";
    }
}
