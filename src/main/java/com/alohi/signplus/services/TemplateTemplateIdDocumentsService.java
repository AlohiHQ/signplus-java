package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetTemplateDocumentsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdDocumentsService Service
 */
public class TemplateTemplateIdDocumentsService extends BaseService {

  private RequestConfig getTemplateDocumentsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdDocumentsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdDocumentsService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getTemplateDocuments}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdDocumentsService setGetTemplateDocumentsConfig(RequestConfig config) {
    this.getTemplateDocumentsConfig = config;
    return this;
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateDocumentsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getTemplateDocuments(
    @NonNull String templateId,
    @NonNull GetTemplateDocumentsParameters requestParameters
  ) throws ApiError {
    return this.getTemplateDocuments(templateId, requestParameters, null);
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateDocumentsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getTemplateDocuments(
    @NonNull String templateId,
    @NonNull GetTemplateDocumentsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateDocumentsConfig, requestConfig);
    Request request =
      this.buildGetTemplateDocumentsRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateDocumentsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getTemplateDocumentsAsync(
    @NonNull String templateId,
    @NonNull GetTemplateDocumentsParameters requestParameters
  ) throws ApiError {
    return this.getTemplateDocumentsAsync(templateId, requestParameters, null);
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @param requestParameters {@link GetTemplateDocumentsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getTemplateDocumentsAsync(
    @NonNull String templateId,
    @NonNull GetTemplateDocumentsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateDocumentsConfig, requestConfig);
    Request request =
      this.buildGetTemplateDocumentsRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetTemplateDocumentsRequest(
    @NonNull String templateId,
    @NonNull GetTemplateDocumentsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/documents"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
