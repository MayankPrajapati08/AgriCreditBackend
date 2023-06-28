package com.AGRI_CREDIT.security.services;

import com.AGRI_CREDIT.models.BankProfile;
import com.AGRI_CREDIT.repository.BankProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class BankProfileServiceImpl implements BankProfileService {

    @Autowired
    private BankProfileRepository bankprofileRepository;

    // Create Operation
    @Override
    public BankProfile saveBankProfile(BankProfile bankprofile) {
        return bankprofileRepository.save(bankprofile);
    }

    // Read Operation
    @Override
    public List<BankProfile> fetchBankProfile() {
        return (List<BankProfile>) bankprofileRepository.findAll();
    }

    // Update Operation
    @Override
    public BankProfile updateBankProfile(BankProfile bankprofile, Long bankprofileId) {
        BankProfile bankprofileDB = bankprofileRepository.findById(bankprofileId).get();

        if (Objects.nonNull(bankprofile.getBankName())
                && !"".equalsIgnoreCase(
                bankprofile.getBankName())) {
            bankprofileDB.setBankName(
                    bankprofile.getBankName());
        }

        if (Objects.nonNull(bankprofile.getBranch())
                && !"".equals(
                bankprofile.getBranch())) {
            bankprofileDB.setBranch(
                    bankprofile.getBranch());
        }

        if (Objects.nonNull(bankprofile.getIfscCode())
                && !"".equalsIgnoreCase(
                bankprofile.getIfscCode())) {
            bankprofileDB.setIfscCode(
                    bankprofile.getIfscCode());
        }

        if (Objects.nonNull(bankprofile.getDistrict())
                && !"".equals(
                bankprofile.getDistrict())) {
            bankprofileDB.setDistrict(
                    bankprofile.getDistrict());
        }

        if (Objects.nonNull(bankprofile.getState())
                && !"".equalsIgnoreCase(
                bankprofile.getState())) {
            bankprofileDB.setState(
                    bankprofile.getState());

        }

        return bankprofileRepository.save(bankprofileDB);
    }

    // Delete Operation
    @Override
    public void deleteBankProfileById(Long bankprofileId) {
        bankprofileRepository.deleteById(bankprofileId);
    }
}
