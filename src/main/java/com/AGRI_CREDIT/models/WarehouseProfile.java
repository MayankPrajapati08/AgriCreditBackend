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
@Table(name = "WarehouseProfile")
public class WarehouseProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Organisation;
    private String Name;
    private String Address;
    private String TinNumber;
    private String GstinNumber;
}

