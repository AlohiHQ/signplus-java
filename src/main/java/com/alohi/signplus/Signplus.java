package com.alohi.signplus;

import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.interceptors.DefaultHeadersInterceptor;
import com.alohi.signplus.http.interceptors.RetryInterceptor;
import com.alohi.signplus.services.SignplusService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * Integrate legally-binding electronic signature to your workflow
 */
public class Signplus {

  public final SignplusService signplus;

  private final SignplusConfig config;

  /**
   * Constructs a new instance of Signplus with default configuration.
   */
  public Signplus() {
    // Default configs
    this(SignplusConfig.builder().build());
  }

  /**
   * Constructs a new instance of Signplus with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public Signplus(SignplusConfig config) {
    this.config = config;

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.signplus = new SignplusService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  /**
   * Sets the access token (Bearer token) for all API requests.
   *
   * @param token The access token to use for authentication
   */
  public void setAccessToken(String token) {
    this.config.setAccessToken(token);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
