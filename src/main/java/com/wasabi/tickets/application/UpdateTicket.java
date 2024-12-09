package com.wasabi.tickets.application;

import com.wasabi.tickets.domain.Ticket;
import com.wasabi.tickets.domain.TicketRepository;
import com.wasabi.tickets.domain.TicketStatus;
import com.wasabi.tickets.domain.exceptions.CannotCloseTicketException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTicket {
  private final TicketRepository ticketRepository;

  public void updateTicket(String ticketId) {
    Ticket found = ticketRepository.findById(ticketId);
    if (found.getStatus().equals(TicketStatus.CLOSED)) {
      throw new CannotCloseTicketException(ticketId);
    }
    ticketRepository.update(ticketId);
  }
}
