package com.demo.heroes.entity.hero;

public class HeroMock {

  public static Hero getMock() {
    return Hero.builder()
             .id(1L)
             .nickname("SUPERMAN")
             .build();
  }
}
