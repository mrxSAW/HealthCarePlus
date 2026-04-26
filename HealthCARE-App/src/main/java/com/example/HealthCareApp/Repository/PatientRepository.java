package com.example.HealthCareApp.Repository;

import com.example.HealthCareApp.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;





public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
