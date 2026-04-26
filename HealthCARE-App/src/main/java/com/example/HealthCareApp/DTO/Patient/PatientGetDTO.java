package com.example.HealthCareApp.DTO.Patient;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientGetDTO {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateNaissance;
}
