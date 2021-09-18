package com.demo.heroes.adapter.input.web.hero.model.converter;

import com.demo.heroes.adapter.input.web.hero.model.request.HeroEditRestRequest;
import com.demo.heroes.adapter.input.web.hero.model.request.HeroEditRestRequestMock;
import com.demo.heroes.entity.hero.request.HeroEditRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HeroEditRequestConverterTest {

  private Function<HeroEditRestRequest, HeroEditRequest> heroEditRequestConverter;

  @Before
  public void before() {
    heroEditRequestConverter = new HeroEditRequestConverter();
  }

  @Test
  public void buildNullHeroEditRequestConverter() {
    HeroEditRequest heroEditRequest;
    heroEditRequest = heroEditRequestConverter.apply(null);
    assertThat(heroEditRequest).isNull();
  }

  @Test
  public void convertHeroEditRequest() {
    HeroEditRestRequest heroEditRestRequest = HeroEditRestRequestMock.getMock();
    HeroEditRequest heroEditRequest = heroEditRequestConverter.apply(heroEditRestRequest);
    assertThat(heroEditRequest).isNotNull();
  }
}
