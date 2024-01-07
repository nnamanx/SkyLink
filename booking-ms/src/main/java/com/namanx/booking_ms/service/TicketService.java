package com.namanx.booking_ms.service;

import com.namanx.booking_ms.model.entity.Ticket;

import java.util.Optional;

public interface TicketService {

    Ticket purchaseTicket(Ticket ticket);
    Ticket getTicketById(Long ticketId);

}