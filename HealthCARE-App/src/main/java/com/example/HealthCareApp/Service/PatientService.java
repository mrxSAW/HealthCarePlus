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
    private final PatientMapper mapper;

    public PatientService(PatientRepository repo, PatientMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public PatientGetDTO save(PatientPostDTO dto) {
        Patient patient = mapper.toEntity(dto);
        Patient savedPatient = repo.save(patient);
        PatientGetDTO result = mapper.toGetDTO(savedPatient);

        return result;
    }

    public List<PatientGetDTO> getAll() {
        List<Patient> patients = repo.findAll();
        List<PatientGetDTO> result = new ArrayList<>();

        for (Patient patient : patients) {
            PatientGetDTO dto = mapper.toGetDTO(patient);
            result.add(dto);
        }

        return result;
    }

    public PatientGetDTO getById(int id) {
        Patient patient = repo.findById(id).orElse(null);

        if (patient == null) {
            return null;
        }

        PatientGetDTO result = mapper.toGetDTO(patient);
        return result;
    }

    public PatientGetDTO update(int id, PatientUpdateDTO dto) {
        Patient patient = repo.findById(id).orElse(null);

        if (patient == null) {
            return null;
        }

        mapper.updatePatientFromDTO(dto, patient);

        Patient updatedPatient = repo.save(patient);
        PatientGetDTO result = mapper.toGetDTO(updatedPatient);

        return result;
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}