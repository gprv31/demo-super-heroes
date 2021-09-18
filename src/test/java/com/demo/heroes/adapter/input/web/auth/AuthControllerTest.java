package com.demo.heroes.adapter.input.web.auth;

import com.demo.heroes.adapter.input.web.auth.request.JwtRestRequestMock;
import com.demo.heroes.application.security.JwtToken;
import com.demo.heroes.domain.port.input.GetUserInformationUseCase;
import io.reactivex.Single;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AuthControllerTest {

  private AuthController authController;

  @Mock
  private AuthenticationManager authenticationManager;

  @Mock
  private JwtToken jwtToken;

  @Mock
  private GetUserInformationUseCase getUserInformationUseCase;

  @Before
  public void before() {
    authController = new AuthController(authenticationManager, jwtToken, getUserInformationUseCase);
  }

  @Test
  public void createAuthenticationTokenTest() throws Exception {
    String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYzMTk4MTM1NywiaWF0IjoxNjMxOTgxMDU3fQ"
                     + ".c43MrmLE5wTPFGG0kBzNmvk17YL1mkewokLM1xkgd7VAiNIFkzDEtIkV3U9tMZBpEL6jr2R544Cn_X9ON3ZFuQ";

    when(getUserInformationUseCase.loadUserByUsername(any())).thenReturn(Single.just(getUserDetails()));
    when(jwtToken.generateToken(any())).thenReturn(token);

    authController.createAuthenticationToken(JwtRestRequestMock.getMock())
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
