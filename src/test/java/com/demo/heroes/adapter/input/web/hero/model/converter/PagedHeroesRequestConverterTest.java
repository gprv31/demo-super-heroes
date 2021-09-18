package com.demo.heroes.adapter.input.web.hero.model.converter;

import com.demo.heroes.adapter.input.web.hero.model.request.PagedHeroesRestRequest;
import com.demo.heroes.adapter.input.web.hero.model.request.PagedHeroesRestRequestMock;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PagedHeroesRequestConverterTest {

  private Function<PagedHeroesRestRequest, PagedHeroesRequest> pagedHeroesRequestConverter;

  @Before
  public void before() {
    pagedHeroesRequestConverter = new PagedHeroesRequestConverter();
  }

  @Test
  public void buildNullPagedHeroesRequestConverter() {
    PagedHeroesRequest pagedHeroesRequest;
    pagedHeroesRequest = pagedHeroesRequestConverter.apply(null);
    assertThat(pagedHeroesRequest).isNull();
  }

  @Test
  public void convertPagedHeroesRequest() {
    PagedHeroesRestRequest pagedHeroesRestRequest = PagedHeroesRestRequestMock.getMock();
    PagedHeroesRequest pagedHeroesRequest = pagedHeroesRequestConverter.apply(pagedHeroesRestRequest);
    assertThat(pagedHeroesRequest).isNotNull();
  }
}
