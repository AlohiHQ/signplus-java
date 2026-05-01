package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetTemplateAttachmentsPlaceholdersParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdAttachmentsPlaceholdersService Service
 */
public class TemplateTemplateIdAttachmentsPlaceholdersService extends BaseService {

  private RequestConfig setTemplateAttachmentsPlaceholdersConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdAttachmentsPlaceholdersService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdAttachmentsPlaceholdersService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setTemplateAttachmentsPlaceholders}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdAttachmentsPlaceholdersService setSetTemplateAttachmentsPlaceholdersConfig(
    RequestConfig config
  ) {
    this.setTemplateAttachmentsPlaceholdersConfig = config;
    return this;
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateAttachmentsPlaceholdersParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setTemplateAttachmentsPlaceholders(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsPlaceholdersParameters requestParameters
  ) throws ApiError {
    return this.setTemplateAttachmentsPlaceholders(templateId, requestParameters, null);
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateAttachmentsPlaceholdersParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setTemplateAttachmentsPlaceholders(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsPlaceholdersParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateAttachmentsPlaceholdersConfig, requestConfig);
    Request request =
      this.buildSetTemplateAttachmentsPlaceholdersRequest(
          templateId,
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
   * @param templateId String
   * @param requestParameters {@link SetTemplateAttachmentsPlaceholdersParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setTemplateAttachmentsPlaceholdersAsync(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsPlaceholdersParameters requestParameters
  ) throws ApiError {
    return this.setTemplateAttachmentsPlaceholdersAsync(templateId, requestParameters, null);
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateAttachmentsPlaceholdersParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setTemplateAttachmentsPlaceholdersAsync(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsPlaceholdersParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateAttachmentsPlaceholdersConfig, requestConfig);
    Request request =
      this.buildSetTemplateAttachmentsPlaceholdersRequest(
          templateId,
          requestParameters,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetTemplateAttachmentsPlaceholdersRequest(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsPlaceholdersParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/attachments/placeholders"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
