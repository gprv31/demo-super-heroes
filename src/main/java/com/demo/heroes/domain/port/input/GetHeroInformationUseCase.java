package com.demo.heroes.domain.port.input;

import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import io.reactivex.Single;

public interface GetHeroInformationUseCase {

  Single<PagedHeroesResponse> getHeroes(PagedHeroesRequest pagedHeroesRequest);

  Single<Hero> getHeroById(Long id);

}
