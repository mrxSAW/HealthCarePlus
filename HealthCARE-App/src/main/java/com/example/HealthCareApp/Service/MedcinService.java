package com.example.HealthCareApp.Service;


import com.example.HealthCareApp.DTO.Medcin.MedcinGetDTO;
import com.example.HealthCareApp.DTO.Medcin.MedcinPostDTO;
import com.example.HealthCareApp.DTO.Medcin.MedcinUpdateDTO;
import com.example.HealthCareApp.Entity.Medcin;
import com.example.HealthCareApp.Mapper.MedcinMapper;
import com.example.HealthCareApp.Repository.MedcinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedcinService {

    private final MedcinRepository repo;

    public MedcinService(MedcinRepository repo) {
        this.repo = repo;
    }


    public MedcinGetDTO save(MedcinPostDTO dto) {

        Medcin m = MedcinMapper.toEntity(dto);
        Medcin saved = repo.save(m);

        return MedcinMapper.toGetDTO(saved);
    }


    public List<MedcinGetDTO> getAll() {

        List<Medcin> list = repo.findAll();
        List<MedcinGetDTO> result = new ArrayList<>();

        for (Medcin m : list) {
            result.add(MedcinMapper.toGetDTO(m));
        }

        return result;
    }


    public MedcinGetDTO getById(int id) {

        Medcin m = repo.findById(id).orElse(null);

        if (m == null) return null;

        return MedcinMapper.toGetDTO(m);
    }


    public MedcinGetDTO update(int id, MedcinUpdateDTO dto) {

        Medcin m = repo.findById(id).orElse(null);

        if (m == null) return null;

        m.setNom(dto.getNom());
        m.setSpecialite(dto.getSpecialite());
        m.setEmail(dto.getEmail());
        m.setTelephone(dto.getTelephone());

        Medcin updated = repo.save(m);

        return MedcinMapper.toGetDTO(updated);
    }


    public void delete(int id) {
        repo.deleteById(id);
    }
}
