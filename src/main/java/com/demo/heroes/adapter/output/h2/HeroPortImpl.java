package com.demo.heroes.adapter.output.h2;

import com.demo.heroes.adapter.output.h2.entity.HeroEntity;
import com.demo.heroes.adapter.output.h2.repository.HeroRepository;
import com.demo.heroes.adapter.output.h2.specification.HeroJpaSpecification;
import com.demo.heroes.domain.port.output.HeroPort;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.request.HeroEditRequest;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.time.LocalDateTime;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Slf4j
@RequiredArgsConstructor
public class HeroPortImpl implements HeroPort {

  private final HeroRepository heroRepository;
  private final Function<Page<HeroEntity>, PagedHeroesResponse> pagedHeroesResponseConverter;
  private final Function<HeroEntity, Hero> heroConverter;
  private final HeroJpaSpecification heroJpaSpecification;

  @Override
  public Single<PagedHeroesResponse> getAllHeroes(PagedHeroesRequest pagedHeroesRequest) {
    log.info("Starting HeroPortImpl.getHeroes method");
    return Single.fromCallable(() -> {
      Page<HeroEntity> heroEntityPage = heroRepository.findAll(
          heroJpaSpecification.obtainSpecification(pagedHeroesRequest),
          PageRequest.of(pagedHeroesRequest.getCurrentPage() - 1, pagedHeroesRequest.getPageSize()));
      return pagedHeroesResponseConverter.apply(heroEntityPage);
    });
  }

  @Override
  public Single<Hero> getHeroById(Long id) {
    log.info("Starting HeroPortImpl.getHeroById method");
    return Single.fromCallable(() -> {
      HeroEntity heroEntity = heroRepository.findByIdAndEnabled(id, Boolean.TRUE).orElseThrow();
      return heroConverter.apply(heroEntity);
    });
  }

  @Override
  public Completable deleteHeroById(Long id) {
    log.info("Starting HeroPortImpl.deleteHeroById method");
    return Completable.fromAction(() -> heroRepository.deleteById(id));
  }

  @Override
  public Single<Hero> modifyHeroById(HeroEditRequest heroEditRequest) {
    log.info("Starting HeroPortImpl.modifyHeroById method");
    return Single.fromCallable(() -> {
      HeroEntity heroEntity = heroRepository.findByIdAndEnabled(heroEditRequest.getId(), Boolean.TRUE).orElseThrow();
      heroEntity.setNickname(heroEditRequest.getNickname().toUpperCase());
      heroEntity.setUpdateDate(LocalDateTime.now());
      heroEntity.setUpdatedBy("WEB");
      heroRepository.save(heroEntity);
      return heroConverter.apply(heroEntity);
    });
  }
}
