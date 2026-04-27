package com.example.HealthCareApp.Repository;

import com.example.HealthCareApp.Entity.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedcinRepository  extends JpaRepository<Medcin,Integer> {
}
