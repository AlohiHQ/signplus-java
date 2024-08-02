package alohi.signplus.signplus;

import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.http.Environment;
import alohi.signplus.signplus.http.interceptors.DefaultHeadersInterceptor;
import alohi.signplus.signplus.http.interceptors.RetryInterceptor;
import alohi.signplus.signplus.http.interceptors.TokenInterceptor;
import alohi.signplus.signplus.services.SignplusService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** Integrate legally-binding electronic signature to your workflow */
public class Signplus {

  public final SignplusService signplusService;

  private final TokenInterceptor accessAuthInterceptor;

  public Signplus() {
    // Default configs
    this(SignplusConfig.builder().build());
  }

  public Signplus(SignplusConfig config) {
    final String serverUrl = config.getEnvironment().getUrl();

    this.accessAuthInterceptor =
      TokenInterceptor.builder().header("Authorization").prefix("Bearer").token(config.getAccessToken()).build();

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(accessAuthInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.signplusService = new SignplusService(httpClient, serverUrl);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.signplusService.setBaseUrl(baseUrl);
  }

  public void setAccessToken(String token) {
    this.accessAuthInterceptor.setToken(token);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
