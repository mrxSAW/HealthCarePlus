package com.example.HealthCareApp.Service;


import com.example.HealthCareApp.DTO.DossierMedical.DossierMedicalGetDTO;
import com.example.HealthCareApp.DTO.DossierMedical.DossierMedicalPostDTO;
import com.example.HealthCareApp.DTO.DossierMedical.DossierMedicalUpdateDTO;
import com.example.HealthCareApp.Entity.DossierMedical;
import com.example.HealthCareApp.Entity.Patient;
import com.example.HealthCareApp.Mapper.DossierMedicalMapper;
import com.example.HealthCareApp.Repository.DossierMedicalRepository;
import com.example.HealthCareApp.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class DossierMedicalService {

    private final DossierMedicalRepository repo;
    private final PatientRepository patientRepo;
    private final DossierMedicalMapper mapper;





    public DossierMedicalGetDTO save(DossierMedicalPostDTO dto) {
        DossierMedical dossier = mapper.toEntity(dto);

        Patient patient = patientRepo.findById(dto.getPatientId()).orElse(null);
        dossier.setPatient(patient);

        DossierMedical saved = repo.save(dossier);
        return mapper.toGetDTO(saved);
    }

    public List<DossierMedicalGetDTO> getAll() {
        List<DossierMedical> dossiers = repo.findAll();
        List<DossierMedicalGetDTO> result = new ArrayList<>();

        for (DossierMedical dossier : dossiers) {
            DossierMedicalGetDTO dto = mapper.toGetDTO(dossier);
            result.add(dto);
        }

        return result;
    }

    public DossierMedicalGetDTO getById(int id) {
        DossierMedical dossier = repo.findById(id).orElse(null);

        if (dossier == null) {
            return null;
        }

        return mapper.toGetDTO(dossier);
    }

    public DossierMedicalGetDTO update(int id, DossierMedicalUpdateDTO dto) {
        DossierMedical dossier = repo.findById(id).orElse(null);

        if (dossier == null) {
            return null;
        }

        mapper.updateDossierMedicalFromDTO(dto, dossier);

        DossierMedical updated = repo.save(dossier);
        return mapper.toGetDTO(updated);
    }

    public void delete(int id) {
        DossierMedical dossier = repo.findById(id).orElse(null);

        if (dossier != null) {
            Patient patient = dossier.getPatient();

            if (patient != null) {
                patient.setDossierMedical(null);
                dossier.setPatient(null);
            }

            repo.delete(dossier);
            repo.flush();
        }
    }
}