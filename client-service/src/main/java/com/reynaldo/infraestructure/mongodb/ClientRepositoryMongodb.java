package com.reynaldo.infraestructure.mongodb;

import com.reynaldo.infraestructure.document.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepositoryMongodb extends ReactiveMongoRepository<Client, String> {
}
