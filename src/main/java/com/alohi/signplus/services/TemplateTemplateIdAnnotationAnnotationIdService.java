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
 * TemplateTemplateIdAnnotationAnnotationIdService Service
 */
public class TemplateTemplateIdAnnotationAnnotationIdService extends BaseService {

  private RequestConfig deleteTemplateAnnotationConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdAnnotationAnnotationIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdAnnotationAnnotationIdService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code deleteTemplateAnnotation}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdAnnotationAnnotationIdService setDeleteTemplateAnnotationConfig(
    RequestConfig config
  ) {
    this.deleteTemplateAnnotationConfig = config;
    return this;
  }

  /**
   * Delete template annotation
   *
   * @param templateId String
   * @param annotationId String
   * @return response of {@code Object}
   */
  public Object deleteTemplateAnnotation(@NonNull String templateId, @NonNull String annotationId)
    throws ApiError {
    return this.deleteTemplateAnnotation(templateId, annotationId, null);
  }

  /**
   * Delete template annotation
   *
   * @param templateId String
   * @param annotationId String
   * @return response of {@code Object}
   */
  public Object deleteTemplateAnnotation(
    @NonNull String templateId,
    @NonNull String annotationId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.deleteTemplateAnnotationConfig, requestConfig);
    Request request =
      this.buildDeleteTemplateAnnotationRequest(templateId, annotationId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Delete template annotation
   *
   * @param templateId String
   * @param annotationId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull String annotationId
  ) throws ApiError {
    return this.deleteTemplateAnnotationAsync(templateId, annotationId, null);
  }

  /**
   * Delete template annotation
   *
   * @param templateId String
   * @param annotationId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull String annotationId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.deleteTemplateAnnotationConfig, requestConfig);
    Request request =
      this.buildDeleteTemplateAnnotationRequest(templateId, annotationId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDeleteTemplateAnnotationRequest(
    @NonNull String templateId,
    @NonNull String annotationId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/annotation/{annotation_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setPathParameter("annotation_id", annotationId)
      .build();
  }
}
