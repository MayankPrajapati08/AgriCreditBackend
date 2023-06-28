package com.AGRI_CREDIT.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

// Annotation
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Class
@Table(name = "FarmerProfile")
public class FarmerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Name;
    private String Age;
    private String Address;
    private String PhoneNumber;
    private String BankDetails;
    private String KYC;
    private String PlotNumber;
    private String Village;
    private String RI;
    private String Tehsil;
    private String Block;
    private String District;
}

