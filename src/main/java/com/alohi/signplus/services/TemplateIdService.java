package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.CreateEnvelopeFromTemplateParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateIdService Service
 */
public class TemplateIdService extends BaseService {

  private RequestConfig createEnvelopeFromTemplateConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateIdService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createEnvelopeFromTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateIdService setCreateEnvelopeFromTemplateConfig(RequestConfig config) {
    this.createEnvelopeFromTemplateConfig = config;
    return this;
  }

  /**
   * Create new envelope from template
   *
   * @param templateId String
   * @param requestParameters {@link CreateEnvelopeFromTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createEnvelopeFromTemplate(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateParameters requestParameters
  ) throws ApiError {
    return this.createEnvelopeFromTemplate(templateId, requestParameters, null);
  }

  /**
   * Create new envelope from template
   *
   * @param templateId String
   * @param requestParameters {@link CreateEnvelopeFromTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createEnvelopeFromTemplate(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.createEnvelopeFromTemplateConfig, requestConfig);
    Request request =
      this.buildCreateEnvelopeFromTemplateRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Create new envelope from template
   *
   * @param templateId String
   * @param requestParameters {@link CreateEnvelopeFromTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createEnvelopeFromTemplateAsync(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateParameters requestParameters
  ) throws ApiError {
    return this.createEnvelopeFromTemplateAsync(templateId, requestParameters, null);
  }

  /**
   * Create new envelope from template
   *
   * @param templateId String
   * @param requestParameters {@link CreateEnvelopeFromTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createEnvelopeFromTemplateAsync(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.createEnvelopeFromTemplateConfig, requestConfig);
    Request request =
      this.buildCreateEnvelopeFromTemplateRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreateEnvelopeFromTemplateRequest(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/from_template/{template_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
