package com.patasamigas.webapi.adapter.controllers;


import com.patasamigas.webapi.adapter.controllers.dtos.pet.CreatePetDTO;
import com.patasamigas.webapi.application.useCases.CreatePetUseCase;
import com.patasamigas.webapi.domain.Pet;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final CreatePetUseCase createPetUseCase;


    public PetController(CreatePetUseCase createPetUseCase) {
        this.createPetUseCase = createPetUseCase;
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody CreatePetDTO newPetDTO) {
        Pet createdPet = this.createPetUseCase.createPet(newPetDTO);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(createdPet);

    }
}
