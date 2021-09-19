package com.demo.heroes.adapter.input.web.hero.model.response;

import com.demo.heroes.adapter.input.web.common.PageRestResponseMock;

import java.util.Collections;

public class PagedHeroesRestResponseMock {

  public static PagedHeroesRestResponse getMock() {
    return PagedHeroesRestResponse.builder()
             .page(PageRestResponseMock.getMock())
             .heroList(Collections.singletonList(HeroRestResponseMock.getMock()))
             .build();
  }
}
