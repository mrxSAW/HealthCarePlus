package com.example.HealthCareApp.Controller;

import com.example.HealthCareApp.DTO.DossierMedical.DossierMedicalGetDTO;
import com.example.HealthCareApp.DTO.DossierMedical.DossierMedicalPostDTO;
import com.example.HealthCareApp.DTO.DossierMedical.DossierMedicalUpdateDTO;
import com.example.HealthCareApp.Service.DossierMedicalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dossiers")
@SecurityRequirement(name = "bearerAuth")
public class DossierMedicalController {

    private final DossierMedicalService service;

    public DossierMedicalController(DossierMedicalService service) {
        this.service = service;
    }


    @PostMapping
    public DossierMedicalGetDTO create(@Valid @RequestBody  DossierMedicalPostDTO dto) {
        return service.save(dto);
    }


    @GetMapping
    public List<DossierMedicalGetDTO> list() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public DossierMedicalGetDTO get(@PathVariable int id) {
        return service.getById(id);
    }


    @PutMapping("/{id}")
    public DossierMedicalGetDTO update(@PathVariable int id, @Valid @RequestBody DossierMedicalUpdateDTO dto) {

        return service.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}