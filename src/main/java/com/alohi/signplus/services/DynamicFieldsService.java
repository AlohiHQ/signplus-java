package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetEnvelopeDynamicFieldsParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DynamicFieldsService Service
 */
public class DynamicFieldsService extends BaseService {

  private RequestConfig setEnvelopeDynamicFieldsConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of DynamicFieldsService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public DynamicFieldsService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeDynamicFields}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public DynamicFieldsService setSetEnvelopeDynamicFieldsConfig(RequestConfig config) {
    this.setEnvelopeDynamicFieldsConfig = config;
    return this;
  }

  /**
   * Set envelope dynamic fields
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeDynamicFieldsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeDynamicFields(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeDynamicFields(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope dynamic fields
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeDynamicFieldsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeDynamicFields(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeDynamicFieldsConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeDynamicFieldsRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set envelope dynamic fields
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeDynamicFieldsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeDynamicFieldsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeDynamicFieldsAsync(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope dynamic fields
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeDynamicFieldsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeDynamicFieldsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeDynamicFieldsConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeDynamicFieldsRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetEnvelopeDynamicFieldsRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/dynamic_fields"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
