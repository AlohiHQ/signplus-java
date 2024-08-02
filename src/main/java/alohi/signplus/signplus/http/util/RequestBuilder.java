package alohi.signplus.signplus.http.util;

import static alohi.signplus.signplus.http.util.HttpArgumentConverter.toStringArgument;

import alohi.signplus.signplus.http.HttpMethod;
import alohi.signplus.signplus.http.ModelConverter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RequestBuilder {

  @NonNull
  private final String baseUrl;

  @NonNull
  private final String path;

  @NonNull
  private final HttpMethod httpMethod;

  private final HashMap<String, String> pathParameters = new HashMap<>();

  private final HashMap<String, String> queryParameters = new HashMap<>();

  private final HashMap<String, String> headers = new HashMap<>();

  private RequestBody body;

  /**
   * Initializes a new instance of {@code RequestBuilder}.
   *
   * @param httpMethod
   * @param baseUrl
   * @param path The path template to use for the request. Should have path parameters as
   *     placeholders surrounded by brackets (Eg. "/users/{id}", where "id" is a path parameter).
   */
  public RequestBuilder(HttpMethod httpMethod, String baseUrl, String path) {
    this.httpMethod = httpMethod;
    this.baseUrl = baseUrl;
    this.path = path;
  }

  /**
   * Sets a path parameter. If the parameter is not present in the URL template, it will be ignored.
   *
   * @param key
   * @param value
   * @return
   */
  public RequestBuilder setPathParameter(@NonNull String key, @NonNull Object value) {
    pathParameters.put(key, toStringArgument(value));
    return this;
  }

  /**
   * Sets a query parameter.
   *
   * @param key
   * @param value
   * @return
   */
  public RequestBuilder setQueryParameter(@NonNull String key, @NonNull Object value) {
    queryParameters.put(key, toStringArgument(value));
    return this;
  }

  /**
   * Sets a query parameter if the value is not null.
   *
   * @param key
   * @param value
   * @return
   */
  public RequestBuilder setOptionalQueryParameter(@NonNull String key, Object value) {
    if (value != null) {
      queryParameters.put(key, toStringArgument(value));
    }
    return this;
  }

  /**
   * Sets a header.
   *
   * @param key
   * @param value
   * @return
   */
  public RequestBuilder setHeader(@NonNull String key, @NonNull Object value) {
    headers.put(key, toStringArgument(value));
    return this;
  }

  /**
   * Sets a header if the value is not null.
   *
   * @param key
   * @param value
   * @return
   */
  public RequestBuilder setOptionalHeader(@NonNull String key, Object value) {
    if (value != null) {
      headers.put(key, toStringArgument(value));
    }
    return this;
  }

  /**
   * Sets the content of the request as JSON.
   *
   * @param content
   * @return
   */
  public RequestBuilder setJsonContent(Object content) {
    if (content == null) {
      return this;
    }
    this.body =
      RequestBody.create(
        Objects.requireNonNull(ModelConverter.modelToJson(content)),
        MediaType.parse("application/json; charset=utf-8")
      );
    return this;
  }

  /**
   * @return The {@code Request} instance.
   */
  public Request build() {
    String url = buildUrl();
    Request.Builder requestBuilder = new Request.Builder().url(url);

    for (Map.Entry<String, String> entry : headers.entrySet()) {
      requestBuilder.addHeader(entry.getKey(), entry.getValue());
    }

    if (httpMethod.requiresRequestBody() && this.body == null) {
      this.body = RequestBody.create(new byte[0]);
    }

    requestBuilder.method(httpMethod.getMethod(), body);

    return requestBuilder.build();
  }

  private String buildUrl() {
    String path = this.path;

    for (Map.Entry<String, String> entry : pathParameters.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      path = path.replace("{" + key + "}", value);
    }

    HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder().addPathSegments(path);

    for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
      urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
    }

    return urlBuilder.build().toString();
  }
}
