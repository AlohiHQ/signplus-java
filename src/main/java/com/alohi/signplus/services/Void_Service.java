package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.VoidEnvelopeParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Void_Service Service
 */
public class Void_Service extends BaseService {

  private RequestConfig voidEnvelopeConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of Void_Service.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public Void_Service(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code voidEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public Void_Service setVoidEnvelopeConfig(RequestConfig config) {
    this.voidEnvelopeConfig = config;
    return this;
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link VoidEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object voidEnvelope(
    @NonNull String envelopeId,
    @NonNull VoidEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.voidEnvelope(envelopeId, requestParameters, null);
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link VoidEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object voidEnvelope(
    @NonNull String envelopeId,
    @NonNull VoidEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.voidEnvelopeConfig, requestConfig);
    Request request = this.buildVoidEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link VoidEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> voidEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull VoidEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.voidEnvelopeAsync(envelopeId, requestParameters, null);
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link VoidEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> voidEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull VoidEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.voidEnvelopeConfig, requestConfig);
    Request request = this.buildVoidEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildVoidEnvelopeRequest(
    @NonNull String envelopeId,
    @NonNull VoidEnvelopeParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/void"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
