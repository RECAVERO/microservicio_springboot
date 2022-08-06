package com.reynaldo.application.controller;
import com.reynaldo.atask.interfaces.ClientService;
import com.reynaldo.domain.models.ClientDto;
import com.reynaldo.domain.models.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    private static final Logger logger= LoggerFactory.getLogger(ClientController.class);
    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    @GetMapping
    public Flux<ClientDto> getListClient(){
        return this.clientService.getListClient();
    }

    @PostMapping
    public Mono<ClientDto> saveClient(@RequestBody @Valid Mono<ClientDto> clientDto){
        return this.clientService.saveClient(clientDto);
    }

    @PutMapping("/{idClient}")
    public Mono<ResponseDto> updateClient(@RequestBody Mono<ClientDto> clientDto,
                                          @PathVariable String idClient){
        ResponseDto responseDto=new ResponseDto();
        return clientDto.flatMap(client->{
            System.out.println(client);
            return this.clientService.getClientById(idClient).flatMap(cli->{
                System.out.println(cli);
                try{
                    System.out.println(cli);
                    cli.setIdClient(idClient);
                    cli.setNameClient(client.getNameClient());
                    return this.clientService.updateClient(Mono.just(cli), cli.getId()).flatMap(c->{
                        responseDto.setStatus(HttpStatus.OK.toString());
                        responseDto.setMessage("OK");
                        responseDto.setClient(c);
                        return Mono.just(responseDto);
                    });
                }catch (Exception ex){


                    responseDto.setStatus(HttpStatus.NOT_MODIFIED.toString());
                    responseDto.setMessage(ex.getMessage());
                    logger.error("User Not Found with ID : {}","xxx");
                    return Mono.just(responseDto);
                }
            });
        });


        //return this.clientService.updateClient(clientDto, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteClientById(@PathVariable String id){
        return this.clientService.deleteClientById(id);
    }

    @GetMapping("/{id}")
    public Mono<ClientDto> getClientById(@PathVariable String id){
        return this.clientService.getClientById(id);
    }
    @GetMapping("/prueba/{id}")
    public String prueba(@PathVariable String id){
        //this.logger = ;
        logger.error("User Not Found with ID : {}",id);

        return "bien";
    }
}
