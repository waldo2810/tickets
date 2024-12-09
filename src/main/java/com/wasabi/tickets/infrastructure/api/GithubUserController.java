package com.wasabi.tickets.infrastructure.api;

import com.wasabi.tickets.application.GithubUserService;
import com.wasabi.tickets.domain.GithubUser;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/github-users")
@RequiredArgsConstructor
public class GithubUserController {
  private final GithubUserService ghUserService;

  @GetMapping
  public List<GithubUser> searchUsers(@RequestParam String name) {
    return ghUserService.searchUsers(name);
  }
}
