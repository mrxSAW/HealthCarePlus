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
public class DossierMedicalService {

    private final DossierMedicalRepository repo;
    private final PatientRepository patientRepo;

    public DossierMedicalService(DossierMedicalRepository repo, PatientRepository patientRepo) {
        this.repo = repo;
        this.patientRepo = patientRepo;
    }


    public DossierMedicalGetDTO save(DossierMedicalPostDTO dto) {

        DossierMedical d = new DossierMedical();

        d.setDiagnostic(dto.getDiagnostic());
        d.setObservation(dto.getObservation());
        d.setDateCreation(dto.getDateCreation());

        Patient p = patientRepo.findById(dto.getPatientId()).orElse(null);

        d.setPatient(p);
        if (p != null) {
            p.setDossierMedical(d);
        }

        DossierMedical saved = repo.save(d);

        return DossierMedicalMapper.toGetDTO(saved);
    }


    public List<DossierMedicalGetDTO> getAll() {

        List<DossierMedical> list = repo.findAll();
        List<DossierMedicalGetDTO> result = new ArrayList<>();

        for (DossierMedical d : list) {
            result.add(DossierMedicalMapper.toGetDTO(d));
        }

        return result;
    }


    public DossierMedicalGetDTO getById(int id) {

        DossierMedical d = repo.findById(id).orElse(null);

        if (d == null) return null;

        return DossierMedicalMapper.toGetDTO(d);
    }


    public DossierMedicalGetDTO update(int id, DossierMedicalUpdateDTO dto) {

        DossierMedical d = repo.findById(id).orElse(null);

        if (d == null) return null;

        d.setDiagnostic(dto.getDiagnostic());
        d.setObservation(dto.getObservation());

        DossierMedical updated = repo.save(d);

        return DossierMedicalMapper.toGetDTO(updated);
    }


    @Transactional
    public void delete(int id) {

        DossierMedical d = repo.findById(id).orElse(null);

        if (d == null) {
            return;
        }

        Patient p = d.getPatient();

        if (p != null) {
            p.setDossierMedical(null);
        }

        repo.delete(d);
    }
}
