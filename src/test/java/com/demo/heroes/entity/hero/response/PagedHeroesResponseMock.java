package com.demo.heroes.entity.hero.response;

import com.demo.heroes.entity.common.PageResponseMock;
import com.demo.heroes.entity.hero.HeroMock;

import java.util.Collections;

public class PagedHeroesResponseMock {

  public static PagedHeroesResponse getMock() {
    return PagedHeroesResponse.builder()
             .page(PageResponseMock.getMock())
             .heroList(Collections.singletonList(HeroMock.getMock()))
             .build();
  }
}
