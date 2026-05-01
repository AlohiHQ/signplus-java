package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.RenameEnvelopeParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * RenameService Service
 */
public class RenameService extends BaseService {

  private RequestConfig renameEnvelopeConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of RenameService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public RenameService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code renameEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public RenameService setRenameEnvelopeConfig(RequestConfig config) {
    this.renameEnvelopeConfig = config;
    return this;
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link RenameEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object renameEnvelope(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.renameEnvelope(envelopeId, requestParameters, null);
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link RenameEnvelopeParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object renameEnvelope(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.renameEnvelopeConfig, requestConfig);
    Request request =
      this.buildRenameEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link RenameEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> renameEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeParameters requestParameters
  ) throws ApiError {
    return this.renameEnvelopeAsync(envelopeId, requestParameters, null);
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link RenameEnvelopeParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> renameEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.renameEnvelopeConfig, requestConfig);
    Request request =
      this.buildRenameEnvelopeRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildRenameEnvelopeRequest(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/rename"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
