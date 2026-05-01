package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetTemplateParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdService Service
 */
public class TemplateTemplateIdService extends BaseService {

  private RequestConfig getTemplateConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();
  private RequestConfig deleteTemplateConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdService setGetTemplateConfig(RequestConfig config) {
    this.getTemplateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdService setDeleteTemplateConfig(RequestConfig config) {
    this.deleteTemplateConfig = config;
    return this;
  }

  /**
   * Get template
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getTemplate(
    @NonNull String templateId,
    @NonNull GetTemplateParameters requestParameters
  ) throws ApiError {
    return this.getTemplate(templateId, requestParameters, null);
  }

  /**
   * Get template
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getTemplate(
    @NonNull String templateId,
    @NonNull GetTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getTemplateConfig, requestConfig);
    Request request = this.buildGetTemplateRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get template
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getTemplateAsync(
    @NonNull String templateId,
    @NonNull GetTemplateParameters requestParameters
  ) throws ApiError {
    return this.getTemplateAsync(templateId, requestParameters, null);
  }

  /**
   * Get template
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getTemplateAsync(
    @NonNull String templateId,
    @NonNull GetTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getTemplateConfig, requestConfig);
    Request request = this.buildGetTemplateRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetTemplateRequest(
    @NonNull String templateId,
    @NonNull GetTemplateParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code Object}
   */
  public Object deleteTemplate(@NonNull String templateId) throws ApiError {
    return this.deleteTemplate(templateId, null);
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code Object}
   */
  public Object deleteTemplate(@NonNull String templateId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteTemplateConfig, requestConfig);
    Request request = this.buildDeleteTemplateRequest(templateId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteTemplateAsync(@NonNull String templateId) throws ApiError {
    return this.deleteTemplateAsync(templateId, null);
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteTemplateAsync(
    @NonNull String templateId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteTemplateConfig, requestConfig);
    Request request = this.buildDeleteTemplateRequest(templateId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDeleteTemplateRequest(
    @NonNull String templateId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .build();
  }
}
