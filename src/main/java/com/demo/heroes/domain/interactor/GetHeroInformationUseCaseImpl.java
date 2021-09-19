package com.demo.heroes.domain.interactor;

import com.demo.heroes.domain.port.input.GetHeroInformationUseCase;
import com.demo.heroes.domain.port.output.HeroPort;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GetHeroInformationUseCaseImpl implements GetHeroInformationUseCase {

  private final HeroPort heroPort;

  @Override
  public Single<PagedHeroesResponse> getHeroes(PagedHeroesRequest pagedHeroesRequest) {
    log.info("Starting GetHeroInformationUseCaseImpl.getHeroes method");
    return heroPort.getAllHeroes(pagedHeroesRequest)
        .doOnSuccess(i -> log.info("Finished GetHeroInformationUseCaseImpl.getHeroes method successfully"))
        .doOnError(e -> log.error("Finished GetHeroInformationUseCaseImpl.getHeroes method with error", e));
  }

  @Override
  public Single<Hero> getHeroById(Long id) {
    log.info("Starting GetHeroInformationUseCaseImpl.getHeroById method");
    return heroPort.getHeroById(id)
        .doOnSuccess(i -> log.info("Finished GetHeroInformationUseCaseImpl.getHeroById method successfully"))
        .doOnError(e -> log.error("Finished GetHeroInformationUseCaseImpl.getHeroById method with error", e));
  }
}
