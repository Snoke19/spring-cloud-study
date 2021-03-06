package com.cloud.authservice.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;


@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;

  public OAuth2Config(@Qualifier("userDetailsServiceBean") UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
    this.userDetailsService = userDetailsService;
    this.authenticationManager = authenticationManager;
  }


  @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
            .withClient("authenticationservice")
            .secret("secret")
            .authorizedGrantTypes("refresh_token", "password", "client_credentials")
            .scopes("webclient","mobileclient");
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
            .authenticationManager(authenticationManager)
            .userDetailsService(userDetailsService);
  }
}
