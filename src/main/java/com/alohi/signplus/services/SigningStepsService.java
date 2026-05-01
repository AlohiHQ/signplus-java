package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.AddEnvelopeSigningStepsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * SigningStepsService Service
 */
public class SigningStepsService extends BaseService {

  private RequestConfig addEnvelopeSigningStepsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of SigningStepsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public SigningStepsService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code addEnvelopeSigningSteps}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SigningStepsService setAddEnvelopeSigningStepsConfig(RequestConfig config) {
    this.addEnvelopeSigningStepsConfig = config;
    return this;
  }

  /**
   * Add envelope signing steps
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeSigningStepsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object addEnvelopeSigningSteps(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsParameters requestParameters
  ) throws ApiError {
    return this.addEnvelopeSigningSteps(envelopeId, requestParameters, null);
  }

  /**
   * Add envelope signing steps
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeSigningStepsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object addEnvelopeSigningSteps(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeSigningStepsConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeSigningStepsRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Add envelope signing steps
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeSigningStepsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addEnvelopeSigningStepsAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsParameters requestParameters
  ) throws ApiError {
    return this.addEnvelopeSigningStepsAsync(envelopeId, requestParameters, null);
  }

  /**
   * Add envelope signing steps
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeSigningStepsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addEnvelopeSigningStepsAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeSigningStepsConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeSigningStepsRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildAddEnvelopeSigningStepsRequest(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/signing_steps"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
