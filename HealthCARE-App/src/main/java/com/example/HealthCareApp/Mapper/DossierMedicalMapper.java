package com.example.HealthCareApp.Mapper;

import com.example.HealthCareApp.DTO.DossierMedical.DossierMedicalGetDTO;
import com.example.HealthCareApp.Entity.DossierMedical;

public class DossierMedicalMapper {

    public static DossierMedicalGetDTO toGetDTO(DossierMedical d) {

        DossierMedicalGetDTO dto = new DossierMedicalGetDTO();

        dto.setId(d.getId());
        dto.setDiagnostic(d.getDiagnostic());
        dto.setObservation(d.getObservation());
        dto.setDateCreation(d.getDateCreation());

        if (d.getPatient() != null) {
            dto.setPatientNom(d.getPatient().getNom());
            dto.setPatientPrenom(d.getPatient().getPrenom());
        }

        return dto;
    }
}
