package com.demo.heroes.adapter.input.web.hero.model.converter;

import com.demo.heroes.adapter.input.web.common.model.PageRestResponse;
import com.demo.heroes.adapter.input.web.hero.model.response.HeroRestResponse;
import com.demo.heroes.adapter.input.web.hero.model.response.PagedHeroesRestResponse;
import com.demo.heroes.entity.common.response.PageResponse;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PagedHeroesRestResponseConverter implements Function<PagedHeroesResponse, PagedHeroesRestResponse> {

  private final Function<PageResponse, PageRestResponse> pageRestResponseConverter;
  private final Function<Hero, HeroRestResponse> heroRestResponseConverter;

  @Override
  public PagedHeroesRestResponse apply(PagedHeroesResponse pagedHeroesResponse) {
    if (pagedHeroesResponse == null) {
      return null;
    }
    return PagedHeroesRestResponse.builder()
             .page(pageRestResponseConverter.apply(pagedHeroesResponse.getPage()))
             .heroList(this.buildHeroList(pagedHeroesResponse.getHeroList()))
             .build();
  }

  private List<HeroRestResponse> buildHeroList(List<Hero> heroList) {
    if (heroList == null || heroList.isEmpty()) {
      return Collections.emptyList();
    }
    return heroList.stream().map(heroRestResponseConverter::apply).collect(Collectors.toList());
  }
}
