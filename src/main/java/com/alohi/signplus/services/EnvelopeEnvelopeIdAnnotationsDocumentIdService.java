package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetEnvelopeDocumentAnnotationsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * EnvelopeEnvelopeIdAnnotationsDocumentIdService Service
 */
public class EnvelopeEnvelopeIdAnnotationsDocumentIdService extends BaseService {

  private RequestConfig getEnvelopeDocumentAnnotationsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of EnvelopeEnvelopeIdAnnotationsDocumentIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public EnvelopeEnvelopeIdAnnotationsDocumentIdService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getEnvelopeDocumentAnnotations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public EnvelopeEnvelopeIdAnnotationsDocumentIdService setGetEnvelopeDocumentAnnotationsConfig(
    RequestConfig config
  ) {
    this.getEnvelopeDocumentAnnotationsConfig = config;
    return this;
  }

  /**
   * Get envelope document annotations
   *
   * @param envelopeId String
   * @param documentId String
   * @param requestParameters {@link GetEnvelopeDocumentAnnotationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelopeDocumentAnnotations(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentAnnotationsParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeDocumentAnnotations(envelopeId, documentId, requestParameters, null);
  }

  /**
   * Get envelope document annotations
   *
   * @param envelopeId String
   * @param documentId String
   * @param requestParameters {@link GetEnvelopeDocumentAnnotationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getEnvelopeDocumentAnnotations(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentAnnotationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeDocumentAnnotationsRequest(
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
   * Get envelope document annotations
   *
   * @param envelopeId String
   * @param documentId String
   * @param requestParameters {@link GetEnvelopeDocumentAnnotationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeDocumentAnnotationsAsync(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentAnnotationsParameters requestParameters
  ) throws ApiError {
    return this.getEnvelopeDocumentAnnotationsAsync(
        envelopeId,
        documentId,
        requestParameters,
        null
      );
  }

  /**
   * Get envelope document annotations
   *
   * @param envelopeId String
   * @param documentId String
   * @param requestParameters {@link GetEnvelopeDocumentAnnotationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getEnvelopeDocumentAnnotationsAsync(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentAnnotationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeDocumentAnnotationsRequest(
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

  private Request buildGetEnvelopeDocumentAnnotationsRequest(
    @NonNull String envelopeId,
    @NonNull String documentId,
    @NonNull GetEnvelopeDocumentAnnotationsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/annotations/{document_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setPathParameter("document_id", documentId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
