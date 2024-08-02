package alohi.signplus.signplus.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * SDK Environments
 */
@Getter
@RequiredArgsConstructor
public enum Environment {
  DEFAULT("https://api.sign.plus/v2");

  private final String url;
}
