package com.demo.heroes.entity.hero.request;

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
public class PagedHeroesRequest {

  private String search;
  private Integer currentPage;
  private Integer pageSize;
}
