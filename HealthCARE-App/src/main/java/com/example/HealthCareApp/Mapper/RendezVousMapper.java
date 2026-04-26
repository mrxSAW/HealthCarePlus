package com.example.HealthCareApp.Mapper;

import com.example.HealthCareApp.DTO.RendezVous.RendezVousGetDTO;
import com.example.HealthCareApp.Entity.RendezVous;

public class RendezVousMapper {

    public static RendezVousGetDTO toGetDTO(RendezVous r) {

        RendezVousGetDTO dto = new RendezVousGetDTO();

        dto.setId(r.getId());
        dto.setDateRendezVous(r.getDateRendezVous());
        dto.setStatut(r.getStatut());

        if (r.getPatient() != null) {
            dto.setPatientNom(r.getPatient().getNom());
        }

        if (r.getMedcin() != null) {
            dto.setMedcinNom(r.getMedcin().getNom());
        }

        return dto;
    }

}
