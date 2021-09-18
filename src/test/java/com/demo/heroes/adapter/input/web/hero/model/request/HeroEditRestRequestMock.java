package com.demo.heroes.adapter.input.web.hero.model.request;

public class HeroEditRestRequestMock {

  public static HeroEditRestRequest getMock() {
    return HeroEditRestRequest.builder()
             .id("1")
             .nickname("THOR")
             .build();
  }
}
