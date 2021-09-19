package com.demo.heroes.adapter.input.web.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PageRestResponse {

  @Schema(description = "Total number of items", example = "120")
  private Long totalNumberOfItems;

  @Schema(description = "Number of pages", example = "10")
  private Integer numberOfPages;
}
