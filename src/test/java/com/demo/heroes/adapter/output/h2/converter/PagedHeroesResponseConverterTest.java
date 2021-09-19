package com.demo.heroes.adapter.output.h2.converter;

import com.demo.heroes.adapter.output.h2.converter.output.response.PagedHeroesResponseConverter;
import com.demo.heroes.adapter.output.h2.entity.HeroEntity;
import com.demo.heroes.adapter.output.h2.entity.HeroEntityMock;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PagedHeroesResponseConverterTest {

  private Function<Page<HeroEntity>, PagedHeroesResponse> pagedHeroesResponseConverter;

  @Mock
  private Function<HeroEntity, Hero> heroConverter;


  @Before
  public void before() {
    pagedHeroesResponseConverter = new PagedHeroesResponseConverter(heroConverter);
  }

  @Test
  public void buildNullPagedHeroesResponseConverter() {
    PagedHeroesResponse pagedHeroesResponse;
    pagedHeroesResponse = pagedHeroesResponseConverter.apply(null);
    assertThat(pagedHeroesResponse).isNull();
  }

  @Test
  public void convertHeroRestResponse() {
    Page<HeroEntity> page = new PageImpl<>(Collections.singletonList(HeroEntityMock.getMock()));
    PagedHeroesResponse pagedHeroesResponse = pagedHeroesResponseConverter.apply(page);
    assertThat(pagedHeroesResponse).isNotNull();
  }

}
