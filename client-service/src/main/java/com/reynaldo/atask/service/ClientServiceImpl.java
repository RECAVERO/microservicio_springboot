package com.reynaldo.atask.service;

import com.reynaldo.atask.interfaces.ClientService;
import com.reynaldo.domain.contract.ClientRepository;
import com.reynaldo.domain.models.ClientDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Flux<ClientDto> getListClient() {
        return this.clientRepository.getListClient();
    }

    @Override
    public Mono<ClientDto> saveClient(Mono<ClientDto> clientDto) {
        return this.clientRepository.saveClient(clientDto);
    }

    @Override
    public Mono<Void> deleteClientById(String id) {
        return this.clientRepository.deleteClientById(id);
    }

    @Override
    public Mono<ClientDto> updateClient(Mono<ClientDto> clientDto, String id) {
        return this.clientRepository.updateClient(clientDto, id);
    }

    @Override
    public Mono<ClientDto> getClientById(String idClient) {
        return this.clientRepository.getClientById(idClient);
    }
}
