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
@Table(name = "BankProfile")
public class BankProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String BankName;
    private String Branch;
    private String IfscCode;
    private String District;
    private String State;
}

