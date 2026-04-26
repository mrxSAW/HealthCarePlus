package com.example.HealthCareApp.DTO.RendezVous;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RendezVousGetDTO {

    private int id;

    private LocalDateTime dateRendezVous;
    private String statut;

    private String patientNom;
    private String medcinNom;
}
