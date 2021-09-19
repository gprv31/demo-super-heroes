package com.demo.heroes.application.security;

import com.demo.heroes.application.exception.HeroExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
                     AccessDeniedException accessDeniedException) throws IOException {
    HeroExceptionResponse heroExceptionResponse = new HeroExceptionResponse();
    heroExceptionResponse.setCode(HttpStatus.FORBIDDEN.value());
    heroExceptionResponse.setMessage(accessDeniedException.getMessage());
    OutputStream out = response.getOutputStream();
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(out, heroExceptionResponse);
    out.flush();
  }
}
