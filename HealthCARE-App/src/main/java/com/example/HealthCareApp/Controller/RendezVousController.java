package com.example.HealthCareApp.Controller;

import com.example.HealthCareApp.DTO.RendezVous.RendezVousGetDTO;
import com.example.HealthCareApp.DTO.RendezVous.RendezVousPostDTO;
import com.example.HealthCareApp.DTO.RendezVous.RendezVousUpdateDTO;
import com.example.HealthCareApp.Service.RendezVousService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
@SecurityRequirement(name = "bearerAuth")
public class RendezVousController {

    private final RendezVousService service;

    public RendezVousController(RendezVousService service) {
        this.service = service;
    }

    @PostMapping
    public RendezVousGetDTO create(@Valid @RequestBody RendezVousPostDTO dto) {

        return service.save(dto);
    }

    @GetMapping
    public List<RendezVousGetDTO> list() {


        return service.getAll();
    }

    @PutMapping("/{id}")
    public RendezVousGetDTO update(@PathVariable int id,@Valid @RequestBody RendezVousUpdateDTO dto) {

        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {


        service.delete(id);
    }


    @GetMapping("/patient/{id}")
    public List<RendezVousGetDTO> byPatient(@PathVariable int id) {


        return service.findByPatient(id);
    }


    @GetMapping("/medcin/{id}")
    public List<RendezVousGetDTO> byMedcin(@PathVariable int id) {

        return service.findByMedcin(id);
    }


}
