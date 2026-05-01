package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetEnvelopeAttachmentsPlaceholdersParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * PlaceholdersService Service
 */
public class PlaceholdersService extends BaseService {

  private RequestConfig setEnvelopeAttachmentsPlaceholdersConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of PlaceholdersService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public PlaceholdersService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeAttachmentsPlaceholders}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public PlaceholdersService setSetEnvelopeAttachmentsPlaceholdersConfig(RequestConfig config) {
    this.setEnvelopeAttachmentsPlaceholdersConfig = config;
    return this;
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeAttachmentsPlaceholdersParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeAttachmentsPlaceholders(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeAttachmentsPlaceholders(envelopeId, requestParameters, null);
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeAttachmentsPlaceholdersParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeAttachmentsPlaceholders(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeAttachmentsPlaceholdersConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeAttachmentsPlaceholdersRequest(
          envelopeId,
          requestParameters,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeAttachmentsPlaceholdersParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeAttachmentsPlaceholdersAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeAttachmentsPlaceholdersAsync(envelopeId, requestParameters, null);
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeAttachmentsPlaceholdersParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeAttachmentsPlaceholdersAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeAttachmentsPlaceholdersConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeAttachmentsPlaceholdersRequest(
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

  private Request buildSetEnvelopeAttachmentsPlaceholdersRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/attachments/placeholders"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
