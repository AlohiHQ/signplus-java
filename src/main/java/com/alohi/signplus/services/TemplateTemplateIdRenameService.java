package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.RenameTemplateParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplateTemplateIdRenameService Service
 */
public class TemplateTemplateIdRenameService extends BaseService {

  private RequestConfig renameTemplateConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplateTemplateIdRenameService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplateTemplateIdRenameService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code renameTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplateTemplateIdRenameService setRenameTemplateConfig(RequestConfig config) {
    this.renameTemplateConfig = config;
    return this;
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param requestParameters {@link RenameTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object renameTemplate(
    @NonNull String templateId,
    @NonNull RenameTemplateParameters requestParameters
  ) throws ApiError {
    return this.renameTemplate(templateId, requestParameters, null);
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param requestParameters {@link RenameTemplateParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object renameTemplate(
    @NonNull String templateId,
    @NonNull RenameTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.renameTemplateConfig, requestConfig);
    Request request =
      this.buildRenameTemplateRequest(templateId, requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param requestParameters {@link RenameTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> renameTemplateAsync(
    @NonNull String templateId,
    @NonNull RenameTemplateParameters requestParameters
  ) throws ApiError {
    return this.renameTemplateAsync(templateId, requestParameters, null);
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param requestParameters {@link RenameTemplateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> renameTemplateAsync(
    @NonNull String templateId,
    @NonNull RenameTemplateParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.renameTemplateConfig, requestConfig);
    Request request =
      this.buildRenameTemplateRequest(templateId, requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildRenameTemplateRequest(
    @NonNull String templateId,
    @NonNull RenameTemplateParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "template/{template_id}/rename"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
