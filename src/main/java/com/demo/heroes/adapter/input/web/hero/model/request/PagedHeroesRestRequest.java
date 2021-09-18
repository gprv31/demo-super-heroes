package com.demo.heroes.adapter.input.web.hero.model.request;

import com.demo.heroes.adapter.input.web.hero.validators.NumberValid;
import com.demo.heroes.adapter.input.web.hero.validators.NameValid;
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
public class PagedHeroesRestRequest {

  @NameValid
  @Schema(description = "Search by name", example = "Superman", required = true, type = "string")
  private String search;

  @NumberValid
  @Schema(description = "Current page", example = "1", required = true, type = "integer",
    format = "int32", minimum = "1")
  private String currentPage;

  @NumberValid
  @Schema(description = "Page size", example = "25", required = true, type = "integer",
    format = "int32", minimum = "1")
  private String pageSize;
}
