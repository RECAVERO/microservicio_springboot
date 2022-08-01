package com.reynaldo.utils.convert;

import com.reynaldo.domain.models.ClientDto;
import com.reynaldo.infraestructure.document.Client;
import org.springframework.beans.BeanUtils;

public class Convert {
    public static ClientDto entityToDto(Client client) {
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(client, clientDto);
        return clientDto;
    }

    public static Client dtoToEntity(ClientDto clientDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return client;
    }
}
