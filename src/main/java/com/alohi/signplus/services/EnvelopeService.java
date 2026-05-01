package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.CreateEnvelopeParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * EnvelopeService Service
 */
public class EnvelopeService extends BaseService {

  private RequestConfig createEnvelopeConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of EnvelopeService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public EnvelopeService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public EnvelopeService setCreateEnvelopeConfig(RequestConfig config) {
    this.createEnvelopeConfig = config;
    return this;
  }

  /**
   * Create new envelope
   *
   * @param requestParameters {@link CreateEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createEnvelope(@NonNull CreateEnvelopeParameters requestParameters)
    throws ApiError {
    return this.createEnvelope(requestParameters, null);
  }

  /**
   * Create new envelope
   *
   * @param requestParameters {@link CreateEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createEnvelope(
    @NonNull CreateEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createEnvelopeConfig, requestConfig);
    Request request = this.buildCreateEnvelopeRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Create new envelope
   *
   * @param requestParameters {@link CreateEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createEnvelopeAsync(
    @NonNull CreateEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.createEnvelopeAsync(requestParameters, null);
  }

  /**
   * Create new envelope
   *
   * @param requestParameters {@link CreateEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createEnvelopeAsync(
    @NonNull CreateEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createEnvelopeConfig, requestConfig);
    Request request = this.buildCreateEnvelopeRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreateEnvelopeRequest(
    @NonNull CreateEnvelopeParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
