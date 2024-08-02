package com.example;

import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Envelope response = signplus.signplusService.getEnvelope("envelope_id");

    System.out.println(response);
  }
}
