package com.namanx.booking_ms.controller;

import com.namanx.booking_ms.helper.TicketMapper;
import com.namanx.booking_ms.model.dto.request.TicketRequest;
import com.namanx.booking_ms.model.entity.Ticket;
import com.namanx.booking_ms.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ticket-ms/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseTicket(@RequestBody TicketRequest ticketRequest) {

        Ticket ticket = ticketMapper.mapToTicket(ticketRequest);
        Ticket purchasedTicket = ticketService.purchaseTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchasedTicket);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long ticketId) {

        Ticket ticket = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticket);
    }

}
