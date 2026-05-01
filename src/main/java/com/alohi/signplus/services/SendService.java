package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SendEnvelopeParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * SendService Service
 */
public class SendService extends BaseService {

  private RequestConfig sendEnvelopeConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of SendService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public SendService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code sendEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SendService setSendEnvelopeConfig(RequestConfig config) {
    this.sendEnvelopeConfig = config;
    return this;
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @param requestParameters {@link SendEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object sendEnvelope(
    @NonNull String envelopeId,
    @NonNull SendEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.sendEnvelope(envelopeId, requestParameters, null);
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @param requestParameters {@link SendEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object sendEnvelope(
    @NonNull String envelopeId,
    @NonNull SendEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.sendEnvelopeConfig, requestConfig);
    Request request = this.buildSendEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @param requestParameters {@link SendEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> sendEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull SendEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.sendEnvelopeAsync(envelopeId, requestParameters, null);
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @param requestParameters {@link SendEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> sendEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull SendEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.sendEnvelopeConfig, requestConfig);
    Request request = this.buildSendEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSendEnvelopeRequest(
    @NonNull String envelopeId,
    @NonNull SendEnvelopeParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/send"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
