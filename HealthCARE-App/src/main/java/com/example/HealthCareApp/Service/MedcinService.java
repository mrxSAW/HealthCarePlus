package com.example.HealthCareApp.Service;

import com.example.HealthCareApp.DTO.Medcin.MedcinGetDTO;
import com.example.HealthCareApp.DTO.Medcin.MedcinPostDTO;
import com.example.HealthCareApp.DTO.Medcin.MedcinUpdateDTO;
import com.example.HealthCareApp.Entity.Medcin;
import com.example.HealthCareApp.Mapper.MedcinMapper;
import com.example.HealthCareApp.Repository.MedcinRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedcinService {

    private final MedcinRepository repo;
    private final MedcinMapper mapper;

    public MedcinService(MedcinRepository repo, MedcinMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public MedcinGetDTO save(MedcinPostDTO dto) {
        Medcin medcin = mapper.toEntity(dto);
        Medcin savedMedcin = repo.save(medcin);
        return mapper.toGetDTO(savedMedcin);
    }

    public List<MedcinGetDTO> getAll() {
        List<Medcin> medcins = repo.findAll();
        List<MedcinGetDTO> result = new ArrayList<>();

        for (Medcin medcin : medcins) {
            MedcinGetDTO dto = mapper.toGetDTO(medcin);
            result.add(dto);
        }

        return result;
    }

    public MedcinGetDTO getById(int id) {
        Medcin medcin = repo.findById(id).orElse(null);

        if (medcin == null) {
            return null;
        }

        return mapper.toGetDTO(medcin);
    }

    public MedcinGetDTO update(int id, MedcinUpdateDTO dto) {
        Medcin medcin = repo.findById(id).orElse(null);

        if (medcin == null) {
            return null;
        }

        mapper.updateMedcinFromDTO(dto, medcin);

        Medcin updatedMedcin = repo.save(medcin);
        return mapper.toGetDTO(updatedMedcin);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}


