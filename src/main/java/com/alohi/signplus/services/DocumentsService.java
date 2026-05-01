package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetEnvelopeDocumentsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DocumentsService Service
 */
public class DocumentsService extends BaseService {

  private RequestConfig getEnvelopeDocumentsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of DocumentsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public DocumentsService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getEnvelopeDocuments}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public DocumentsService setGetEnvelopeDocumentsConfig(RequestConfig config) {
    this.getEnvelopeDocumentsConfig = config;
    return this;
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeDocumentsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelopeDocuments(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeDocumentsParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeDocuments(envelopeId, requestParameters, null);
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeDocumentsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelopeDocuments(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeDocumentsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentsConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeDocumentsRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeDocumentsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeDocumentsAsync(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeDocumentsParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeDocumentsAsync(envelopeId, requestParameters, null);
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @param requestParameters {@link GetEnvelopeDocumentsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeDocumentsAsync(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeDocumentsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentsConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeDocumentsRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetEnvelopeDocumentsRequest(
    @NonNull String envelopeId,
    @NonNull GetEnvelopeDocumentsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/documents"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
