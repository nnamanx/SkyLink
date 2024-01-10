package com.namanx.booking_ms.helper;


import com.namanx.booking_ms.model.dto.request.TicketRequest;
import com.namanx.booking_ms.model.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mapping(target = "ticket_id", ignore = true)
    @Mapping(target = "payments", ignore = true)
    Ticket mapToTicket(TicketRequest ticketRequest);
}
