package com.example.HealthCareApp.Mapper;

import com.example.HealthCareApp.DTO.Medcin.MedcinGetDTO;
import com.example.HealthCareApp.DTO.Medcin.MedcinPostDTO;
import com.example.HealthCareApp.Entity.Medcin;

public class MedcinMapper {


    public static Medcin toEntity(MedcinPostDTO dto) {

        Medcin m = new Medcin();

        m.setNom(dto.getNom());
        m.setSpecialite(dto.getSpecialite());
        m.setEmail(dto.getEmail());
        m.setTelephone(dto.getTelephone());

        return m;
    }


    public static MedcinGetDTO toGetDTO(Medcin m) {

        MedcinGetDTO dto = new MedcinGetDTO();

        dto.setId(m.getId());
        dto.setNom(m.getNom());
        dto.setSpecialite(m.getSpecialite());
        dto.setEmail(m.getEmail());
        dto.setTelephone(m.getTelephone());

        return dto;
    }
}
