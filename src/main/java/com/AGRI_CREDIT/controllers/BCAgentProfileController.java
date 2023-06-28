package com.AGRI_CREDIT.controllers;
import com.AGRI_CREDIT.models.BCAgentProfile;
import com.AGRI_CREDIT.security.services.BCAgentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BCAgentProfileController {

    @Autowired
    private BCAgentProfileService bcagentProfileService;

    // Create Operation
    @PostMapping("/bcagent")
    public BCAgentProfile saveBCAgentProfile(
            @Valid @RequestBody BCAgentProfile bcagentprofile) {
        return bcagentProfileService.saveBCAgentProfile(bcagentprofile);
    }

    // Read Operation
    @GetMapping("/bcagent")
    public List<BCAgentProfile> fetchBCAgentProfile(){
        return bcagentProfileService.fetchBCAgentProfile();
    }

    // Update Operation
    @PutMapping("bcagent/{id}")
    public BCAgentProfile updateBCAgentProfile(@RequestBody BCAgentProfile bcagentprofile,
                                                     @PathVariable("id") Long bcagentprofileId) {
        return bcagentProfileService.updateBCAgentProfile(bcagentprofile,bcagentprofileId);
    }

    // Delete Operation
    @DeleteMapping("/bcagent/{id}")
    public String deleteBCAgentProfileById(@PathVariable("id") Long bcagentprofileId) {
        bcagentProfileService.deleteBCAgentProfileById(bcagentprofileId);
        return "The BCAgentProfile id Deleted Successfully";
    }
}
