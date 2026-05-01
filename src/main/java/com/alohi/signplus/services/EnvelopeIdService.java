package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetEnvelopeParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * EnvelopeIdService Service
 */
public class EnvelopeIdService extends BaseService {

  private RequestConfig getEnvelopeConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();
  private RequestConfig deleteEnvelopeConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of EnvelopeIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public EnvelopeIdService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public EnvelopeIdService setGetEnvelopeConfig(RequestConfig config) {
    this.getEnvelopeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public EnvelopeIdService setDeleteEnvelopeConfig(RequestConfig config) {
    this.deleteEnvelopeConfig = config;
    return this;
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelope(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.getEnvelope(envelopeId, requestParameters, null);
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelope(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEnvelopeConfig, requestConfig);
    Request request = this.buildGetEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeAsync(envelopeId, requestParameters, null);
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEnvelopeConfig, requestConfig);
    Request request = this.buildGetEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetEnvelopeRequest(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code Object}
   */
  public Object deleteEnvelope(@NonNull String envelopeId) throws ApiError {
    return this.deleteEnvelope(envelopeId, null);
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code Object}
   */
  public Object deleteEnvelope(@NonNull String envelopeId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteEnvelopeConfig, requestConfig);
    Request request = this.buildDeleteEnvelopeRequest(envelopeId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteEnvelopeAsync(@NonNull String envelopeId) throws ApiError {
    return this.deleteEnvelopeAsync(envelopeId, null);
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteEnvelopeAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteEnvelopeConfig, requestConfig);
    Request request = this.buildDeleteEnvelopeRequest(envelopeId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDeleteEnvelopeRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }
}
