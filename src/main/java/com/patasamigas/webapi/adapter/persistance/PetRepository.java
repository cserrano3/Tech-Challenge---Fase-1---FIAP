package com.patasamigas.webapi.adapter.persistance;


import com.patasamigas.webapi.adapter.persistance.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, String> {

}
