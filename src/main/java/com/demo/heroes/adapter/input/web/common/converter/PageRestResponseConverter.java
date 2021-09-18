package com.demo.heroes.adapter.input.web.common.converter;

import com.demo.heroes.adapter.input.web.common.model.PageRestResponse;
import com.demo.heroes.entity.common.response.PageResponse;

import java.util.function.Function;

public class PageRestResponseConverter implements Function<PageResponse, PageRestResponse> {

  @Override
  public PageRestResponse apply(PageResponse pageResponse) {
    if (pageResponse == null) {
      return null;
    }
    return PageRestResponse.builder()
             .totalNumberOfItems(pageResponse.getTotalNumberOfItems())
             .numberOfPages(pageResponse.getNumberOfPages())
             .build();
  }
}
