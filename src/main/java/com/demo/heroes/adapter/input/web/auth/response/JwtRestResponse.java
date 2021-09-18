package com.demo.heroes.adapter.input.web.auth.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtRestResponse implements Serializable {
  private static final long serialVersionUID = -8091879091924046844L;
  private final String jwtToken;
}
