package com.demo.heroes.adapter.input.web.hero.model.converter;

import com.demo.heroes.adapter.input.web.common.model.PageRestResponse;
import com.demo.heroes.adapter.input.web.hero.model.response.HeroRestResponse;
import com.demo.heroes.adapter.input.web.hero.model.response.PagedHeroesRestResponse;
import com.demo.heroes.entity.common.response.PageResponse;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import com.demo.heroes.entity.hero.response.PagedHeroesResponseMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PagedHeroesRestResponseConverterTest {

  private Function<PagedHeroesResponse, PagedHeroesRestResponse> pagedHeroesRestResponseConverter;

  @Mock
  private Function<PageResponse, PageRestResponse> pageRestResponseConverter;

  @Mock
  private Function<Hero, HeroRestResponse> heroRestResponseConverter;

  @Before
  public void before() {
    pagedHeroesRestResponseConverter = new PagedHeroesRestResponseConverter(pageRestResponseConverter,
        heroRestResponseConverter);
  }

  @Test
  public void buildNullPagedHeroesRestResponseConverter() {
    PagedHeroesRestResponse pagedHeroesRestResponse;
    pagedHeroesRestResponse = pagedHeroesRestResponseConverter.apply(null);
    assertThat(pagedHeroesRestResponse).isNull();
  }

  @Test
  public void convertPagedHeroesRestResponse() {
    PagedHeroesResponse pagedHeroesResponse = PagedHeroesResponseMock.getMock();
    PagedHeroesRestResponse pagedHeroesRestResponse = pagedHeroesRestResponseConverter.apply(pagedHeroesResponse);
    assertThat(pagedHeroesRestResponse).isNotNull();
  }
}
