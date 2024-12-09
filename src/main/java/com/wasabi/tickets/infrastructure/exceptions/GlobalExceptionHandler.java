package com.wasabi.tickets.infrastructure.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  // Specific Exception Handler (e.g., CannotCloseTicketException)
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), null);
  }

  // Fallback for Other Exceptions
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleGenericException(Exception ex) {
    return buildErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", null);
  }

  // Helper Method to Build Responses
  private ResponseEntity<Object> buildErrorResponse(
      HttpStatus status, String message, String path) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", status.value());
    body.put("error", status.getReasonPhrase());
    body.put("message", message);
    if (path != null) {
      body.put("path", path);
    }
    return new ResponseEntity<>(body, status);
  }
}
