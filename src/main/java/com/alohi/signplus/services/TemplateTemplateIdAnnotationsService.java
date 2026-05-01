package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetTemplateAnnotationsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdAnnotationsService Service
 */
public class TemplateTemplateIdAnnotationsService extends BaseService {

  private RequestConfig getTemplateAnnotationsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdAnnotationsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdAnnotationsService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getTemplateAnnotations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdAnnotationsService setGetTemplateAnnotationsConfig(
    RequestConfig config
  ) {
    this.getTemplateAnnotationsConfig = config;
    return this;
  }

  /**
   * Get template annotations
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateAnnotationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getTemplateAnnotations(
    @NonNull String templateId,
    @NonNull GetTemplateAnnotationsParameters requestParameters
  ) throws ApiError {
    return this.getTemplateAnnotations(templateId, requestParameters, null);
  }

  /**
   * Get template annotations
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateAnnotationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getTemplateAnnotations(
    @NonNull String templateId,
    @NonNull GetTemplateAnnotationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetTemplateAnnotationsRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get template annotations
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateAnnotationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getTemplateAnnotationsAsync(
    @NonNull String templateId,
    @NonNull GetTemplateAnnotationsParameters requestParameters
  ) throws ApiError {
    return this.getTemplateAnnotationsAsync(templateId, requestParameters, null);
  }

  /**
   * Get template annotations
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateAnnotationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getTemplateAnnotationsAsync(
    @NonNull String templateId,
    @NonNull GetTemplateAnnotationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetTemplateAnnotationsRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetTemplateAnnotationsRequest(
    @NonNull String templateId,
    @NonNull GetTemplateAnnotationsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/annotations"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
