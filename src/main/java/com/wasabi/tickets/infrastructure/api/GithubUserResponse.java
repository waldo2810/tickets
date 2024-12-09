package com.wasabi.tickets.infrastructure.api;

import com.wasabi.tickets.domain.GithubUser;
import java.util.List;
import lombok.Getter;

@Getter
public class GithubUserResponse {
  private List<GithubUser> items;
}
