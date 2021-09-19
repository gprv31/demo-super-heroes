package com.demo.heroes.adapter.input.web.hero.model.converter;

import com.demo.heroes.adapter.input.web.hero.model.request.HeroEditRestRequest;
import com.demo.heroes.entity.hero.request.HeroEditRequest;

import java.util.function.Function;

public class HeroEditRequestConverter implements Function<HeroEditRestRequest, HeroEditRequest> {

  @Override
  public HeroEditRequest apply(HeroEditRestRequest heroEditRestRequest) {
    if (heroEditRestRequest == null) {
      return null;
    }
    return HeroEditRequest.builder()
             .id(Long.parseLong(heroEditRestRequest.getId()))
             .nickname(heroEditRestRequest.getNickname())
             .build();
  }
}
