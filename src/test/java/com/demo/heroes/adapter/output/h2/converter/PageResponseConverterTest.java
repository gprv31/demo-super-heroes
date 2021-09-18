package com.demo.heroes.adapter.output.h2.converter;

import com.demo.heroes.adapter.output.h2.converter.output.response.PageResponseConverter;
import com.demo.heroes.entity.common.response.PageResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PageResponseConverterTest {

  private Function<PageResponseConverter.Wrapper, PageResponse> pageResponseConverter;

  @Before
  public void before() {
    pageResponseConverter = new PageResponseConverter();
  }

  @Test
  public void buildNullPageResponseConverter() {
    PageResponse pageResponse;
    pageResponse = pageResponseConverter.apply(null);
    assertThat(pageResponse).isNull();
  }

  @Test
  public void convertPageResponse() {
    PageResponse pageResponse;
    pageResponse = pageResponseConverter.apply(PageResponseConverter.Wrapper.builder()
                                                 .totalElements(1L)
                                                 .totalPages(1)
                                                 .build());

    assertThat(pageResponse).isNotNull();
  }
}

