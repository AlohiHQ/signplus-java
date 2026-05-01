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
 * WebhookIdService Service
 */
public class WebhookIdService extends BaseService {

  private RequestConfig deleteWebhookConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of WebhookIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public WebhookIdService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code deleteWebhook}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public WebhookIdService setDeleteWebhookConfig(RequestConfig config) {
    this.deleteWebhookConfig = config;
    return this;
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code Object}
   */
  public Object deleteWebhook(@NonNull String webhookId) throws ApiError {
    return this.deleteWebhook(webhookId, null);
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code Object}
   */
  public Object deleteWebhook(@NonNull String webhookId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteWebhookConfig, requestConfig);
    Request request = this.buildDeleteWebhookRequest(webhookId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteWebhookAsync(@NonNull String webhookId) throws ApiError {
    return this.deleteWebhookAsync(webhookId, null);
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteWebhookAsync(
    @NonNull String webhookId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteWebhookConfig, requestConfig);
    Request request = this.buildDeleteWebhookRequest(webhookId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDeleteWebhookRequest(
    @NonNull String webhookId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "webhook/{webhook_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("webhook_id", webhookId)
      .build();
  }
}
