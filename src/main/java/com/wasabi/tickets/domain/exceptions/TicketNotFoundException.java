package com.wasabi.tickets.domain.exceptions;

import lombok.Getter;

@Getter
public class TicketNotFoundException extends RuntimeException {
  private final String ticketId;

  public TicketNotFoundException(String ticketId) {
    super(String.format("Ticket with id %s was not found", ticketId));
    this.ticketId = ticketId;
  }
}
