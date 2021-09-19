package com.demo.heroes.adapter.input.web.common.converter;

import com.demo.heroes.adapter.input.web.common.model.PageRestResponse;
import com.demo.heroes.entity.common.PageResponseMock;
import com.demo.heroes.entity.common.response.PageResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PageRestResponseConverterTest {

  private Function<PageResponse, PageRestResponse> pageRestResponseConverter;

  @Before
  public void before() {
    pageRestResponseConverter = new PageRestResponseConverter();
  }


  @Test
  public void buildNullPageRestResponseConverter() {
    PageRestResponse pageRestResponse;
    pageRestResponse = pageRestResponseConverter.apply(null);
    assertThat(pageRestResponse).isNull();
  }

  @Test
  public void convertPageRestResponse() {
    PageResponse pageResponse = PageResponseMock.getMock();
    PageRestResponse pageRestResponse = pageRestResponseConverter.apply(pageResponse);
    assertThat(pageRestResponse).isNotNull();
  }
}
