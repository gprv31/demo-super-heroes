package com.demo.heroes.adapter.input.web.auth.request;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JwtRestRequest implements Serializable {
  private static final long serialVersionUID = 5926468583005150707L;
  private String username;
  private String password;
}
