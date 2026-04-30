package com.example.HealthCareApp.Repository;

import com.example.HealthCareApp.Entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Integer> {




    List<RendezVous> findByPatientId(int patientId);


    @Query(value = "SELECT r FROM RendezVous r WHERE r.medcin.id = :medcinId",nativeQuery = false)
    List<RendezVous> findByMedcinId(@Param("medcinId") int medcinId);


  


}
