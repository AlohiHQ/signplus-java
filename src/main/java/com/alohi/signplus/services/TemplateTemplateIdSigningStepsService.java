package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.AddTemplateSigningStepsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdSigningStepsService Service
 */
public class TemplateTemplateIdSigningStepsService extends BaseService {

  private RequestConfig addTemplateSigningStepsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdSigningStepsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdSigningStepsService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code addTemplateSigningSteps}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdSigningStepsService setAddTemplateSigningStepsConfig(
    RequestConfig config
  ) {
    this.addTemplateSigningStepsConfig = config;
    return this;
  }

  /**
   * Add template signing steps
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateSigningStepsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object addTemplateSigningSteps(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsParameters requestParameters
  ) throws ApiError {
    return this.addTemplateSigningSteps(templateId, requestParameters, null);
  }

  /**
   * Add template signing steps
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateSigningStepsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object addTemplateSigningSteps(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateSigningStepsConfig, requestConfig);
    Request request =
      this.buildAddTemplateSigningStepsRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Add template signing steps
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateSigningStepsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addTemplateSigningStepsAsync(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsParameters requestParameters
  ) throws ApiError {
    return this.addTemplateSigningStepsAsync(templateId, requestParameters, null);
  }

  /**
   * Add template signing steps
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateSigningStepsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addTemplateSigningStepsAsync(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateSigningStepsConfig, requestConfig);
    Request request =
      this.buildAddTemplateSigningStepsRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildAddTemplateSigningStepsRequest(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/signing_steps"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
