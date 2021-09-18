package com.demo.heroes.domain.port.output;

import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.request.HeroEditRequest;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface HeroPort {

  Single<PagedHeroesResponse> getAllHeroes(PagedHeroesRequest pagedHeroesRequest);

  Single<Hero> getHeroById(Long id);

  Completable deleteHeroById(Long id);

  Single<Hero> modifyHeroById(HeroEditRequest heroEditRequest);
}
