package com.namanx.clientms.service;

import com.namanx.clientms.model.dto.response.ClientResponse;
import com.namanx.clientms.model.entity.Client;
import org.springframework.http.ResponseEntity;

public interface ClientService {

    // CRUD operations of Client service
    Client registerClient(Client newClient);

    Client getClientByUsername(String username);

    Client updateClient(Client client);

    ResponseEntity<ClientResponse<String>> deleteClient(Long clientId);

    // Security operations





}
