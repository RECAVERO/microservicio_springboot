package com.reynaldo.application.controller;

import com.reynaldo.atask.interfaces.ClientService;
import com.reynaldo.domain.models.ClientDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public Flux<ClientDto> getListClient(){
        return this.clientService.getListClient();
    }

    @PostMapping
    public Mono<ClientDto> saveClient(Mono<ClientDto> clientDto){
        return this.clientService.saveClient(clientDto);
    }

}
