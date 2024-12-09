package com.wasabi.tickets.infrastructure.api;

import com.wasabi.tickets.application.CreateTicket;
import com.wasabi.tickets.application.DeleteTicket;
import com.wasabi.tickets.application.FindTicket;
import com.wasabi.tickets.domain.Ticket;
import com.wasabi.tickets.domain.TicketStatus;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
  private final CreateTicket createTicketUseCase;
  private final DeleteTicket deleteTicketUseCase;
  private final FindTicket findTicketUseCase;

  @PostMapping
  public ResponseEntity<HashMap<String, String>> createTicket(@RequestBody TicketRequest request) {
    createTicketUseCase.createTicket(request);
    HashMap<String, String> response = new HashMap<>();
    response.put("message", "created successfully");
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HashMap<String, String>> deleteTicket(@PathVariable String id) {
    deleteTicketUseCase.deleteTicket(id);
    HashMap<String, String> response = new HashMap<>();
    response.put("message", "deleted successfully");
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public List<Ticket> getAllTickets(
      @RequestParam int page,
      @RequestParam int size,
      @RequestParam(required = false) TicketStatus status) {
    return status == null
        ? findTicketUseCase.getAllTickets(page, size)
        : findTicketUseCase.getTicketsByStatus(status, page, size);
  }
}
