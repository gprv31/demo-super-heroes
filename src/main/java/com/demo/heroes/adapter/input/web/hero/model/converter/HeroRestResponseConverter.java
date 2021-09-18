package com.demo.heroes.adapter.input.web.hero.model.converter;

import com.demo.heroes.adapter.input.web.hero.model.response.HeroRestResponse;
import com.demo.heroes.entity.hero.Hero;

import java.util.function.Function;

public class HeroRestResponseConverter implements Function<Hero, HeroRestResponse> {

  @Override
  public HeroRestResponse apply(Hero hero) {
    if (hero == null) {
      return null;
    }
    return HeroRestResponse.builder()
             .id(hero.getId())
             .nickname(hero.getNickname())
             .build();
  }
}
