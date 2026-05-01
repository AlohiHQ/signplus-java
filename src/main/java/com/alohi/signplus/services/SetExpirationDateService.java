package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetEnvelopeExpirationDateParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * SetExpirationDateService Service
 */
public class SetExpirationDateService extends BaseService {

  private RequestConfig setEnvelopeExpirationDateConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of SetExpirationDateService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public SetExpirationDateService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeExpirationDate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SetExpirationDateService setSetEnvelopeExpirationDateConfig(RequestConfig config) {
    this.setEnvelopeExpirationDateConfig = config;
    return this;
  }

  /**
   * Set envelope expiration date
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeExpirationDateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeExpirationDate(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationDateParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeExpirationDate(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope expiration date
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeExpirationDateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeExpirationDate(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationDateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeExpirationDateConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeExpirationDateRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set envelope expiration date
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeExpirationDateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeExpirationDateAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationDateParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeExpirationDateAsync(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope expiration date
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeExpirationDateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeExpirationDateAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationDateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeExpirationDateConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeExpirationDateRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetEnvelopeExpirationDateRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationDateParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/set_expiration_date"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
