package com.example.HealthCareApp.Controller;

import com.example.HealthCareApp.DTO.Patient.PatientGetDTO;
import com.example.HealthCareApp.DTO.Patient.PatientPostDTO;
import com.example.HealthCareApp.DTO.Patient.PatientUpdateDTO;
import com.example.HealthCareApp.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }


    @PostMapping
    public PatientGetDTO ajouter(@Valid @RequestBody PatientPostDTO dto) {


        return service.save(dto);
    }


    @GetMapping
    public List<PatientGetDTO> list() {

        return service.getAll();
    }


    @GetMapping("/{id}")
    public PatientGetDTO get(@PathVariable int id) {

        return service.getById(id);
    }


    @PutMapping("/{id}")
    public PatientGetDTO update(@PathVariable int id, @Valid @RequestBody PatientUpdateDTO dto) {

        return service.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {


        service.delete(id);
    }


}