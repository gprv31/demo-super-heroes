package com.demo.heroes.entity.hero.request;

public class HeroEditRequestMock {

  public static HeroEditRequest getMock() {
    return HeroEditRequest.builder()
             .id(1L)
             .nickname("THOR")
             .build();
  }
}
