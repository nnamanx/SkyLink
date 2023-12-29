package com.namanx.clientms.service.impl;

import com.namanx.clientms.model.dto.response.ClientResponse;
import com.namanx.clientms.model.entity.Client;
import com.namanx.clientms.repository.ClientRepository;
import com.namanx.clientms.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;


    @Override
    public Client registerClient(Client newClient) {
        return null;
    }

    @Override
    public Client getClientByUsername(String username) {
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public ResponseEntity<ClientResponse<String>> deleteClient(Long clientId) {
        return null;
    }
}
