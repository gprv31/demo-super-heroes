package com.demo.heroes.entity.hero.request;

public class PagedHeroesRequestMock {

  public static PagedHeroesRequest getMock() {
    return PagedHeroesRequest.builder()
             .search("superman")
             .pageSize(1)
             .currentPage(10)
             .build();
  }
}
