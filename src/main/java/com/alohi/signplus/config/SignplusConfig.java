package com.alohi.signplus.config;

import com.alohi.signplus.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Builder
@Data
public class SignplusConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "signplus/1.0.0";

  @Setter
  private String baseUrl;

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  private String accessToken;

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;

  public void setEnvironment(Environment environment) {
    this.baseUrl = environment.getUrl();
  }
}
