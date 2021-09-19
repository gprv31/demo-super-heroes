package com.demo.heroes.domain.interactor;

import com.demo.heroes.adapter.output.h2.UserAuthDetailsImpl;
import com.demo.heroes.domain.port.input.GetUserInformationUseCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GetUserInformationUseCaseImplTest {

  private GetUserInformationUseCase getUserInformationUseCase;

  @Mock
  private UserAuthDetailsImpl userAuthDetails;

  @Before
  public void before() {
    getUserInformationUseCase = new GetUserInformationUseCaseImpl(userAuthDetails);
  }

  @Test
  public void loadUserByUsernameTest() {
    String username = "admin";
    when(userAuthDetails.loadUserByUsername(any())).thenReturn(getUserDetails());

    getUserInformationUseCase.loadUserByUsername(username)
      .test()
      .assertComplete()
      .assertNoErrors()
      .dispose();
  }

  private UserDetails getUserDetails() {
    return new UserDetails() {
      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
      }

      @Override
      public String getPassword() {
        return "admin";
      }

      @Override
      public String getUsername() {
        return "admin";
      }

      @Override
      public boolean isAccountNonExpired() {
        return false;
      }

      @Override
      public boolean isAccountNonLocked() {
        return false;
      }

      @Override
      public boolean isCredentialsNonExpired() {
        return false;
      }

      @Override
      public boolean isEnabled() {
        return true;
      }
    };
  }
}
