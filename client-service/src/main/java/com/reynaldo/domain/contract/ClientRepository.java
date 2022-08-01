package com.reynaldo.domain.contract;

import com.reynaldo.domain.models.ClientDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository {
    Flux<ClientDto> getListClient();
    Mono<ClientDto> saveClient(Mono<ClientDto> clientDto);
}
