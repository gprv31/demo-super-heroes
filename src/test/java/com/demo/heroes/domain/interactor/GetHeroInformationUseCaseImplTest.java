package com.demo.heroes.domain.interactor;

import com.demo.heroes.domain.port.input.GetHeroInformationUseCase;
import com.demo.heroes.domain.port.output.HeroPort;
import com.demo.heroes.entity.hero.HeroMock;
import com.demo.heroes.entity.hero.request.PagedHeroesRequestMock;
import com.demo.heroes.entity.hero.response.PagedHeroesResponseMock;
import io.reactivex.Single;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GetHeroInformationUseCaseImplTest {

  private GetHeroInformationUseCase getHeroInformationUseCase;

  @Mock
  private HeroPort heroPort;

  @Before
  public void before() {
    getHeroInformationUseCase = new GetHeroInformationUseCaseImpl(heroPort);
  }

  @Test
  public void getHeroByIdTest() {
    Long heroId = 1L;
    when(heroPort.getHeroById(any())).thenReturn(Single.just(HeroMock.getMock()));

    getHeroInformationUseCase.getHeroById(heroId)
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }

  @Test
  public void getHeroesTest() {
    when(heroPort.getAllHeroes(any())).thenReturn(Single.just(PagedHeroesResponseMock.getMock()));

    getHeroInformationUseCase.getHeroes(PagedHeroesRequestMock.getMock())
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }
}
