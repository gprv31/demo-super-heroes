package com.demo.heroes.domain.interactor;

import com.demo.heroes.domain.port.input.ModifyHeroInformationUseCase;
import com.demo.heroes.domain.port.output.HeroPort;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.request.HeroEditRequest;
import io.reactivex.Completable;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ModifyHeroInformationUseCaseImpl implements ModifyHeroInformationUseCase {

  private final HeroPort heroPort;

  @Override
  public Completable deleteHeroById(Long id) {
    log.info("Starting ModifyHeroInformationUseCaseImpl.deleteHeroById method");
    return heroPort.deleteHeroById(id)
        .doOnComplete(() -> log.info("Finished ModifyHeroInformationUseCaseImpl.deleteHeroById method successfully"))
        .doOnError(e -> log.error("Finished ModifyHeroInformationUseCaseImpl.deleteHeroById method with error", e));
  }

  @Override
  public Single<Hero> modifyHeroById(HeroEditRequest heroEditRequest) {
    return heroPort.modifyHeroById(heroEditRequest)
        .doOnSuccess(i -> log.info("Finished ModifyHeroInformationUseCaseImpl.modifyHeroById method successfully"))
        .doOnError(e -> log.error("Finished ModifyHeroInformationUseCaseImpl.modifyHeroById method with error", e));
  }
}
