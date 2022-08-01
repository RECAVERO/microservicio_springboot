package com.reynaldo.infraestructure.repository;

import com.reynaldo.domain.contract.ClientRepository;
import com.reynaldo.domain.models.ClientDto;
import com.reynaldo.infraestructure.mongodb.ClientRepositoryMongodb;
import com.reynaldo.utils.convert.Convert;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    private final ClientRepositoryMongodb clientRepositoryMongodb;

    public ClientRepositoryImpl(ClientRepositoryMongodb clientRepositoryMongodb) {
        this.clientRepositoryMongodb = clientRepositoryMongodb;
    }

    @Override
    public Flux<ClientDto> getListClient() {
        return this.clientRepositoryMongodb.findAll().map(Convert::entityToDto);
    }

    @Override
    public Mono<ClientDto> saveClient(Mono<ClientDto> clientDto) {
        return clientDto.map(Convert::dtoToEntity)
                .flatMap(client->this.clientRepositoryMongodb.insert(client))
                .map(Convert::entityToDto);
    }

}
