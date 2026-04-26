package com.example.HealthCareApp.Mapper;

import com.example.HealthCareApp.DTO.Patient.PatientGetDTO;
import com.example.HealthCareApp.DTO.Patient.PatientPostDTO;
import com.example.HealthCareApp.Entity.Patient;


public class PatientMapper {


    public static Patient toEntity(PatientPostDTO dto) {

        Patient p = new Patient();

        p.setNom(dto.getNom());
        p.setPrenom(dto.getPrenom());
        p.setEmail(dto.getEmail());
        p.setTelephone(dto.getTelephone());
        p.setDateNaissance(dto.getDateNaissance());

        return p;
    }


    public static PatientGetDTO toGetDTO(Patient p) {

        PatientGetDTO dto = new PatientGetDTO();

        dto.setId(p.getId());
        dto.setNom(p.getNom());
        dto.setPrenom(p.getPrenom());
        dto.setEmail(p.getEmail());
        dto.setTelephone(p.getTelephone());
        dto.setDateNaissance(p.getDateNaissance());

        return dto;
    }


}