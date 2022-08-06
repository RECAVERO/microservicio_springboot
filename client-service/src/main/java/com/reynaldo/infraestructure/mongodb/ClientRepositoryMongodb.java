package com.reynaldo.infraestructure.mongodb;

import com.reynaldo.domain.models.ClientDto;
import com.reynaldo.infraestructure.document.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClientRepositoryMongodb extends ReactiveMongoRepository<Client, String> {
    Mono<ClientDto> findByIdClient(String idClient);
}
