package com.example.HealthCareApp.Controller;

import com.example.HealthCareApp.DTO.Medcin.MedcinGetDTO;
import com.example.HealthCareApp.DTO.Medcin.MedcinPostDTO;
import com.example.HealthCareApp.DTO.Medcin.MedcinUpdateDTO;
import com.example.HealthCareApp.Service.MedcinService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medcins")
@SecurityRequirement(name = "bearerAuth")
public class MedcinController {

    private final MedcinService service;

    public MedcinController(MedcinService service) {
        this.service = service;
    }


    @PostMapping
    public MedcinGetDTO ajouter(@Valid  @RequestBody MedcinPostDTO dto) {
        return service.save(dto);
    }


    @GetMapping
    public List<MedcinGetDTO> list() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public MedcinGetDTO get(@PathVariable int id) {
        return service.getById(id);
    }


    @PutMapping("/{id}")
    public MedcinGetDTO update(@PathVariable int id, @Valid @RequestBody MedcinUpdateDTO dto) {

        return service.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}