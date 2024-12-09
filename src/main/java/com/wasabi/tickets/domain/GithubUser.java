package com.wasabi.tickets.domain;

import lombok.Data;

@Data
public class GithubUser {
  private String login;
  private String avatar_url;
  private String html_url;
}
