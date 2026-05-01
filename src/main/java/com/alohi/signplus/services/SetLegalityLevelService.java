package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetEnvelopeLegalityLevelParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * SetLegalityLevelService Service
 */
public class SetLegalityLevelService extends BaseService {

  private RequestConfig setEnvelopeLegalityLevelConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of SetLegalityLevelService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public SetLegalityLevelService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeLegalityLevel}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SetLegalityLevelService setSetEnvelopeLegalityLevelConfig(RequestConfig config) {
    this.setEnvelopeLegalityLevelConfig = config;
    return this;
  }

  /**
   * Set envelope legality level
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeLegalityLevelParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeLegalityLevel(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeLegalityLevel(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope legality level
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeLegalityLevelParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeLegalityLevel(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeLegalityLevelConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeLegalityLevelRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set envelope legality level
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeLegalityLevelParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeLegalityLevelAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeLegalityLevelAsync(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope legality level
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeLegalityLevelParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeLegalityLevelAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeLegalityLevelConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeLegalityLevelRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetEnvelopeLegalityLevelRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/set_legality_level"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
