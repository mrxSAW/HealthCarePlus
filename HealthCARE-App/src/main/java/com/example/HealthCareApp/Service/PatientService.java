package com.example.HealthCareApp.Service;


import com.example.HealthCareApp.DTO.Patient.PatientGetDTO;
import com.example.HealthCareApp.DTO.Patient.PatientPostDTO;
import com.example.HealthCareApp.DTO.Patient.PatientUpdateDTO;
import com.example.HealthCareApp.Entity.Patient;
import com.example.HealthCareApp.Mapper.PatientMapper;
import com.example.HealthCareApp.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }


    public PatientGetDTO save(PatientPostDTO dto) {

        Patient p = PatientMapper.toEntity(dto);
        Patient saved = repo.save(p);

        return PatientMapper.toGetDTO(saved);
    }


    public List<PatientGetDTO> getAll() {

        List<Patient> patients = repo.findAll();
        List<PatientGetDTO> list = new ArrayList<>();

        for (Patient p : patients) {
            list.add(PatientMapper.toGetDTO(p));
        }

        return list;
    }


    public PatientGetDTO getById(int id) {

        Patient p = repo.findById(id).orElse(null);

        if (p == null) return null;

        return PatientMapper.toGetDTO(p);
    }


    public PatientGetDTO update(int id, PatientUpdateDTO dto) {

        Patient p = repo.findById(id).orElse(null);

        if (p == null) return null;

        p.setNom(dto.getNom());
        p.setPrenom(dto.getPrenom());
        p.setEmail(dto.getEmail());
        p.setTelephone(dto.getTelephone());
        p.setDateNaissance(dto.getDateNaissance());

        Patient updated = repo.save(p);

        return PatientMapper.toGetDTO(updated);
    }


    public void delete(int id) {

        repo.deleteById(id);
    }
}