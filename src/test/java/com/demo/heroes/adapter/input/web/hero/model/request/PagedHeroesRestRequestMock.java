package com.demo.heroes.adapter.input.web.hero.model.request;

public class PagedHeroesRestRequestMock {

  public static PagedHeroesRestRequest getMock() {
    return PagedHeroesRestRequest.builder()
             .search("superman")
             .currentPage("1")
             .pageSize("10")
             .build();
  }
}
