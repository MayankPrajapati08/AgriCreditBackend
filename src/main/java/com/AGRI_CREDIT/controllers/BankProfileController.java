package com.AGRI_CREDIT.controllers;
import com.AGRI_CREDIT.models.BankProfile;
import com.AGRI_CREDIT.security.services.BankProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BankProfileController {

    @Autowired
    private BankProfileService bankProfileService;

    // Create Operation
    @PostMapping("/bank")
    public BankProfile saveBankProfile(
            @Valid @RequestBody BankProfile bankprofile) {
        return bankProfileService.saveBankProfile(bankprofile);
    }

    // Read Operation
    @GetMapping("/bank")
    public List<BankProfile> fetchBankProfile(){
        return bankProfileService.fetchBankProfile();
    }

    // Update Operation
    @PutMapping("bank/{id}")
    public BankProfile updateBankProfile(@RequestBody BankProfile bankprofile,
                                             @PathVariable("id") Long bankprofileId) {
        return bankProfileService.updateBankProfile(bankprofile,bankprofileId);
    }

    // Delete Operation
    @DeleteMapping("/bank/{id}")
    public String deleteBankProfileById(@PathVariable("id") Long bankprofileId) {
        bankProfileService.deleteBankProfileById(bankprofileId);
        return "The BankProfile id Deleted Successfully";
    }
}
