package com.demo.heroes.adapter.input.web.hero.model.response;

public class HeroRestResponseMock {

  public static HeroRestResponse getMock() {
    return HeroRestResponse.builder()
             .id(1L)
             .nickname("SUPERMAN")
             .build();
  }
}
