package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.DuplicateTemplateParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdDuplicateService Service
 */
public class TemplateTemplateIdDuplicateService extends BaseService {

  private RequestConfig duplicateTemplateConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdDuplicateService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdDuplicateService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code duplicateTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdDuplicateService setDuplicateTemplateConfig(RequestConfig config) {
    this.duplicateTemplateConfig = config;
    return this;
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @param requestParameters {@link DuplicateTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object duplicateTemplate(
    @NonNull String templateId,
    @NonNull DuplicateTemplateParameters requestParameters
  ) throws ApiError {
    return this.duplicateTemplate(templateId, requestParameters, null);
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @param requestParameters {@link DuplicateTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object duplicateTemplate(
    @NonNull String templateId,
    @NonNull DuplicateTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.duplicateTemplateConfig, requestConfig);
    Request request =
      this.buildDuplicateTemplateRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @param requestParameters {@link DuplicateTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> duplicateTemplateAsync(
    @NonNull String templateId,
    @NonNull DuplicateTemplateParameters requestParameters
  ) throws ApiError {
    return this.duplicateTemplateAsync(templateId, requestParameters, null);
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @param requestParameters {@link DuplicateTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> duplicateTemplateAsync(
    @NonNull String templateId,
    @NonNull DuplicateTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.duplicateTemplateConfig, requestConfig);
    Request request =
      this.buildDuplicateTemplateRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDuplicateTemplateRequest(
    @NonNull String templateId,
    @NonNull DuplicateTemplateParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/duplicate"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
