package com.wasabi.tickets.infrastructure.jpa;

import com.wasabi.tickets.domain.Ticket;
import com.wasabi.tickets.domain.TicketRepository;
import com.wasabi.tickets.domain.TicketStatus;
import com.wasabi.tickets.domain.exceptions.TicketNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaTicketAdapter implements TicketRepository {
  private final JpaTicketRepository jpaTicketRepository;

  @Override
  public void save(Ticket ticket) {
    JpaTicketEntity entity = this.toJpaEntity(ticket);
    System.out.println(entity.toString());
    jpaTicketRepository.save(entity);
  }

  @Override
  public void delete(String ticketId) {
    this.findById(ticketId);
    jpaTicketRepository.deleteById(ticketId);
  }

  @Override
  public void update(String ticketId) {
    this.findById(ticketId);
    jpaTicketRepository.updateTicketStatus(ticketId, TicketStatus.CLOSED, LocalDateTime.now());
  }

  @Override
  public Ticket findById(String ticketId) {
    JpaTicketEntity found =
        jpaTicketRepository
            .findById(ticketId)
            .orElseThrow(() -> new TicketNotFoundException(ticketId));
    return this.toDomain(found);
  }

  @Override
  public List<Ticket> findAll(int page, int size) {
    return jpaTicketRepository.findAll().stream().map(this::toDomain).toList();
  }

  @Override
  public List<Ticket> findByStatus(TicketStatus status, int page, int size) {
    return jpaTicketRepository.findByStatus(status, PageRequest.of(page, size)).stream()
        .map(this::toDomain)
        .toList();
  }

  private JpaTicketEntity toJpaEntity(Ticket domain) {
    return new JpaTicketEntity(
        domain.getId(),
        domain.getAssociated_user(),
        domain.getCreatedAt(),
        domain.getUpdatedAt(),
        domain.getStatus());
  }

  private Ticket toDomain(JpaTicketEntity jpa) {
    return new Ticket(
        jpa.getId(),
        jpa.getAssociated_user(),
        jpa.getCreatedAt(),
        jpa.getUpdatedAt(),
        jpa.getStatus());
  }
}
