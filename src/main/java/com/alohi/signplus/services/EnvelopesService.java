package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.ListEnvelopesParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * EnvelopesService Service
 */
public class EnvelopesService extends BaseService {

  private RequestConfig listEnvelopesConfig = RequestConfig.builder()
    .environment(Environment.RESTAPI)
    .build();

  /**
   * Constructs a new instance of EnvelopesService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public EnvelopesService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listEnvelopes}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public EnvelopesService setListEnvelopesConfig(RequestConfig config) {
    this.listEnvelopesConfig = config;
    return this;
  }

  /**
   * List envelopes
   *
   * @param requestParameters {@link ListEnvelopesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listEnvelopes(@NonNull ListEnvelopesParameters requestParameters) throws ApiError {
    return this.listEnvelopes(requestParameters, null);
  }

  /**
   * List envelopes
   *
   * @param requestParameters {@link ListEnvelopesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listEnvelopes(
    @NonNull ListEnvelopesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listEnvelopesConfig, requestConfig);
    Request request = this.buildListEnvelopesRequest(requestParameters, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * List envelopes
   *
   * @param requestParameters {@link ListEnvelopesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listEnvelopesAsync(
    @NonNull ListEnvelopesParameters requestParameters
  ) throws ApiError {
    return this.listEnvelopesAsync(requestParameters, null);
  }

  /**
   * List envelopes
   *
   * @param requestParameters {@link ListEnvelopesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listEnvelopesAsync(
    @NonNull ListEnvelopesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listEnvelopesConfig, requestConfig);
    Request request = this.buildListEnvelopesRequest(requestParameters, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildListEnvelopesRequest(
    @NonNull ListEnvelopesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.RESTAPI),
      "envelopes"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setHeader("Accept", requestParameters.getAccept())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }
}
