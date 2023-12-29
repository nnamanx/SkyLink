package com.namanx.clientms.service.impl;

import com.namanx.clientms.repository.ClientRepository;
import com.namanx.clientms.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;


}
