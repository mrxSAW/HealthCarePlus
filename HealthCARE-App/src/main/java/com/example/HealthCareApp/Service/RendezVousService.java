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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RendezVousService {

    private final RendezVousRepository repo;
    private final PatientRepository patientRepo;
    private final MedcinRepository medcinRepo;

    public RendezVousService(RendezVousRepository repo, PatientRepository patientRepo, MedcinRepository medcinRepo) {
        this.repo = repo;
        this.patientRepo = patientRepo;
        this.medcinRepo = medcinRepo;
    }


    public RendezVousGetDTO save(RendezVousPostDTO dto) {

        RendezVous r = new RendezVous();

        r.setDateRendezVous(dto.getDateRendezVous());
        r.setStatut(dto.getStatut());

        Patient p = patientRepo.findById(dto.getPatientId()).orElse(null);
        Medcin m = medcinRepo.findById(dto.getMedcinId()).orElse(null);

        r.setPatient(p);
        r.setMedcin(m);

        RendezVous saved = repo.save(r);

        return RendezVousMapper.toGetDTO(saved);
    }


    public List<RendezVousGetDTO> getAll() {

        List<RendezVous> list = repo.findAll();
        List<RendezVousGetDTO> result = new ArrayList<>();

        for (RendezVous r : list) {
            result.add(RendezVousMapper.toGetDTO(r));
        }

        return result;
    }


    public RendezVousGetDTO update(int id, RendezVousUpdateDTO dto) {

        RendezVous r = repo.findById(id).orElse(null);

        if (r == null) return null;

        r.setDateRendezVous(dto.getDateRendezVous());
        r.setStatut(dto.getStatut());

        Patient p = patientRepo.findById(dto.getPatientId()).orElse(null);
        Medcin m = medcinRepo.findById(dto.getMedcinId()).orElse(null);

        r.setPatient(p);
        r.setMedcin(m);

        RendezVous updated = repo.save(r);

        return RendezVousMapper.toGetDTO(updated);
    }


    public void delete(int id) {

        repo.deleteById(id);
    }


    public List<RendezVousGetDTO> findByPatient(int patientId) {

        List<RendezVous> list = repo.findByPatientId(patientId);
        List<RendezVousGetDTO> result = new ArrayList<>();

        for (RendezVous r : list) {
            result.add(RendezVousMapper.toGetDTO(r));
        }

        return result;
    }


    public List<RendezVousGetDTO> findByMedcin(int medcinId) {

        List<RendezVous> list = repo.findByMedcinId(medcinId);
        List<RendezVousGetDTO> result = new ArrayList<>();

        for (RendezVous r : list) {
            result.add(RendezVousMapper.toGetDTO(r));
        }

        return result;
    }
}
