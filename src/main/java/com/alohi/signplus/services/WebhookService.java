package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.CreateWebhookParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * WebhookService Service
 */
public class WebhookService extends BaseService {

  private RequestConfig createWebhookConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of WebhookService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public WebhookService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createWebhook}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public WebhookService setCreateWebhookConfig(RequestConfig config) {
    this.createWebhookConfig = config;
    return this;
  }

  /**
   * Create webhook
   *
   * @param requestParameters {@link CreateWebhookParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createWebhook(@NonNull CreateWebhookParameters requestParameters) throws ApiError {
    return this.createWebhook(requestParameters, null);
  }

  /**
   * Create webhook
   *
   * @param requestParameters {@link CreateWebhookParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createWebhook(
    @NonNull CreateWebhookParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createWebhookConfig, requestConfig);
    Request request = this.buildCreateWebhookRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Create webhook
   *
   * @param requestParameters {@link CreateWebhookParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createWebhookAsync(
    @NonNull CreateWebhookParameters requestParameters
  ) throws ApiError {
    return this.createWebhookAsync(requestParameters, null);
  }

  /**
   * Create webhook
   *
   * @param requestParameters {@link CreateWebhookParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createWebhookAsync(
    @NonNull CreateWebhookParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createWebhookConfig, requestConfig);
    Request request = this.buildCreateWebhookRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreateWebhookRequest(
    @NonNull CreateWebhookParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "webhook"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
