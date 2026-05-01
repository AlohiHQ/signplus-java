package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetTemplateNotificationParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdSetNotificationService Service
 */
public class TemplateTemplateIdSetNotificationService extends BaseService {

  private RequestConfig setTemplateNotificationConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdSetNotificationService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdSetNotificationService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setTemplateNotification}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdSetNotificationService setSetTemplateNotificationConfig(
    RequestConfig config
  ) {
    this.setTemplateNotificationConfig = config;
    return this;
  }

  /**
   * Set template notification
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateNotificationParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setTemplateNotification(
    @NonNull String templateId,
    @NonNull SetTemplateNotificationParameters requestParameters
  ) throws ApiError {
    return this.setTemplateNotification(templateId, requestParameters, null);
  }

  /**
   * Set template notification
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateNotificationParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setTemplateNotification(
    @NonNull String templateId,
    @NonNull SetTemplateNotificationParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateNotificationConfig, requestConfig);
    Request request =
      this.buildSetTemplateNotificationRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set template notification
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateNotificationParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setTemplateNotificationAsync(
    @NonNull String templateId,
    @NonNull SetTemplateNotificationParameters requestParameters
  ) throws ApiError {
    return this.setTemplateNotificationAsync(templateId, requestParameters, null);
  }

  /**
   * Set template notification
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateNotificationParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setTemplateNotificationAsync(
    @NonNull String templateId,
    @NonNull SetTemplateNotificationParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateNotificationConfig, requestConfig);
    Request request =
      this.buildSetTemplateNotificationRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetTemplateNotificationRequest(
    @NonNull String templateId,
    @NonNull SetTemplateNotificationParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/set_notification"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
