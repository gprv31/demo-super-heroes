package com.demo.heroes.adapter.input.web.hero.model.request;

import com.demo.heroes.adapter.input.web.hero.validators.NameValid;
import com.demo.heroes.adapter.input.web.hero.validators.NumberValid;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class HeroEditRestRequest {

  @NumberValid
  @Schema(description = "Hero identifier", example = "1", required = true, type = "integer",
    format = "int32", minimum = "1")
  private String id;

  @NameValid(required = true)
  @Schema(description = "Search by name", example = "Superman", required = true, type = "string")
  private String nickname;
}
