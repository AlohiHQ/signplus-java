package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetTemplateCommentParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdSetCommentService Service
 */
public class TemplateTemplateIdSetCommentService extends BaseService {

  private RequestConfig setTemplateCommentConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdSetCommentService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdSetCommentService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setTemplateComment}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdSetCommentService setSetTemplateCommentConfig(RequestConfig config) {
    this.setTemplateCommentConfig = config;
    return this;
  }

  /**
   * Set template comment
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateCommentParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setTemplateComment(
    @NonNull String templateId,
    @NonNull SetTemplateCommentParameters requestParameters
  ) throws ApiError {
    return this.setTemplateComment(templateId, requestParameters, null);
  }

  /**
   * Set template comment
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateCommentParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setTemplateComment(
    @NonNull String templateId,
    @NonNull SetTemplateCommentParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateCommentConfig, requestConfig);
    Request request =
      this.buildSetTemplateCommentRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set template comment
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateCommentParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setTemplateCommentAsync(
    @NonNull String templateId,
    @NonNull SetTemplateCommentParameters requestParameters
  ) throws ApiError {
    return this.setTemplateCommentAsync(templateId, requestParameters, null);
  }

  /**
   * Set template comment
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateCommentParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setTemplateCommentAsync(
    @NonNull String templateId,
    @NonNull SetTemplateCommentParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateCommentConfig, requestConfig);
    Request request =
      this.buildSetTemplateCommentRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetTemplateCommentRequest(
    @NonNull String templateId,
    @NonNull SetTemplateCommentParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/set_comment"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
