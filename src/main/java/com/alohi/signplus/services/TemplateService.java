package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.CreateTemplateParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateService Service
 */
public class TemplateService extends BaseService {

  private RequestConfig createTemplateConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateService setCreateTemplateConfig(RequestConfig config) {
    this.createTemplateConfig = config;
    return this;
  }

  /**
   * Create new template
   *
   * @param requestParameters {@link CreateTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createTemplate(@NonNull CreateTemplateParameters requestParameters)
    throws ApiError {
    return this.createTemplate(requestParameters, null);
  }

  /**
   * Create new template
   *
   * @param requestParameters {@link CreateTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createTemplate(
    @NonNull CreateTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createTemplateConfig, requestConfig);
    Request request = this.buildCreateTemplateRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Create new template
   *
   * @param requestParameters {@link CreateTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createTemplateAsync(
    @NonNull CreateTemplateParameters requestParameters
  ) throws ApiError {
    return this.createTemplateAsync(requestParameters, null);
  }

  /**
   * Create new template
   *
   * @param requestParameters {@link CreateTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createTemplateAsync(
    @NonNull CreateTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createTemplateConfig, requestConfig);
    Request request = this.buildCreateTemplateRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreateTemplateRequest(
    @NonNull CreateTemplateParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
