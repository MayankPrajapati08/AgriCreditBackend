package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.BankProfile;

import java.util.List;
public interface BankProfileService {
    // Create Operation
    BankProfile saveBankProfile(BankProfile bank);

    // Read Operation
    List<BankProfile> fetchBankProfile();

    // Update Operation
    BankProfile updateBankProfile(BankProfile bank, Long bankId);

    // Delete operation
    void deleteBankProfileById (Long bankId);
}
