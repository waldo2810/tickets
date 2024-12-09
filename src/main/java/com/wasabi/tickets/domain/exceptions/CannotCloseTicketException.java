package com.wasabi.tickets.domain.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Cannot close a closed ticket")
@AllArgsConstructor
public class CannotCloseTicketException extends RuntimeException {
  private String ticketId;
}
