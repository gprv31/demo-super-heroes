package com.demo.heroes.entity.common;

import com.demo.heroes.entity.common.response.PageResponse;

public class PageResponseMock {

  public static PageResponse getMock() {
    return PageResponse.builder()
             .numberOfPages(3)
             .totalNumberOfItems(15L)
             .build();
  }
}
