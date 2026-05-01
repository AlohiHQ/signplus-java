package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.GetAttachmentFileParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * FileIdService Service
 */
public class FileIdService extends BaseService {

  private RequestConfig getAttachmentFileConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of FileIdService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public FileIdService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getAttachmentFile}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public FileIdService setGetAttachmentFileConfig(RequestConfig config) {
    this.getAttachmentFileConfig = config;
    return this;
  }

  /**
   * Get envelope attachment file
   *
   * @param envelopeId String
   * @param fileId String
   * @param requestParameters {@link GetAttachmentFileParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getAttachmentFile(
    @NonNull String envelopeId,
    @NonNull String fileId,
    @NonNull GetAttachmentFileParameters requestParameters
  ) throws ApiError {
    return this.getAttachmentFile(envelopeId, fileId, requestParameters, null);
  }

  /**
   * Get envelope attachment file
   *
   * @param envelopeId String
   * @param fileId String
   * @param requestParameters {@link GetAttachmentFileParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getAttachmentFile(
    @NonNull String envelopeId,
    @NonNull String fileId,
    @NonNull GetAttachmentFileParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getAttachmentFileConfig, requestConfig);
    Request request =
      this.buildGetAttachmentFileRequest(envelopeId, fileId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Get envelope attachment file
   *
   * @param envelopeId String
   * @param fileId String
   * @param requestParameters {@link GetAttachmentFileParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getAttachmentFileAsync(
    @NonNull String envelopeId,
    @NonNull String fileId,
    @NonNull GetAttachmentFileParameters requestParameters
  ) throws ApiError {
    return this.getAttachmentFileAsync(envelopeId, fileId, requestParameters, null);
  }

  /**
   * Get envelope attachment file
   *
   * @param envelopeId String
   * @param fileId String
   * @param requestParameters {@link GetAttachmentFileParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getAttachmentFileAsync(
    @NonNull String envelopeId,
    @NonNull String fileId,
    @NonNull GetAttachmentFileParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getAttachmentFileConfig, requestConfig);
    Request request =
      this.buildGetAttachmentFileRequest(envelopeId, fileId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetAttachmentFileRequest(
    @NonNull String envelopeId,
    @NonNull String fileId,
    @NonNull GetAttachmentFileParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/attachments/{file_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setPathParameter("file_id", fileId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
