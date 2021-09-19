package com.demo.heroes.adapter.input.web.hero.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HeroRestResponse {

  @Schema(description = "Hero identifier")
  private Long id;

  @Schema(description = "Nickname of Hero", example = "Batman")
  private String nickname;
}
