package com.demo.heroes.application.configuration;

import com.demo.heroes.adapter.input.web.common.converter.PageRestResponseConverter;
import com.demo.heroes.adapter.input.web.common.model.PageRestResponse;
import com.demo.heroes.adapter.input.web.hero.model.converter.HeroEditRequestConverter;
import com.demo.heroes.adapter.input.web.hero.model.converter.HeroRestResponseConverter;
import com.demo.heroes.adapter.input.web.hero.model.converter.PagedHeroesRequestConverter;
import com.demo.heroes.adapter.input.web.hero.model.converter.PagedHeroesRestResponseConverter;
import com.demo.heroes.adapter.input.web.hero.model.request.HeroEditRestRequest;
import com.demo.heroes.adapter.input.web.hero.model.request.PagedHeroesRestRequest;
import com.demo.heroes.adapter.input.web.hero.model.response.HeroRestResponse;
import com.demo.heroes.adapter.input.web.hero.model.response.PagedHeroesRestResponse;
import com.demo.heroes.adapter.output.h2.UserAuthDetailsImpl;
import com.demo.heroes.domain.interactor.GetHeroInformationUseCaseImpl;
import com.demo.heroes.domain.interactor.GetUserInformationUseCaseImpl;
import com.demo.heroes.domain.interactor.ModifyHeroInformationUseCaseImpl;
import com.demo.heroes.domain.port.input.GetHeroInformationUseCase;
import com.demo.heroes.domain.port.input.GetUserInformationUseCase;
import com.demo.heroes.domain.port.input.ModifyHeroInformationUseCase;
import com.demo.heroes.domain.port.output.HeroPort;
import com.demo.heroes.entity.common.response.PageResponse;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.request.HeroEditRequest;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ControllerConfiguration {

  /* UseCase Beans Injection */

  @Bean
  public GetUserInformationUseCase getUserInformationUseCase(UserAuthDetailsImpl userAuthDetails) {
    return new GetUserInformationUseCaseImpl(userAuthDetails);
  }

  @Bean
  public GetHeroInformationUseCase getHeroInformationUseCase(HeroPort heroPort) {
    return new GetHeroInformationUseCaseImpl(heroPort);
  }

  @Bean
  public ModifyHeroInformationUseCase modifyHeroInformationUseCase(HeroPort heroPort) {
    return new ModifyHeroInformationUseCaseImpl(heroPort);
  }

  /* Request Converter Beans Injection */

  @Bean
  public Function<PagedHeroesRestRequest, PagedHeroesRequest> pagedHeroesRequestConverter() {
    return new PagedHeroesRequestConverter();
  }

  @Bean
  public Function<HeroEditRestRequest, HeroEditRequest> heroEditRequestConverter() {
    return new HeroEditRequestConverter();
  }

  /* Response Converter Beans Injection */

  @Bean
  public Function<PagedHeroesResponse, PagedHeroesRestResponse> pagedHeroesRestResponseConverter(
      Function<PageResponse, PageRestResponse> pageRestResponseConverter,
      Function<Hero, HeroRestResponse> heroRestResponseConverter) {
    return new PagedHeroesRestResponseConverter(pageRestResponseConverter, heroRestResponseConverter);
  }

  @Bean
  public Function<PageResponse, PageRestResponse> pageRestResponseConverter() {
    return new PageRestResponseConverter();
  }

  @Bean
  public Function<Hero, HeroRestResponse> heroRestResponseConverter() {
    return new HeroRestResponseConverter();
  }

}
