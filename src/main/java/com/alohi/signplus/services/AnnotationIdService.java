package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * AnnotationIdService Service
 */
public class AnnotationIdService extends BaseService {

  private RequestConfig deleteEnvelopeAnnotationConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of AnnotationIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public AnnotationIdService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code deleteEnvelopeAnnotation}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AnnotationIdService setDeleteEnvelopeAnnotationConfig(RequestConfig config) {
    this.deleteEnvelopeAnnotationConfig = config;
    return this;
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String
   * @param annotationId String
   * @return response of {@code Object}
   */
  public Object deleteEnvelopeAnnotation(@NonNull String envelopeId, @NonNull String annotationId)
    throws ApiError {
    return this.deleteEnvelopeAnnotation(envelopeId, annotationId, null);
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String
   * @param annotationId String
   * @return response of {@code Object}
   */
  public Object deleteEnvelopeAnnotation(
    @NonNull String envelopeId,
    @NonNull String annotationId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.deleteEnvelopeAnnotationConfig, requestConfig);
    Request request =
      this.buildDeleteEnvelopeAnnotationRequest(envelopeId, annotationId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String
   * @param annotationId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull String annotationId
  ) throws ApiError {
    return this.deleteEnvelopeAnnotationAsync(envelopeId, annotationId, null);
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String
   * @param annotationId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull String annotationId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.deleteEnvelopeAnnotationConfig, requestConfig);
    Request request =
      this.buildDeleteEnvelopeAnnotationRequest(envelopeId, annotationId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDeleteEnvelopeAnnotationRequest(
    @NonNull String envelopeId,
    @NonNull String annotationId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/annotation/{annotation_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setPathParameter("annotation_id", annotationId)
      .build();
  }
}
