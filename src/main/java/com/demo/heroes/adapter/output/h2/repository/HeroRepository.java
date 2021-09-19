package com.demo.heroes.adapter.output.h2.repository;

import com.demo.heroes.adapter.output.h2.entity.HeroEntity;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<HeroEntity, Long>, JpaSpecificationExecutor<HeroEntity> {

  Optional<HeroEntity> findByIdAndEnabled(Long id, Boolean enabled);
}
