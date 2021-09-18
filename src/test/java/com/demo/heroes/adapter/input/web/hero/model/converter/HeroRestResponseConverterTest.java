package com.demo.heroes.adapter.input.web.hero.model.converter;

import com.demo.heroes.adapter.input.web.hero.model.response.HeroRestResponse;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.HeroMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HeroRestResponseConverterTest {

  private Function<Hero, HeroRestResponse> heroRestResponseConverter;

  @Before
  public void before() {
    heroRestResponseConverter = new HeroRestResponseConverter();
  }

  @Test
  public void buildNullHeroRestResponseConverter() {
    HeroRestResponse heroRestResponse;
    heroRestResponse = heroRestResponseConverter.apply(null);
    assertThat(heroRestResponse).isNull();
  }

  @Test
  public void convertHeroRestResponse() {
    Hero hero = HeroMock.getMock();
    HeroRestResponse heroRestResponse = heroRestResponseConverter.apply(hero);
    assertThat(heroRestResponse).isNotNull();
  }
}
