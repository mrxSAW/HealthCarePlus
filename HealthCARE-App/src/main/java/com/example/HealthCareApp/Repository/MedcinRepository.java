package com.example.HealthCareApp.Repository;

import com.example.HealthCareApp.Entity.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository  extends JpaRepository<Medcin,Integer> {
}
