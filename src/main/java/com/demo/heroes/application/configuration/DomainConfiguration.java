package com.demo.heroes.application.configuration;

import com.demo.heroes.adapter.output.h2.HeroPortImpl;
import com.demo.heroes.adapter.output.h2.UserAuthDetailsImpl;
import com.demo.heroes.adapter.output.h2.converter.HeroConverter;
import com.demo.heroes.adapter.output.h2.converter.output.response.PagedHeroesResponseConverter;
import com.demo.heroes.adapter.output.h2.entity.HeroEntity;
import com.demo.heroes.adapter.output.h2.repository.HeroRepository;
import com.demo.heroes.adapter.output.h2.repository.UserRepository;
import com.demo.heroes.adapter.output.h2.specification.HeroJpaSpecification;
import com.demo.heroes.domain.port.output.HeroPort;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import lombok.extern.slf4j.Slf4j;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

@Slf4j
@Configuration
public class DomainConfiguration {

  /* Output Converter Beans Injection */
  @Bean
  public Function<Page<HeroEntity>, PagedHeroesResponse> pagedHeroesResponseConverter(
      Function<HeroEntity, Hero> heroConverter) {
    return new PagedHeroesResponseConverter(heroConverter);
  }

  @Bean
  public Function<HeroEntity, Hero> heroConverter() {
    return new HeroConverter();
  }

  /* Jpa Specification Beans Injection */

  @Bean
  public HeroJpaSpecification heroJpaSpecification() {
    return new HeroJpaSpecification();
  }


  /* Port Beans Injection */

  @Bean
  public UserAuthDetailsImpl userDetailsService(UserRepository userRepository) {
    return new UserAuthDetailsImpl(userRepository);
  }

  @Bean
  public HeroPort heroPort(HeroRepository heroRepository,
                           Function<Page<HeroEntity>, PagedHeroesResponse> pagedHeroesResponseConverter,
                           Function<HeroEntity, Hero> heroConverter,
                           HeroJpaSpecification heroJpaSpecification) {
    return new HeroPortImpl(heroRepository, pagedHeroesResponseConverter, heroConverter, heroJpaSpecification);
  }

}
