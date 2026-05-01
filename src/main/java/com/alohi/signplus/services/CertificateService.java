package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.DownloadEnvelopeCertificateParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * CertificateService Service
 */
public class CertificateService extends BaseService {

  private RequestConfig downloadEnvelopeCertificateConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of CertificateService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public CertificateService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code downloadEnvelopeCertificate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public CertificateService setDownloadEnvelopeCertificateConfig(RequestConfig config) {
    this.downloadEnvelopeCertificateConfig = config;
    return this;
  }

  /**
   * Download certificate of completion for an envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link DownloadEnvelopeCertificateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object downloadEnvelopeCertificate(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeCertificateParameters requestParameters
  ) throws ApiError {
    return this.downloadEnvelopeCertificate(envelopeId, requestParameters, null);
  }

  /**
   * Download certificate of completion for an envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link DownloadEnvelopeCertificateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object downloadEnvelopeCertificate(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeCertificateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.downloadEnvelopeCertificateConfig, requestConfig);
    Request request =
      this.buildDownloadEnvelopeCertificateRequest(envelopeId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Download certificate of completion for an envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link DownloadEnvelopeCertificateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> downloadEnvelopeCertificateAsync(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeCertificateParameters requestParameters
  ) throws ApiError {
    return this.downloadEnvelopeCertificateAsync(envelopeId, requestParameters, null);
  }

  /**
   * Download certificate of completion for an envelope
   *
   * @param envelopeId String
   * @param requestParameters {@link DownloadEnvelopeCertificateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> downloadEnvelopeCertificateAsync(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeCertificateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.downloadEnvelopeCertificateConfig, requestConfig);
    Request request =
      this.buildDownloadEnvelopeCertificateRequest(envelopeId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDownloadEnvelopeCertificateRequest(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeCertificateParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/certificate"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .build();
  }
}
