package com.demo.heroes.domain.port.input;

import io.reactivex.Single;
import org.springframework.security.core.userdetails.UserDetails;

public interface GetUserInformationUseCase {

  Single<UserDetails> loadUserByUsername(String username);
}
