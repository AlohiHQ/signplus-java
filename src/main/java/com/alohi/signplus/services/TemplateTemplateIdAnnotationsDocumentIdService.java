package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetDocumentTemplateAnnotationsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdAnnotationsDocumentIdService Service
 */
public class TemplateTemplateIdAnnotationsDocumentIdService extends BaseService {

  private RequestConfig getDocumentTemplateAnnotationsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdAnnotationsDocumentIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdAnnotationsDocumentIdService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getDocumentTemplateAnnotations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdAnnotationsDocumentIdService setGetDocumentTemplateAnnotationsConfig(
    RequestConfig config
  ) {
    this.getDocumentTemplateAnnotationsConfig = config;
    return this;
  }

  /**
   * Get document template annotations
   *
   * @param templateId String
   * @param documentId String
   * @param requestParameters {@link GetDocumentTemplateAnnotationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getDocumentTemplateAnnotations(
    @NonNull String templateId,
    @NonNull String documentId,
    @NonNull GetDocumentTemplateAnnotationsParameters requestParameters
  ) throws ApiError {
    return this.getDocumentTemplateAnnotations(templateId, documentId, requestParameters, null);
  }

  /**
   * Get document template annotations
   *
   * @param templateId String
   * @param documentId String
   * @param requestParameters {@link GetDocumentTemplateAnnotationsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getDocumentTemplateAnnotations(
    @NonNull String templateId,
    @NonNull String documentId,
    @NonNull GetDocumentTemplateAnnotationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getDocumentTemplateAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetDocumentTemplateAnnotationsRequest(
          templateId,
          documentId,
          requestParameters,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get document template annotations
   *
   * @param templateId String
   * @param documentId String
   * @param requestParameters {@link GetDocumentTemplateAnnotationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getDocumentTemplateAnnotationsAsync(
    @NonNull String templateId,
    @NonNull String documentId,
    @NonNull GetDocumentTemplateAnnotationsParameters requestParameters
  ) throws ApiError {
    return this.getDocumentTemplateAnnotationsAsync(
        templateId,
        documentId,
        requestParameters,
        null
      );
  }

  /**
   * Get document template annotations
   *
   * @param templateId String
   * @param documentId String
   * @param requestParameters {@link GetDocumentTemplateAnnotationsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getDocumentTemplateAnnotationsAsync(
    @NonNull String templateId,
    @NonNull String documentId,
    @NonNull GetDocumentTemplateAnnotationsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getDocumentTemplateAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetDocumentTemplateAnnotationsRequest(
          templateId,
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

  private Request buildGetDocumentTemplateAnnotationsRequest(
    @NonNull String templateId,
    @NonNull String documentId,
    @NonNull GetDocumentTemplateAnnotationsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/annotations/{document_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setPathParameter("document_id", documentId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
