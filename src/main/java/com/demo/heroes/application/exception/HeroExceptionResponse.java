package com.demo.heroes.application.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class HeroExceptionResponse {
  private int code;
  private String message;
}
