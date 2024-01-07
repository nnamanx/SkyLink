package com.namanx.booking_ms.service.impl;

import com.namanx.booking_ms.model.entity.Ticket;
import com.namanx.booking_ms.repository.TicketRepo;
import com.namanx.booking_ms.service.TicketService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.namanx.booking_ms.model.constants.Messages.TICKET_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepo ticketRepo;
//    private final FlightMicroserviceClient flightMicroserviceClient; // Assuming you have a Feign client for Flight Microservice
//    private final UserMicroserviceClient userMicroserviceClient; // Assuming you have a Feign client for User Microservice


    @Override
    public Ticket getTicketById(Long ticketId) {
        return ticketRepo.findById(ticketId).orElseThrow(() -> new EntityNotFoundException(TICKET_NOT_FOUND + ticketId));
    }

    @Override
    public Ticket purchaseTicket(Ticket ticket) {

        // Validate ticket details
//        validateTicket(ticket);

        // Check if the flight exists and is available
//        validateFlight(ticket.getFlight_id());

        // Check if the client (user) exists
//        validateClient(ticket.getClient_id());

        return ticketRepo.save(ticket);
    }


    private void validateTicket(Ticket ticket) {
        // Add your validation logic here
    }

//    private void validateFlight(Long flightId) {
//        // Assuming you have a method in your Flight Microservice client to check if a flight exists and is available
//        FlightInfo flightInfo = flightMicroserviceClient.getFlightInfoById(flightId);
//        if (flightInfo == null || !flightInfo.isAvailable()) {
//            throw new RuntimeException("Flight with id " + flightId + " does not exist or is not available.");
//        }
//    }

    //    private void validateClient(Long clientId) {
//        // Assuming you have a method in your User Microservice client to check if a client (user) exists
//        Client client = userMicroserviceClient.getUserById(clientId);
//        if (user == null) {
//            throw new RuntimeException("Client with id " + clientId + " does not exist.");
//        }
//    }

}
