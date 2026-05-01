package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetEnvelopeAnnotationsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * AnnotationsService Service
 */
public class AnnotationsService extends BaseService {

  private RequestConfig getEnvelopeAnnotationsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of AnnotationsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public AnnotationsService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getEnvelopeAnnotations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AnnotationsService setGetEnvelopeAnnotationsConfig(RequestConfig config) {
    this.getEnvelopeAnnotationsConfig = config;
    return this;
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeAnnotationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelopeAnnotations(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeAnnotationsParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeAnnotations(envelopeId, requestParameters, null);
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeAnnotationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelopeAnnotations(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeAnnotationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeAnnotationsRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeAnnotationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeAnnotationsAsync(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeAnnotationsParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeAnnotationsAsync(envelopeId, requestParameters, null);
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeAnnotationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeAnnotationsAsync(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeAnnotationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeAnnotationsRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetEnvelopeAnnotationsRequest(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeAnnotationsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/annotations"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
