package com.example.HealthCareApp.Repository;

import com.example.HealthCareApp.Entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Integer> {



    // Derived Query
    List<RendezVous> findByPatientId(int patientId);

    // JPQL
    @Query(value = "SELECT r FROM RendezVous r WHERE r.medcin.id = :medcinId",nativeQuery = false)
    List<RendezVous> findByMedcinId(@Param("medcinId") int medcinId);


    /*
         @Query(value = "SELECT * FROM rendez_vous WHERE medcin_id = :medcinId", nativeQuery = true)
          List<RendezVous> findByMedcinId(@Param("medcinId") int medcinId);

    */



}
