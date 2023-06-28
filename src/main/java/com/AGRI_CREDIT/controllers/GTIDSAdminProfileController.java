package com.AGRI_CREDIT.controllers;
import com.AGRI_CREDIT.models.GTIDSAdminProfile;
import com.AGRI_CREDIT.security.services.GTIDSAdminProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GTIDSAdminProfileController {

    @Autowired
    private GTIDSAdminProfileService gtidsAdminProfileService;

    // Create Operation
    @PostMapping("/gtidsadmin")
    public GTIDSAdminProfile saveGTIDSAdminProfile(
            @Valid @RequestBody GTIDSAdminProfile gtidsadminprofile) {
        return gtidsAdminProfileService.saveGTIDSAdminProfile(gtidsadminprofile);
    }

    // Read Operation
    @GetMapping("/gtidsadmin")
    public List<GTIDSAdminProfile> fetchGTIDSAdminProfile(){
        return gtidsAdminProfileService.fetchGTIDSAdminProfile();
    }

    // Update Operation
    @PutMapping("gtidsadmin/{id}")
    public GTIDSAdminProfile updateGTIDSAdminProfile(@RequestBody GTIDSAdminProfile gtidsadminprofile,
                             @PathVariable("id") Long gtidsadminprofileId) {
        return gtidsAdminProfileService.updateGTIDSAdminProfile(gtidsadminprofile,gtidsadminprofileId);
    }

    // Delete Operation
    @DeleteMapping("/gtidsadmin/{id}")
    public String deleteGTIDSAdminProfileById(@PathVariable("id") Long gtidsadminprofileId) {
        gtidsAdminProfileService.deleteGTIDSAdminProfileById(gtidsadminprofileId);
        return "The GTIDSAdminProfile id Deleted Successfully";
    }
}
