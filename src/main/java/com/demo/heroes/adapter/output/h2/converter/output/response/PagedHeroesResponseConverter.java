package com.demo.heroes.adapter.output.h2.converter.output.response;

import com.demo.heroes.adapter.output.h2.entity.HeroEntity;
import com.demo.heroes.entity.common.response.PageResponse;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class PagedHeroesResponseConverter implements Function<Page<HeroEntity>, PagedHeroesResponse> {

  private final Function<HeroEntity, Hero> heroConverter;

  @Override
  public PagedHeroesResponse apply(Page<HeroEntity> heroEntities) {
    if (heroEntities == null) {
      return null;
    }
    return PagedHeroesResponse.builder()
             .page(this.buildPageResponseConverterWrapper(heroEntities))
             .heroList(this.buildHeroes(heroEntities))
             .build();
  }

  private PageResponse buildPageResponseConverterWrapper(Page<HeroEntity> heroEntities) {
    if (heroEntities == null) {
      return null;
    }
    return PageResponse.builder()
             .totalNumberOfItems(heroEntities.getTotalElements())
             .numberOfPages(heroEntities.getTotalPages())
             .build();
  }

  private List<Hero> buildHeroes(Page<HeroEntity> heroEntityPageList) {
    if (heroEntityPageList == null || heroEntityPageList.isEmpty()) {
      return Collections.emptyList();
    }
    return heroEntityPageList.get()
             .map(heroConverter::apply)
             .collect(Collectors.toList());
  }
}
