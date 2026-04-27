package com.example.HealthCareApp.Service;

import com.example.HealthCareApp.DTO.RendezVous.RendezVousGetDTO;
import com.example.HealthCareApp.DTO.RendezVous.RendezVousPostDTO;
import com.example.HealthCareApp.DTO.RendezVous.RendezVousUpdateDTO;
import com.example.HealthCareApp.Entity.Medcin;
import com.example.HealthCareApp.Entity.Patient;
import com.example.HealthCareApp.Entity.RendezVous;
import com.example.HealthCareApp.Mapper.RendezVousMapper;
import com.example.HealthCareApp.Repository.MedcinRepository;
import com.example.HealthCareApp.Repository.PatientRepository;
import com.example.HealthCareApp.Repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RendezVousService {

    private final RendezVousRepository repo;
    private final PatientRepository patientRepo;
    private final MedcinRepository medcinRepo;
    private final RendezVousMapper mapper;

    public RendezVousService(RendezVousRepository repo,
                             PatientRepository patientRepo,
                             MedcinRepository medcinRepo,
                             RendezVousMapper mapper) {
        this.repo = repo;
        this.patientRepo = patientRepo;
        this.medcinRepo = medcinRepo;
        this.mapper = mapper;
    }

    public RendezVousGetDTO save(RendezVousPostDTO dto) {
        RendezVous rendezVous = mapper.toEntity(dto);

        Patient patient = patientRepo.findById(dto.getPatientId()).orElse(null);
        Medcin medcin = medcinRepo.findById(dto.getMedcinId()).orElse(null);

        rendezVous.setPatient(patient);
        rendezVous.setMedcin(medcin);

        RendezVous saved = repo.save(rendezVous);
        return mapper.toGetDTO(saved);
    }

    public List<RendezVousGetDTO> getAll() {
        List<RendezVous> list = repo.findAll();
        List<RendezVousGetDTO> result = new ArrayList<>();

        for (RendezVous rendezVous : list) {
            RendezVousGetDTO dto = mapper.toGetDTO(rendezVous);
            result.add(dto);
        }

        return result;
    }

    public RendezVousGetDTO update(int id, RendezVousUpdateDTO dto) {
        RendezVous rendezVous = repo.findById(id).orElse(null);

        if (rendezVous == null) {
            return null;
        }

        mapper.updateRendezVousFromDTO(dto, rendezVous);

        Patient patient = patientRepo.findById(dto.getPatientId()).orElse(null);
        Medcin medcin = medcinRepo.findById(dto.getMedcinId()).orElse(null);

        rendezVous.setPatient(patient);
        rendezVous.setMedcin(medcin);

        RendezVous updated = repo.save(rendezVous);
        return mapper.toGetDTO(updated);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<RendezVousGetDTO> findByPatient(int patientId) {
        List<RendezVous> list = repo.findByPatientId(patientId);
        List<RendezVousGetDTO> result = new ArrayList<>();

        for (RendezVous rendezVous : list) {
            RendezVousGetDTO dto = mapper.toGetDTO(rendezVous);
            result.add(dto);
        }

        return result;
    }

    public List<RendezVousGetDTO> findByMedcin(int medcinId) {
        List<RendezVous> list = repo.findByMedcinId(medcinId);
        List<RendezVousGetDTO> result = new ArrayList<>();

        for (RendezVous rendezVous : list) {
            RendezVousGetDTO dto = mapper.toGetDTO(rendezVous);
            result.add(dto);
        }

        return result;
    }
}
