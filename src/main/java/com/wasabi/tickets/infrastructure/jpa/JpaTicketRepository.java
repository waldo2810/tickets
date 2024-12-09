package com.wasabi.tickets.infrastructure.jpa;

import com.wasabi.tickets.domain.TicketStatus;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaTicketRepository extends JpaRepository<JpaTicketEntity, String> {
  List<JpaTicketEntity> findByStatus(TicketStatus status, Pageable pageable);

  @Query(
      "UPDATE JpaTicketEntity t SET t.status = :status, t.updatedAt = :updatedAt WHERE t.id = :id")
  @Modifying
  @Transactional
  void updateTicketStatus(
      @Param("id") String id,
      @Param("status") TicketStatus status,
      @Param("updatedAt") LocalDateTime updatedAt);
}
