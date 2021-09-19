package com.demo.heroes.adapter.output.h2.entity;

public class HeroEntityMock {

  public static HeroEntity getMock() {
    HeroEntity heroEntity = new HeroEntity();
    heroEntity.setId(1L);
    heroEntity.setNickname("SUPERMAN");
    return heroEntity;
  }
}
