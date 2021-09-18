package com.demo.heroes.adapter.output.h2.specification;

import com.demo.heroes.adapter.output.h2.entity.HeroEntity;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class HeroJpaSpecification {

  public Specification<HeroEntity> obtainSpecification(PagedHeroesRequest pagedHeroesRequest) {
    return (root, query, criteriaBuilder) -> Objects.requireNonNull(
      Specification.where(this.findByEnabled()).and(findBySearch(pagedHeroesRequest))
        .toPredicate(root, query, criteriaBuilder)
    );
  }

  private Specification<HeroEntity> findByEnabled() {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("enabled"), Boolean.TRUE);
  }

  private Specification<HeroEntity> findBySearch(PagedHeroesRequest pagedHeroesRequest) {
    List<Predicate> queryPredicates = new ArrayList<>();
    return (root, query, criteriaBuilder) -> {
      if (StringUtils.isBlank(pagedHeroesRequest.getSearch())) {
        return null;
      }
      queryPredicates.add(criteriaBuilder.like(root.get("nickname"),
          "%" + pagedHeroesRequest.getSearch().trim().toUpperCase() + "%"));
      return criteriaBuilder.or(queryPredicates.toArray(new Predicate[0]));
    };
  }

}
