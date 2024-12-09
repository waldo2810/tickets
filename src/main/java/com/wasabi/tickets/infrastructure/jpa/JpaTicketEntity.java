package com.wasabi.tickets.infrastructure.jpa;

import com.wasabi.tickets.domain.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaTicketEntity {
  @Id private String id;
  private String associated_user;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private TicketStatus status;
}
