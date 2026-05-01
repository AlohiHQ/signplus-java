package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetEnvelopeAttachmentsSettingsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * SettingsService Service
 */
public class SettingsService extends BaseService {

  private RequestConfig setEnvelopeAttachmentsSettingsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of SettingsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public SettingsService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeAttachmentsSettings}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SettingsService setSetEnvelopeAttachmentsSettingsConfig(RequestConfig config) {
    this.setEnvelopeAttachmentsSettingsConfig = config;
    return this;
  }

  /**
   * Set envelope attachment settings
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeAttachmentsSettingsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeAttachmentsSettings(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeAttachmentsSettings(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope attachment settings
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeAttachmentsSettingsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeAttachmentsSettings(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeAttachmentsSettingsConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeAttachmentsSettingsRequest(
          envelopeId,
          requestParameters,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set envelope attachment settings
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeAttachmentsSettingsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeAttachmentsSettingsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeAttachmentsSettingsAsync(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope attachment settings
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeAttachmentsSettingsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeAttachmentsSettingsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeAttachmentsSettingsConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeAttachmentsSettingsRequest(
          envelopeId,
          requestParameters,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetEnvelopeAttachmentsSettingsRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/attachments/settings"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
