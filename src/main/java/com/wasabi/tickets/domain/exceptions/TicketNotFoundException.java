package com.wasabi.tickets.domain.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such ticket")
@AllArgsConstructor
public class TicketNotFoundException extends RuntimeException {
  private String ticketId;
}
