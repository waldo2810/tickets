package com.wasabi.tickets.domain.exceptions;

import lombok.Getter;

@Getter
public class CannotCloseTicketException extends RuntimeException {
  private final String ticketId;

  public CannotCloseTicketException(String ticketId) {
    super("Cannot close a closed ticket");
    this.ticketId = ticketId;
  }
}
