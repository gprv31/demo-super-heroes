package com.demo.heroes.adapter.input.web.common;

import com.demo.heroes.adapter.input.web.common.model.PageRestResponse;

public class PageRestResponseMock {

  public static PageRestResponse getMock() {
    return PageRestResponse.builder()
             .numberOfPages(1)
             .totalNumberOfItems(15L)
             .build();
  }
}
