package com.example.HealthCareApp.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.List;

@Entity
@Data
public class Medcin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String specialite;
    private String email;
    private String telephone;
    @OneToMany(mappedBy = "medcin")
    private List<RendezVous> rendezVous;
}
