package com.wasabi.tickets.application;

import com.wasabi.tickets.domain.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTicket {
  private final TicketRepository ticketRepository;

  public void deleteTicket(String ticketId) {
    ticketRepository.delete(ticketId);
  }
}
