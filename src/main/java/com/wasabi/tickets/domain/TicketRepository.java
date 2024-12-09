package com.wasabi.tickets.domain;

import java.util.List;

public interface TicketRepository {
  void save(Ticket ticket);

  void delete(String ticketId);

  void update(String ticketId);

  Ticket findById(String ticketId);

  List<Ticket> findAll(int page, int size);

  List<Ticket> findByStatus(TicketStatus status, int page, int size);
}
