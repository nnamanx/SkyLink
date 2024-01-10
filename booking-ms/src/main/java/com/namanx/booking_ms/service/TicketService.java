package com.namanx.booking_ms.service;

import com.namanx.booking_ms.model.dto.request.TicketRequest;
import com.namanx.booking_ms.model.entity.Ticket;
import com.namanx.booking_ms.repository.TicketRepo;

import java.util.Optional;

public interface TicketService {

    Ticket purchaseTicket(TicketRequest ticketRequest);
    Ticket getTicketById(Long ticketId);

}
