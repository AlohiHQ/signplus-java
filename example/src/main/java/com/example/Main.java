package com.example;

import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiException;
import com.alohi.signplus.models.Envelope;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    try {
      Envelope response = signplus.signplus.getEnvelope("envelope_id");

      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
