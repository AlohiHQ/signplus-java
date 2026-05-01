package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetEnvelopeNotificationParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * SetNotificationService Service
 */
public class SetNotificationService extends BaseService {

  private RequestConfig setEnvelopeNotificationConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of SetNotificationService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public SetNotificationService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeNotification}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SetNotificationService setSetEnvelopeNotificationConfig(RequestConfig config) {
    this.setEnvelopeNotificationConfig = config;
    return this;
  }

  /**
   * Set envelope notification
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeNotificationParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeNotification(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeNotificationParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeNotification(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope notification
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeNotificationParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeNotification(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeNotificationParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeNotificationConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeNotificationRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set envelope notification
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeNotificationParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeNotificationAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeNotificationParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeNotificationAsync(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope notification
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeNotificationParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeNotificationAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeNotificationParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeNotificationConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeNotificationRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetEnvelopeNotificationRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeNotificationParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/set_notification"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
