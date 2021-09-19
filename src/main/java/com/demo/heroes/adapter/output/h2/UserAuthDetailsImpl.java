package com.demo.heroes.adapter.output.h2;

import com.demo.heroes.adapter.output.h2.entity.UserEntity;
import com.demo.heroes.adapter.output.h2.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
@RequiredArgsConstructor
public class UserAuthDetailsImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findByUsername(username)
                  .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
    return new org.springframework.security.core.userdetails.User(
      userEntity.getUsername(), userEntity.getPassword(), getAuthority());
  }

  private List<SimpleGrantedAuthority> getAuthority() {
    return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
  }
}
