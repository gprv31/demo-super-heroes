package com.demo.heroes.adapter.output.h2.converter;

import com.demo.heroes.adapter.output.h2.entity.HeroEntity;
import com.demo.heroes.entity.hero.Hero;

import java.util.function.Function;

public class HeroConverter implements Function<HeroEntity, Hero> {

  @Override
  public Hero apply(HeroEntity heroEntity) {
    if (heroEntity == null) {
      return null;
    }
    return Hero.builder()
             .id(heroEntity.getId())
             .nickname(heroEntity.getNickname())
             .build();
  }
}
