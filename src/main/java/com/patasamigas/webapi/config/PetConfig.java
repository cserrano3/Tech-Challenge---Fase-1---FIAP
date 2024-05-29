package com.patasamigas.webapi.config;

import com.patasamigas.webapi.adapter.gateways.PetGatewayImpl;
import com.patasamigas.webapi.adapter.mappers.pet.CreatedPetDTOMapper;
import com.patasamigas.webapi.adapter.mappers.pet.PetEntityMapper;
import com.patasamigas.webapi.adapter.persistance.PetRepository;
import com.patasamigas.webapi.adapter.persistance.entities.PetBuilder;
import com.patasamigas.webapi.adapter.persistance.entities.PetHealthRecordBuilder;
import com.patasamigas.webapi.application.useCases.CreatePetUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetConfig {

    @Bean
    CreatedPetDTOMapper createPetDTOMapper() {
        return new CreatedPetDTOMapper();
    }

    @Bean
    PetEntityMapper createPetEntityMapper() {
        return new PetEntityMapper();
    }

    @Bean
    PetHealthRecordBuilder createPetHealthRecordBuilder() {
        return new PetHealthRecordBuilder();
    }


    @Bean
    PetBuilder createPetBuilder(PetHealthRecordBuilder petHealthRecordBuilder) {
        return new PetBuilder(petHealthRecordBuilder);
    }

    @Bean
    PetGatewayImpl createPetGateway(PetRepository petRepository, PetEntityMapper petEntityMapper, PetBuilder petBuilder) {
        return new PetGatewayImpl(petRepository, petEntityMapper, petBuilder);
    }

    @Bean
    CreatePetUseCase createCreatePetUseCase(PetGatewayImpl petGateway) {
        return new CreatePetUseCase(petGateway);
    }
}
