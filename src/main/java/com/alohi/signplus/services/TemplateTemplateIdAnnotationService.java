package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.AddTemplateAnnotationParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdAnnotationService Service
 */
public class TemplateTemplateIdAnnotationService extends BaseService {

  private RequestConfig addTemplateAnnotationConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdAnnotationService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdAnnotationService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code addTemplateAnnotation}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdAnnotationService setAddTemplateAnnotationConfig(RequestConfig config) {
    this.addTemplateAnnotationConfig = config;
    return this;
  }

  /**
   * Add template annotation
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateAnnotationParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object addTemplateAnnotation(
    @NonNull String templateId,
    @NonNull AddTemplateAnnotationParameters requestParameters
  ) throws ApiError {
    return this.addTemplateAnnotation(templateId, requestParameters, null);
  }

  /**
   * Add template annotation
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateAnnotationParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object addTemplateAnnotation(
    @NonNull String templateId,
    @NonNull AddTemplateAnnotationParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateAnnotationConfig, requestConfig);
    Request request =
      this.buildAddTemplateAnnotationRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Add template annotation
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateAnnotationParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull AddTemplateAnnotationParameters requestParameters
  ) throws ApiError {
    return this.addTemplateAnnotationAsync(templateId, requestParameters, null);
  }

  /**
   * Add template annotation
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateAnnotationParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull AddTemplateAnnotationParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateAnnotationConfig, requestConfig);
    Request request =
      this.buildAddTemplateAnnotationRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildAddTemplateAnnotationRequest(
    @NonNull String templateId,
    @NonNull AddTemplateAnnotationParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/annotation"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
