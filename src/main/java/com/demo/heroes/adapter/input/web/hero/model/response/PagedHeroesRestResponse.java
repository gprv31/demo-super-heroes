package com.demo.heroes.adapter.input.web.hero.model.response;

import com.demo.heroes.adapter.input.web.common.model.PageRestResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagedHeroesRestResponse {

  @Schema(description = "Object Page")
  private PageRestResponse page;

  @Schema(description = "List of Heroes")
  private List<HeroRestResponse> heroList;
}
