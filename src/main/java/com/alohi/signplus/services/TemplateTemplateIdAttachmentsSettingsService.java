package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetTemplateAttachmentsSettingsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdAttachmentsSettingsService Service
 */
public class TemplateTemplateIdAttachmentsSettingsService extends BaseService {

  private RequestConfig setTemplateAttachmentsSettingsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdAttachmentsSettingsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdAttachmentsSettingsService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setTemplateAttachmentsSettings}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdAttachmentsSettingsService setSetTemplateAttachmentsSettingsConfig(
    RequestConfig config
  ) {
    this.setTemplateAttachmentsSettingsConfig = config;
    return this;
  }

  /**
   * Set template attachment settings
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateAttachmentsSettingsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setTemplateAttachmentsSettings(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsSettingsParameters requestParameters
  ) throws ApiError {
    return this.setTemplateAttachmentsSettings(templateId, requestParameters, null);
  }

  /**
   * Set template attachment settings
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateAttachmentsSettingsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setTemplateAttachmentsSettings(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsSettingsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateAttachmentsSettingsConfig, requestConfig);
    Request request =
      this.buildSetTemplateAttachmentsSettingsRequest(
          templateId,
          requestParameters,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set template attachment settings
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateAttachmentsSettingsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setTemplateAttachmentsSettingsAsync(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsSettingsParameters requestParameters
  ) throws ApiError {
    return this.setTemplateAttachmentsSettingsAsync(templateId, requestParameters, null);
  }

  /**
   * Set template attachment settings
   *
   * @param templateId String
   * @param requestParameters {@link SetTemplateAttachmentsSettingsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setTemplateAttachmentsSettingsAsync(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsSettingsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateAttachmentsSettingsConfig, requestConfig);
    Request request =
      this.buildSetTemplateAttachmentsSettingsRequest(
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

  private Request buildSetTemplateAttachmentsSettingsRequest(
    @NonNull String templateId,
    @NonNull SetTemplateAttachmentsSettingsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/attachments/settings"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
