package com.example.HealthCareApp.DTO.DossierMedical;

import lombok.Data;
import java.time.LocalDate;


@Data
public class DossierMedicalGetDTO {

    private int id;
    private String diagnostic;
    private String observation;
    private LocalDate dateCreation;

    private String patientNom;
    private String patientPrenom;
}
