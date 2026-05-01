package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetEnvelopeDocumentParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DocumentIdService Service
 */
public class DocumentIdService extends BaseService {

  private RequestConfig getEnvelopeDocumentConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of DocumentIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public DocumentIdService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getEnvelopeDocument}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public DocumentIdService setGetEnvelopeDocumentConfig(RequestConfig config) {
    this.getEnvelopeDocumentConfig = config;
    return this;
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @param requestParameters {@link GetEnvelopeDocumentParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelopeDocument(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeDocument(envelopeId, documentId, requestParameters, null);
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @param requestParameters {@link GetEnvelopeDocumentParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelopeDocument(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeDocumentRequest(
          envelopeId,
          documentId,
          requestParameters,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @param requestParameters {@link GetEnvelopeDocumentParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeDocumentAsync(envelopeId, documentId, requestParameters, null);
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @param requestParameters {@link GetEnvelopeDocumentParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeDocumentRequest(
          envelopeId,
          documentId,
          requestParameters,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetEnvelopeDocumentRequest(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/document/{document_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setPathParameter("document_id", documentId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
