package com.wasabi.tickets.application;

import com.wasabi.tickets.domain.Ticket;
import com.wasabi.tickets.domain.TicketRepository;
import com.wasabi.tickets.domain.TicketStatus;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindTicket {
  private final TicketRepository ticketRepository;

  public List<Ticket> getAllTickets(int page, int size) {
    return ticketRepository.findAll(page, size);
  }

  public List<Ticket> getTicketsByStatus(TicketStatus status, int page, int size) {
    return ticketRepository.findByStatus(status, page, size);
  }
}
