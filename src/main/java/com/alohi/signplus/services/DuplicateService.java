package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.DuplicateEnvelopeParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DuplicateService Service
 */
public class DuplicateService extends BaseService {

  private RequestConfig duplicateEnvelopeConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of DuplicateService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public DuplicateService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code duplicateEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public DuplicateService setDuplicateEnvelopeConfig(RequestConfig config) {
    this.duplicateEnvelopeConfig = config;
    return this;
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link DuplicateEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object duplicateEnvelope(
    @NonNull String envelopeId,
    @NonNull DuplicateEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.duplicateEnvelope(envelopeId, requestParameters, null);
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link DuplicateEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object duplicateEnvelope(
    @NonNull String envelopeId,
    @NonNull DuplicateEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.duplicateEnvelopeConfig, requestConfig);
    Request request =
      this.buildDuplicateEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link DuplicateEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> duplicateEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull DuplicateEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.duplicateEnvelopeAsync(envelopeId, requestParameters, null);
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link DuplicateEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> duplicateEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull DuplicateEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.duplicateEnvelopeConfig, requestConfig);
    Request request =
      this.buildDuplicateEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDuplicateEnvelopeRequest(
    @NonNull String envelopeId,
    @NonNull DuplicateEnvelopeParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/duplicate"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
