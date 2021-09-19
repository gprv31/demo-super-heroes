package com.demo.heroes.adapter.input.web.hero.model.converter;

import com.demo.heroes.adapter.input.web.hero.model.request.PagedHeroesRestRequest;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;

import java.util.function.Function;

public class PagedHeroesRequestConverter implements Function<PagedHeroesRestRequest, PagedHeroesRequest> {

  @Override
  public PagedHeroesRequest apply(PagedHeroesRestRequest pagedHeroesRestRequest) {
    if (pagedHeroesRestRequest == null) {
      return null;
    }
    return PagedHeroesRequest.builder()
             .search(pagedHeroesRestRequest.getSearch())
             .currentPage(Integer.valueOf(pagedHeroesRestRequest.getCurrentPage()))
             .pageSize(Integer.valueOf(pagedHeroesRestRequest.getPageSize()))
             .build();
  }
}
