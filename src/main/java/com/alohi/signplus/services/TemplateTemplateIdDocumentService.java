package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.AddTemplateDocumentParameters;
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
 * TemplateTemplateIdDocumentService Service
 */
public class TemplateTemplateIdDocumentService extends BaseService {

  private RequestConfig addTemplateDocumentConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdDocumentService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdDocumentService(
    @NonNull OkHttpClient httpClient,
    SignplusConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code addTemplateDocument}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdDocumentService setAddTemplateDocumentConfig(RequestConfig config) {
    this.addTemplateDocumentConfig = config;
    return this;
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateDocumentParameters} Request Parameters Object
   * @param _filename String Filename for the uploaded file
   * @return response of {@code Object}
   */
  public Object addTemplateDocument(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentParameters requestParameters,
    @NonNull String _filename
  ) throws ApiError {
    return this.addTemplateDocument(templateId, requestParameters, _filename, null);
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateDocumentParameters} Request Parameters Object
   * @param _filename String Filename for the uploaded file
   * @return response of {@code Object}
   */
  public Object addTemplateDocument(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentParameters requestParameters,
    @NonNull String _filename,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateDocumentConfig, requestConfig);
    Request request =
      this.buildAddTemplateDocumentRequest(
          templateId,
          requestParameters,
          _filename,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateDocumentParameters} Request Parameters Object
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addTemplateDocumentAsync(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentParameters requestParameters,
    @NonNull String _filename
  ) throws ApiError {
    return this.addTemplateDocumentAsync(templateId, requestParameters, _filename, null);
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param requestParameters {@link AddTemplateDocumentParameters} Request Parameters Object
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> addTemplateDocumentAsync(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentParameters requestParameters,
    @NonNull String _filename,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateDocumentConfig, requestConfig);
    Request request =
      this.buildAddTemplateDocumentRequest(
          templateId,
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

  private Request buildAddTemplateDocumentRequest(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentParameters requestParameters,
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
      "template/{template_id}/document"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setBody(multipartBodyBuilder.build())
      .build();
  }
}
