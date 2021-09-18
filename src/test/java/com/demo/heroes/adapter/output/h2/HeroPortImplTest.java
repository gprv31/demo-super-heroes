package com.demo.heroes.adapter.output.h2;

import com.demo.heroes.adapter.output.h2.entity.HeroEntity;
import com.demo.heroes.adapter.output.h2.entity.HeroEntityMock;
import com.demo.heroes.adapter.output.h2.repository.HeroRepository;
import com.demo.heroes.adapter.output.h2.specification.HeroJpaSpecification;
import com.demo.heroes.domain.port.output.HeroPort;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.HeroMock;
import com.demo.heroes.entity.hero.request.HeroEditRequestMock;
import com.demo.heroes.entity.hero.request.PagedHeroesRequestMock;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import com.demo.heroes.entity.hero.response.PagedHeroesResponseMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HeroPortImplTest {

  private HeroPort heroPort;

  @Mock
  private HeroRepository heroRepository;

  @Mock
  private Function<Page<HeroEntity>, PagedHeroesResponse> pagedHeroesResponseConverter;

  @Mock
  private Function<HeroEntity, Hero> heroConverter;

  @Mock
  private HeroJpaSpecification heroJpaSpecification;


  @Before
  public void init() {
    heroPort = new HeroPortImpl(heroRepository, pagedHeroesResponseConverter, heroConverter, heroJpaSpecification);
  }

  @Test
  public void getAllHeroesTest() {
    Specification<HeroEntity> heroEntitySpecification =
        (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("enabled"), Boolean.TRUE);

    when(pagedHeroesResponseConverter.apply(any())).thenReturn(PagedHeroesResponseMock.getMock());
    when(heroRepository.findAll(heroEntitySpecification))
        .thenReturn(Collections.singletonList(HeroEntityMock.getMock()));

    heroPort.getAllHeroes(PagedHeroesRequestMock.getMock())
      .test()
      .assertNoErrors()
      .assertComplete()
      .dispose();
  }


  @Test
  public void getHeroById() {
    Long heroId = 1L;

    when(heroRepository.findByIdAndEnabled(any(), any())).thenReturn(Optional.of(HeroEntityMock.getMock()));
    when(heroConverter.apply(any())).thenReturn(HeroMock.getMock());

    heroPort.getHeroById(heroId)
      .test()
      .assertNoErrors()
      .assertComplete()
      .dispose();
  }

  @Test
  public void deleteHeroById() {
    Long heroId = 1L;
    heroPort.deleteHeroById(heroId)
      .test()
      .assertNoErrors()
      .assertComplete()
      .dispose();
  }

  @Test
  public void modifyHeroById() {
    when(heroRepository.findByIdAndEnabled(any(), any())).thenReturn(Optional.of(HeroEntityMock.getMock()));
    when(heroConverter.apply(any())).thenReturn(HeroMock.getMock());

    heroPort.modifyHeroById(HeroEditRequestMock.getMock())
      .test()
      .assertNoErrors()
      .assertComplete()
      .dispose();
  }
}
