package com.reynaldo.atask.interfaces;

import com.reynaldo.domain.models.ClientDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<ClientDto> getListClient();
    Mono<ClientDto> saveClient(Mono<ClientDto> clientDto);

    Mono<Void> deleteClientById(String id);

    Mono<ClientDto> updateClient(Mono<ClientDto> clientDto, String id);
    Mono<ClientDto> getClientById(String idClient);
}
