package com.wasabi.tickets.domain;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PaginatedResponse<T> {
  private List<T> content;
  private long totalElements;
  private int totalPages;
  private int currentPage;
  private int pageSize;
  private boolean hasNext;
}
