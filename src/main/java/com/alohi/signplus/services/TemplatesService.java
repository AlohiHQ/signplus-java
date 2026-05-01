package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.ListTemplatesParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TemplatesService Service
 */
public class TemplatesService extends BaseService {

  private RequestConfig listTemplatesConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of TemplatesService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public TemplatesService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listTemplates}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public TemplatesService setListTemplatesConfig(RequestConfig config) {
    this.listTemplatesConfig = config;
    return this;
  }

  /**
   * List templates
   *
   * @param requestParameters {@link ListTemplatesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listTemplates(@NonNull ListTemplatesParameters requestParameters) throws ApiError {
    return this.listTemplates(requestParameters, null);
  }

  /**
   * List templates
   *
   * @param requestParameters {@link ListTemplatesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listTemplates(
    @NonNull ListTemplatesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listTemplatesConfig, requestConfig);
    Request request = this.buildListTemplatesRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * List templates
   *
   * @param requestParameters {@link ListTemplatesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listTemplatesAsync(
    @NonNull ListTemplatesParameters requestParameters
  ) throws ApiError {
    return this.listTemplatesAsync(requestParameters, null);
  }

  /**
   * List templates
   *
   * @param requestParameters {@link ListTemplatesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listTemplatesAsync(
    @NonNull ListTemplatesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listTemplatesConfig, requestConfig);
    Request request = this.buildListTemplatesRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildListTemplatesRequest(
    @NonNull ListTemplatesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "templates"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
