package com.example.HealthCareApp.Repository;

import com.example.HealthCareApp.Entity.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical,Integer> {

}
