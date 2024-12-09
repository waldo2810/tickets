package com.wasabi.tickets.application;

import com.wasabi.tickets.domain.Ticket;
import com.wasabi.tickets.domain.TicketRepository;
import com.wasabi.tickets.domain.TicketStatus;
import com.wasabi.tickets.infrastructure.api.TicketRequest;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTicket {
  private final TicketRepository ticketRepository;

  public void createTicket(TicketRequest request) {
    Ticket created =
        new Ticket(
            UUID.randomUUID().toString(),
            request.getUser(),
            LocalDateTime.now(),
            LocalDateTime.now(),
            TicketStatus.OPEN);

    ticketRepository.save(created);
  }
}
