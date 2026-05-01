package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.SetEnvelopeCommentParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * SetCommentService Service
 */
public class SetCommentService extends BaseService {

  private RequestConfig setEnvelopeCommentConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of SetCommentService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public SetCommentService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeComment}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SetCommentService setSetEnvelopeCommentConfig(RequestConfig config) {
    this.setEnvelopeCommentConfig = config;
    return this;
  }

  /**
   * Set envelope comment
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeCommentParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeComment(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeComment(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope comment
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeCommentParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object setEnvelopeComment(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeCommentConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeCommentRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Set envelope comment
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeCommentParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeCommentAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentParameters requestParameters
  ) throws ApiError {
    return this.setEnvelopeCommentAsync(envelopeId, requestParameters, null);
  }

  /**
   * Set envelope comment
   *
   * @param envelopeId String
   * @param requestParameters {@link SetEnvelopeCommentParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> setEnvelopeCommentAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeCommentConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeCommentRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildSetEnvelopeCommentRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/set_comment"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
