package com.AGRI_CREDIT.controllers;
import com.AGRI_CREDIT.models.FarmerProfile;
import com.AGRI_CREDIT.security.services.FarmerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FarmerProfileController {

    @Autowired
    private FarmerProfileService farmerProfileService;

    // Create Operation
    @PostMapping("/farmer")
    public FarmerProfile saveFarmerProfile(
            @Valid @RequestBody FarmerProfile farmerprofile) {
        return farmerProfileService.saveFarmerProfile(farmerprofile);
    }

    // Read Operation
    @GetMapping("/farmer")
    public List<FarmerProfile> fetchFarmerProfile(){
        return farmerProfileService.fetchFarmerProfile();
    }

    // Update Operation
    @PutMapping("farmer/{id}")
    public FarmerProfile updateFarmerProfile(@RequestBody FarmerProfile farmerprofile,
                                               @PathVariable("id") Long farmerprofileId) {
        return farmerProfileService.updateFarmerProfile(farmerprofile,farmerprofileId);
    }

    // Delete Operation
    @DeleteMapping("/farmer/{id}")
    public String deleteFarmerProfileById(@PathVariable("id") Long farmerprofileId) {
        farmerProfileService.deleteFarmerProfileById(farmerprofileId);
        return "The FarmerProfile id Deleted Successfully";
    }
}
