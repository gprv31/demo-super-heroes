package com.demo.heroes.domain.port.input;

import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.request.HeroEditRequest;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface ModifyHeroInformationUseCase {

  Completable deleteHeroById(Long id);

  Single<Hero> modifyHeroById(HeroEditRequest heroEditRequest);
}
