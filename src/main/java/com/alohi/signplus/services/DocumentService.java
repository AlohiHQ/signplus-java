package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.AddEnvelopeDocumentParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * DocumentService Service
 */
public class DocumentService extends BaseService {

  private RequestConfig addEnvelopeDocumentConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of DocumentService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public DocumentService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code addEnvelopeDocument}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public DocumentService setAddEnvelopeDocumentConfig(RequestConfig config) {
    this.addEnvelopeDocumentConfig = config;
    return this;
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeDocumentParameters} Request Parameters Object
   * @param _filename String Filename for the uploaded file
   * @return response of {@code Object}
   */
  public Object addEnvelopeDocument(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentParameters requestParameters,
    @NonNull String _filename
  ) throws ApiError {
    return this.addEnvelopeDocument(envelopeId, requestParameters, _filename, null);
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeDocumentParameters} Request Parameters Object
   * @param _filename String Filename for the uploaded file
   * @return response of {@code Object}
   */
  public Object addEnvelopeDocument(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentParameters requestParameters,
    @NonNull String _filename,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeDocumentConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeDocumentRequest(
          envelopeId,
          requestParameters,
          _filename,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeDocumentParameters} Request Parameters Object
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentParameters requestParameters,
    @NonNull String _filename
  ) throws ApiError {
    return this.addEnvelopeDocumentAsync(envelopeId, requestParameters, _filename, null);
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param requestParameters {@link AddEnvelopeDocumentParameters} Request Parameters Object
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentParameters requestParameters,
    @NonNull String _filename,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeDocumentConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeDocumentRequest(
          envelopeId,
          requestParameters,
          _filename,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildAddEnvelopeDocumentRequest(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentParameters requestParameters,
    @NonNull String _filename,
    RequestConfig resolvedConfig
  ) {
    MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder()
      .setType(MultipartBody.FORM);
    if (requestParameters.getRequestBody().getFile() != null) {
      multipartBodyBuilder.addFormDataPart(
        "file",
        _filename,
        RequestBody.create(
          requestParameters.getRequestBody().getFile(),
          MediaType.parse("application/octet-stream")
        )
      );
    }
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelope/{envelope_id}/document"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setHeader("Accept", requestParameters.getAccept())
      .setBody(multipartBodyBuilder.build())
      .build();
  }
}
