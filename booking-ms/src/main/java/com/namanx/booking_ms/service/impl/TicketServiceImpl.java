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

    @Override
    public Optional<Ticket> getTicketsByTicketId(Long ticket_id) {
        return ticketRepo.findById(ticket_id);
    }

    @Override
    public Ticket purchaseTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long ticketId) {
        return ticketRepo.findById(ticketId).orElseThrow(() -> new EntityNotFoundException(TICKET_NOT_FOUND + ticketId));
    }

}
