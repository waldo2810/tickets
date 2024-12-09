package com.wasabi.tickets.infrastructure.jpa;

import com.wasabi.tickets.domain.TicketStatus;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTicketRepository extends JpaRepository<JpaTicketEntity, String> {
  List<JpaTicketEntity> findByStatus(TicketStatus status, Pageable pageable);
}
