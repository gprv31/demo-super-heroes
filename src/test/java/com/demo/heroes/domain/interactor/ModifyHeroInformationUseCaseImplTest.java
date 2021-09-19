package com.demo.heroes.domain.interactor;

import com.demo.heroes.domain.port.input.ModifyHeroInformationUseCase;
import com.demo.heroes.domain.port.output.HeroPort;
import com.demo.heroes.entity.hero.HeroMock;
import com.demo.heroes.entity.hero.request.HeroEditRequestMock;
import io.reactivex.Completable;
import io.reactivex.Single;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ModifyHeroInformationUseCaseImplTest {

  private ModifyHeroInformationUseCase modifyHeroInformationUseCase;

  @Mock
  private HeroPort heroPort;

  @Before
  public void before() {
    modifyHeroInformationUseCase = new ModifyHeroInformationUseCaseImpl(heroPort);
  }


  @Test
  public void modifyHeroByIdTest() {
    when(heroPort.modifyHeroById(any())).thenReturn(Single.just(HeroMock.getMock()));

    modifyHeroInformationUseCase.modifyHeroById(HeroEditRequestMock.getMock())
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }

  @Test
  public void deleteHeroByIdTest() {
    Long heroId = 1L;
    when(heroPort.deleteHeroById(any())).thenReturn(Completable.complete());

    modifyHeroInformationUseCase.deleteHeroById(heroId)
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }

}
