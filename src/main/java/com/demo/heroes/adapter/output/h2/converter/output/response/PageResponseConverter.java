package com.demo.heroes.adapter.output.h2.converter.output.response;

import com.demo.heroes.entity.common.response.PageResponse;
import java.util.function.Function;

import lombok.Builder;
import lombok.Data;

public class PageResponseConverter implements Function<PageResponseConverter.Wrapper, PageResponse> {
  @Override
  public PageResponse apply(Wrapper wrapper) {
    if (wrapper == null) {
      return null;
    }
    return PageResponse.builder()
             .totalNumberOfItems(wrapper.totalElements)
             .numberOfPages(wrapper.totalPages)
             .build();
  }

  /**
   * Wrapper class.
   */
  @Data
  @Builder
  public static class Wrapper {

    private Long totalElements;
    private Integer totalPages;
  }
}
