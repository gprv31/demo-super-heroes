package com.demo.heroes.adapter.input.web.hero;

import com.demo.heroes.adapter.input.web.hero.model.request.HeroEditRestRequestMock;
import com.demo.heroes.adapter.input.web.hero.model.response.HeroRestResponseMock;
import com.demo.heroes.adapter.input.web.hero.model.request.PagedHeroesRestRequestMock;
import com.demo.heroes.adapter.input.web.hero.model.response.PagedHeroesRestResponseMock;
import com.demo.heroes.adapter.input.web.hero.model.request.HeroEditRestRequest;
import com.demo.heroes.adapter.input.web.hero.model.request.PagedHeroesRestRequest;
import com.demo.heroes.adapter.input.web.hero.model.response.HeroRestResponse;
import com.demo.heroes.adapter.input.web.hero.model.response.PagedHeroesRestResponse;
import com.demo.heroes.domain.port.input.GetHeroInformationUseCase;
import com.demo.heroes.domain.port.input.ModifyHeroInformationUseCase;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.HeroMock;
import com.demo.heroes.entity.hero.request.HeroEditRequestMock;
import com.demo.heroes.entity.hero.request.PagedHeroesRequestMock;
import com.demo.heroes.entity.hero.request.HeroEditRequest;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import com.demo.heroes.entity.hero.response.PagedHeroesResponseMock;
import io.reactivex.Completable;
import io.reactivex.Single;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.DataBinder;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HeroesControllerTest {

  private HeroesController heroesController;

  @Mock
  private GetHeroInformationUseCase getHeroInformationUseCase;

  @Mock
  private ModifyHeroInformationUseCase modifyHeroInformationUseCase;


  @Mock
  private Function<PagedHeroesRestRequest, PagedHeroesRequest> pagedHeroesRequestConverter;

  @Mock
  private Function<HeroEditRestRequest, HeroEditRequest> heroEditRequestConverter;


  @Mock
  private Function<PagedHeroesResponse, PagedHeroesRestResponse> pagedHeroesRestResponseConverter;

  @Mock
  private Function<Hero, HeroRestResponse> heroRestResponseConverter;

  @Before
  public void before() {
    heroesController = new HeroesController(getHeroInformationUseCase, modifyHeroInformationUseCase,
        pagedHeroesRequestConverter, heroEditRequestConverter, pagedHeroesRestResponseConverter,
        heroRestResponseConverter);
  }


  @Test
  public void initBinderTest() {
    assertThat(heroesController).isNotNull();
    heroesController.initBinder(new DataBinder(null));
  }

  @Test
  public void getHeroesTest() {
    when(pagedHeroesRequestConverter.apply(any())).thenReturn(PagedHeroesRequestMock.getMock());
    when(getHeroInformationUseCase.getHeroes(any())).thenReturn(Single.just(PagedHeroesResponseMock.getMock()));
    when(pagedHeroesRestResponseConverter.apply(any())).thenReturn(PagedHeroesRestResponseMock.getMock());

    heroesController.getHeroes(PagedHeroesRestRequestMock.getMock())
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }

  @Test
  public void getHeroByIdTest() {
    String heroId = "1";
    when(getHeroInformationUseCase.getHeroById(any())).thenReturn(Single.just(HeroMock.getMock()));
    when(heroRestResponseConverter.apply(any())).thenReturn(HeroRestResponseMock.getMock());

    heroesController.getHeroById(heroId)
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }

  @Test
  public void modifyHeroByIdTest() {
    when(heroEditRequestConverter.apply(any())).thenReturn(HeroEditRequestMock.getMock());
    when(modifyHeroInformationUseCase.modifyHeroById(any())).thenReturn(Single.just(HeroMock.getMock()));
    when(heroRestResponseConverter.apply(any())).thenReturn(HeroRestResponseMock.getMock());

    heroesController.modifyHeroById(HeroEditRestRequestMock.getMock())
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }

  @Test
  public void deleteHeroByIdTest() {
    String heroId = "1";
    when(modifyHeroInformationUseCase.deleteHeroById(any())).thenReturn(Completable.complete());
    when(heroRestResponseConverter.apply(any())).thenReturn(HeroRestResponseMock.getMock());

    heroesController.deleteHeroById(heroId)
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }
}
