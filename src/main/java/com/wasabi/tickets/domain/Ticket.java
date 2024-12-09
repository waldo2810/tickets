package com.wasabi.tickets.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
  private String id;
  private String associated_user;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private TicketStatus status;
}
