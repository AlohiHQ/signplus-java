package com.alohi.signplus.config;

import com.alohi.signplus.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class SignplusConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "signplus/1.0.0";

  @NonNull
  @Builder.Default
  private Environment environment = Environment.DEFAULT;

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  private String accessToken;

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;
}
