package com.demo.heroes.adapter.output.h2.repository;

import com.demo.heroes.adapter.output.h2.entity.UserEntity;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByUsername(String username);
}
