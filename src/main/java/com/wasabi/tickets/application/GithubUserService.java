package com.wasabi.tickets.application;

import com.wasabi.tickets.domain.GithubUser;
import com.wasabi.tickets.infrastructure.api.GithubUserResponse;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GithubUserService {
  private final RestTemplate restTemplate;

  public List<GithubUser> searchUsers(String name) {
    String URL = "https://api.github.com/search/users?q=";
    String url = URL + name;
    return Objects.requireNonNull(restTemplate.getForObject(url, GithubUserResponse.class))
        .getItems();
  }
}
