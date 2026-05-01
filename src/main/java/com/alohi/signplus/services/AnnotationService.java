package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.AddEnvelopeAnnotationParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * AnnotationService Service
 */
public class AnnotationService extends BaseService {

  private RequestConfig addEnvelopeAnnotationConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of AnnotationService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public AnnotationService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code addEnvelopeAnnotation}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AnnotationService setAddEnvelopeAnnotationConfig(RequestConfig config) {
    this.addEnvelopeAnnotationConfig = config;
    return this;
  }

  /**
   * Add envelope annotation
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeAnnotationParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object addEnvelopeAnnotation(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeAnnotationParameters requestParameters
  ) throws ApiError {
    return this.addEnvelopeAnnotation(envelopeId, requestParameters, null);
  }

  /**
   * Add envelope annotation
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeAnnotationParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object addEnvelopeAnnotation(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeAnnotationParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeAnnotationConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeAnnotationRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Add envelope annotation
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeAnnotationParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeAnnotationParameters requestParameters
  ) throws ApiError {
    return this.addEnvelopeAnnotationAsync(envelopeId, requestParameters, null);
  }

  /**
   * Add envelope annotation
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeAnnotationParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeAnnotationParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeAnnotationConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeAnnotationRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildAddEnvelopeAnnotationRequest(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeAnnotationParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/annotation"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
