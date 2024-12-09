package com.wasabi.tickets.domain;

public interface TicketRepository {
  void save(Ticket ticket);

  void delete(String ticketId);

  void update(String ticketId);

  Ticket findById(String ticketId);

  PaginatedResponse<Ticket> findAll(int page, int size);

  PaginatedResponse<Ticket> findByStatus(TicketStatus status, int page, int size);
}
