package com.demo.heroes.entity.hero.response;

import com.demo.heroes.entity.common.response.PageResponse;
import com.demo.heroes.entity.hero.Hero;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagedHeroesResponse {

  private PageResponse page;
  private List<Hero> heroList;
}
