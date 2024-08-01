package alohi.signplus.signplus.services;

import alohi.signplus.signplus.exceptions.ApiException;
import alohi.signplus.signplus.http.HttpMethod;
import alohi.signplus.signplus.http.ModelConverter;
import alohi.signplus.signplus.http.util.RequestBuilder;
import alohi.signplus.signplus.models.AddAnnotationRequest;
import alohi.signplus.signplus.models.AddEnvelopeDocumentRequest;
import alohi.signplus.signplus.models.AddEnvelopeSigningStepsRequest;
import alohi.signplus.signplus.models.AddTemplateDocumentRequest;
import alohi.signplus.signplus.models.AddTemplateSigningStepsRequest;
import alohi.signplus.signplus.models.Annotation;
import alohi.signplus.signplus.models.CreateEnvelopeFromTemplateRequest;
import alohi.signplus.signplus.models.CreateEnvelopeRequest;
import alohi.signplus.signplus.models.CreateTemplateRequest;
import alohi.signplus.signplus.models.CreateWebhookRequest;
import alohi.signplus.signplus.models.Document;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.EnvelopeNotification;
import alohi.signplus.signplus.models.ListEnvelopeDocumentAnnotationsResponse;
import alohi.signplus.signplus.models.ListEnvelopeDocumentsResponse;
import alohi.signplus.signplus.models.ListEnvelopesRequest;
import alohi.signplus.signplus.models.ListEnvelopesResponse;
import alohi.signplus.signplus.models.ListTemplateAnnotationsResponse;
import alohi.signplus.signplus.models.ListTemplateDocumentAnnotationsResponse;
import alohi.signplus.signplus.models.ListTemplateDocumentsResponse;
import alohi.signplus.signplus.models.ListTemplatesRequest;
import alohi.signplus.signplus.models.ListTemplatesResponse;
import alohi.signplus.signplus.models.ListWebhooksRequest;
import alohi.signplus.signplus.models.ListWebhooksResponse;
import alohi.signplus.signplus.models.RenameEnvelopeRequest;
import alohi.signplus.signplus.models.RenameTemplateRequest;
import alohi.signplus.signplus.models.SetEnvelopeCommentRequest;
import alohi.signplus.signplus.models.SetEnvelopeDynamicFieldsRequest;
import alohi.signplus.signplus.models.SetEnvelopeExpirationRequest;
import alohi.signplus.signplus.models.SetEnvelopeLegalityLevelRequest;
import alohi.signplus.signplus.models.SetTemplateCommentRequest;
import alohi.signplus.signplus.models.Template;
import alohi.signplus.signplus.models.Webhook;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * SignplusService Service
 */
public class SignplusService extends BaseService {

  public SignplusService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Create new envelope
   *
   * @param createEnvelopeRequest {@link CreateEnvelopeRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope createEnvelope(@NonNull CreateEnvelopeRequest createEnvelopeRequest) throws ApiException {
    Request request = this.buildCreateEnvelopeRequest(createEnvelopeRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Create new envelope
   *
   * @param createEnvelopeRequest {@link CreateEnvelopeRequest} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> createEnvelopeAsync(@NonNull CreateEnvelopeRequest createEnvelopeRequest)
    throws ApiException {
    Request request = this.buildCreateEnvelopeRequest(createEnvelopeRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildCreateEnvelopeRequest(@NonNull CreateEnvelopeRequest createEnvelopeRequest) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "envelope")
      .setJsonContent(createEnvelopeRequest)
      .build();
  }

  /**
   * Create new envelope from template
   *
   * @param templateId String
   * @param createEnvelopeFromTemplateRequest {@link CreateEnvelopeFromTemplateRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope createEnvelopeFromTemplate(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest
  ) throws ApiException {
    Request request = this.buildCreateEnvelopeFromTemplateRequest(templateId, createEnvelopeFromTemplateRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Create new envelope from template
   *
   * @param templateId String
   * @param createEnvelopeFromTemplateRequest {@link CreateEnvelopeFromTemplateRequest} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> createEnvelopeFromTemplateAsync(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest
  ) throws ApiException {
    Request request = this.buildCreateEnvelopeFromTemplateRequest(templateId, createEnvelopeFromTemplateRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildCreateEnvelopeFromTemplateRequest(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest
  ) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "envelope/from_template/{template_id}")
      .setPathParameter("template_id", templateId)
      .setJsonContent(createEnvelopeFromTemplateRequest)
      .build();
  }

  /**
   * List envelopes
   *
   * @return response of {@code ListEnvelopesResponse}
   */
  public ListEnvelopesResponse listEnvelopes() throws ApiException {
    return listEnvelopes(ListEnvelopesRequest.builder().build());
  }

  /**
   * List envelopes
   *
   * @param listEnvelopesRequest {@link ListEnvelopesRequest} Request Body
   * @return response of {@code ListEnvelopesResponse}
   */
  public ListEnvelopesResponse listEnvelopes(@NonNull ListEnvelopesRequest listEnvelopesRequest) throws ApiException {
    Request request = this.buildListEnvelopesRequest(listEnvelopesRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ListEnvelopesResponse>() {});
  }

  /**
   * List envelopes
   *
   * @return response of {@code ListEnvelopesResponse}
   */
  public CompletableFuture<ListEnvelopesResponse> listEnvelopesAsync() throws ApiException {
    return listEnvelopesAsync(ListEnvelopesRequest.builder().build());
  }

  /**
   * List envelopes
   *
   * @param listEnvelopesRequest {@link ListEnvelopesRequest} Request Body
   * @return response of {@code ListEnvelopesResponse}
   */
  public CompletableFuture<ListEnvelopesResponse> listEnvelopesAsync(
    @NonNull ListEnvelopesRequest listEnvelopesRequest
  ) throws ApiException {
    Request request = this.buildListEnvelopesRequest(listEnvelopesRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<ListEnvelopesResponse>() {}));
  }

  private Request buildListEnvelopesRequest(@NonNull ListEnvelopesRequest listEnvelopesRequest) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "envelopes")
      .setJsonContent(listEnvelopesRequest)
      .build();
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope getEnvelope(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildGetEnvelopeRequest(envelopeId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> getEnvelopeAsync(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildGetEnvelopeRequest(envelopeId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildGetEnvelopeRequest(@NonNull String envelopeId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "envelope/{envelope_id}")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code Void}
   */
  public void deleteEnvelope(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildDeleteEnvelopeRequest(envelopeId);
    this.execute(request);
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteEnvelopeAsync(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildDeleteEnvelopeRequest(envelopeId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteEnvelopeRequest(@NonNull String envelopeId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "envelope/{envelope_id}")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @return response of {@code Document}
   */
  public Document getEnvelopeDocument(@NonNull String envelopeId, @NonNull String documentId) throws ApiException {
    Request request = this.buildGetEnvelopeDocumentRequest(envelopeId, documentId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Document>() {});
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @return response of {@code Document}
   */
  public CompletableFuture<Document> getEnvelopeDocumentAsync(@NonNull String envelopeId, @NonNull String documentId)
    throws ApiException {
    Request request = this.buildGetEnvelopeDocumentRequest(envelopeId, documentId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Document>() {}));
  }

  private Request buildGetEnvelopeDocumentRequest(@NonNull String envelopeId, @NonNull String documentId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "envelope/{envelope_id}/document/{document_id}")
      .setPathParameter("envelope_id", envelopeId)
      .setPathParameter("document_id", documentId)
      .build();
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @return response of {@code ListEnvelopeDocumentsResponse}
   */
  public ListEnvelopeDocumentsResponse getEnvelopeDocuments(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildGetEnvelopeDocumentsRequest(envelopeId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ListEnvelopeDocumentsResponse>() {});
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @return response of {@code ListEnvelopeDocumentsResponse}
   */
  public CompletableFuture<ListEnvelopeDocumentsResponse> getEnvelopeDocumentsAsync(@NonNull String envelopeId)
    throws ApiException {
    Request request = this.buildGetEnvelopeDocumentsRequest(envelopeId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res ->
      ModelConverter.convert(res, new TypeReference<ListEnvelopeDocumentsResponse>() {})
    );
  }

  private Request buildGetEnvelopeDocumentsRequest(@NonNull String envelopeId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "envelope/{envelope_id}/documents")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param addEnvelopeDocumentRequest {@link AddEnvelopeDocumentRequest} Request Body
   * @return response of {@code Document}
   */
  public Document addEnvelopeDocument(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentRequest addEnvelopeDocumentRequest
  ) throws ApiException {
    Request request = this.buildAddEnvelopeDocumentRequest(envelopeId, addEnvelopeDocumentRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Document>() {});
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param addEnvelopeDocumentRequest {@link AddEnvelopeDocumentRequest} Request Body
   * @return response of {@code Document}
   */
  public CompletableFuture<Document> addEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentRequest addEnvelopeDocumentRequest
  ) throws ApiException {
    Request request = this.buildAddEnvelopeDocumentRequest(envelopeId, addEnvelopeDocumentRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Document>() {}));
  }

  private Request buildAddEnvelopeDocumentRequest(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentRequest addEnvelopeDocumentRequest
  ) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "envelope/{envelope_id}/document")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(addEnvelopeDocumentRequest)
      .build();
  }

  /**
   * Set envelope dynamic fields
   *
   * @param envelopeId String
   * @param setEnvelopeDynamicFieldsRequest {@link SetEnvelopeDynamicFieldsRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope setEnvelopeDynamicFields(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest
  ) throws ApiException {
    Request request = this.buildSetEnvelopeDynamicFieldsRequest(envelopeId, setEnvelopeDynamicFieldsRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope dynamic fields
   *
   * @param envelopeId String
   * @param setEnvelopeDynamicFieldsRequest {@link SetEnvelopeDynamicFieldsRequest} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> setEnvelopeDynamicFieldsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest
  ) throws ApiException {
    Request request = this.buildSetEnvelopeDynamicFieldsRequest(envelopeId, setEnvelopeDynamicFieldsRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildSetEnvelopeDynamicFieldsRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "envelope/{envelope_id}/dynamic_fields")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(setEnvelopeDynamicFieldsRequest)
      .build();
  }

  /**
   * Add envelope signing steps
   *
   * @param envelopeId String
   * @param addEnvelopeSigningStepsRequest {@link AddEnvelopeSigningStepsRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope addEnvelopeSigningSteps(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest
  ) throws ApiException {
    Request request = this.buildAddEnvelopeSigningStepsRequest(envelopeId, addEnvelopeSigningStepsRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Add envelope signing steps
   *
   * @param envelopeId String
   * @param addEnvelopeSigningStepsRequest {@link AddEnvelopeSigningStepsRequest} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> addEnvelopeSigningStepsAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest
  ) throws ApiException {
    Request request = this.buildAddEnvelopeSigningStepsRequest(envelopeId, addEnvelopeSigningStepsRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildAddEnvelopeSigningStepsRequest(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest
  ) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "envelope/{envelope_id}/signing_steps")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(addEnvelopeSigningStepsRequest)
      .build();
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope sendEnvelope(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildSendEnvelopeRequest(envelopeId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> sendEnvelopeAsync(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildSendEnvelopeRequest(envelopeId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildSendEnvelopeRequest(@NonNull String envelopeId) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "envelope/{envelope_id}/send")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope duplicateEnvelope(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildDuplicateEnvelopeRequest(envelopeId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> duplicateEnvelopeAsync(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildDuplicateEnvelopeRequest(envelopeId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildDuplicateEnvelopeRequest(@NonNull String envelopeId) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "envelope/{envelope_id}/duplicate")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope voidEnvelope(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildVoidEnvelopeRequest(envelopeId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> voidEnvelopeAsync(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildVoidEnvelopeRequest(envelopeId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildVoidEnvelopeRequest(@NonNull String envelopeId) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "envelope/{envelope_id}/void")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param renameEnvelopeRequest {@link RenameEnvelopeRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope renameEnvelope(@NonNull String envelopeId, @NonNull RenameEnvelopeRequest renameEnvelopeRequest)
    throws ApiException {
    Request request = this.buildRenameEnvelopeRequest(envelopeId, renameEnvelopeRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param renameEnvelopeRequest {@link RenameEnvelopeRequest} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> renameEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeRequest renameEnvelopeRequest
  ) throws ApiException {
    Request request = this.buildRenameEnvelopeRequest(envelopeId, renameEnvelopeRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildRenameEnvelopeRequest(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeRequest renameEnvelopeRequest
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "envelope/{envelope_id}/rename")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(renameEnvelopeRequest)
      .build();
  }

  /**
   * Set envelope comment
   *
   * @param envelopeId String
   * @param setEnvelopeCommentRequest {@link SetEnvelopeCommentRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope setEnvelopeComment(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentRequest setEnvelopeCommentRequest
  ) throws ApiException {
    Request request = this.buildSetEnvelopeCommentRequest(envelopeId, setEnvelopeCommentRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope comment
   *
   * @param envelopeId String
   * @param setEnvelopeCommentRequest {@link SetEnvelopeCommentRequest} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> setEnvelopeCommentAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentRequest setEnvelopeCommentRequest
  ) throws ApiException {
    Request request = this.buildSetEnvelopeCommentRequest(envelopeId, setEnvelopeCommentRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildSetEnvelopeCommentRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentRequest setEnvelopeCommentRequest
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "envelope/{envelope_id}/set_comment")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(setEnvelopeCommentRequest)
      .build();
  }

  /**
   * Set envelope notification
   *
   * @param envelopeId String
   * @param envelopeNotification {@link EnvelopeNotification} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope setEnvelopeNotification(
    @NonNull String envelopeId,
    @NonNull EnvelopeNotification envelopeNotification
  ) throws ApiException {
    Request request = this.buildSetEnvelopeNotificationRequest(envelopeId, envelopeNotification);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope notification
   *
   * @param envelopeId String
   * @param envelopeNotification {@link EnvelopeNotification} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> setEnvelopeNotificationAsync(
    @NonNull String envelopeId,
    @NonNull EnvelopeNotification envelopeNotification
  ) throws ApiException {
    Request request = this.buildSetEnvelopeNotificationRequest(envelopeId, envelopeNotification);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildSetEnvelopeNotificationRequest(
    @NonNull String envelopeId,
    @NonNull EnvelopeNotification envelopeNotification
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "envelope/{envelope_id}/set_notification")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(envelopeNotification)
      .build();
  }

  /**
   * Set envelope expiration date
   *
   * @param envelopeId String
   * @param setEnvelopeExpirationRequest {@link SetEnvelopeExpirationRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope setEnvelopeExpirationDate(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationRequest setEnvelopeExpirationRequest
  ) throws ApiException {
    Request request = this.buildSetEnvelopeExpirationDateRequest(envelopeId, setEnvelopeExpirationRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope expiration date
   *
   * @param envelopeId String
   * @param setEnvelopeExpirationRequest {@link SetEnvelopeExpirationRequest} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> setEnvelopeExpirationDateAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationRequest setEnvelopeExpirationRequest
  ) throws ApiException {
    Request request = this.buildSetEnvelopeExpirationDateRequest(envelopeId, setEnvelopeExpirationRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildSetEnvelopeExpirationDateRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationRequest setEnvelopeExpirationRequest
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "envelope/{envelope_id}/set_expiration_date")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(setEnvelopeExpirationRequest)
      .build();
  }

  /**
   * Set envelope legality level
   *
   * @param envelopeId String
   * @param setEnvelopeLegalityLevelRequest {@link SetEnvelopeLegalityLevelRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope setEnvelopeLegalityLevel(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest
  ) throws ApiException {
    Request request = this.buildSetEnvelopeLegalityLevelRequest(envelopeId, setEnvelopeLegalityLevelRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope legality level
   *
   * @param envelopeId String
   * @param setEnvelopeLegalityLevelRequest {@link SetEnvelopeLegalityLevelRequest} Request Body
   * @return response of {@code Envelope}
   */
  public CompletableFuture<Envelope> setEnvelopeLegalityLevelAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest
  ) throws ApiException {
    Request request = this.buildSetEnvelopeLegalityLevelRequest(envelopeId, setEnvelopeLegalityLevelRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Envelope>() {}));
  }

  private Request buildSetEnvelopeLegalityLevelRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "envelope/{envelope_id}/set_legality_level")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(setEnvelopeLegalityLevelRequest)
      .build();
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code List<Annotation>}
   */
  public List<Annotation> getEnvelopeAnnotations(@NonNull String envelopeId) throws ApiException {
    Request request = this.buildGetEnvelopeAnnotationsRequest(envelopeId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<List<Annotation>>() {});
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code List<Annotation>}
   */
  public CompletableFuture<List<Annotation>> getEnvelopeAnnotationsAsync(@NonNull String envelopeId)
    throws ApiException {
    Request request = this.buildGetEnvelopeAnnotationsRequest(envelopeId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<List<Annotation>>() {}));
  }

  private Request buildGetEnvelopeAnnotationsRequest(@NonNull String envelopeId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "envelope/{envelope_id}/annotations")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Get envelope document annotations
   *
   * @param envelopeId String ID of the envelope
   * @param documentId String ID of document
   * @return response of {@code ListEnvelopeDocumentAnnotationsResponse}
   */
  public ListEnvelopeDocumentAnnotationsResponse getEnvelopeDocumentAnnotations(
    @NonNull String envelopeId,
    @NonNull String documentId
  ) throws ApiException {
    Request request = this.buildGetEnvelopeDocumentAnnotationsRequest(envelopeId, documentId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ListEnvelopeDocumentAnnotationsResponse>() {});
  }

  /**
   * Get envelope document annotations
   *
   * @param envelopeId String ID of the envelope
   * @param documentId String ID of document
   * @return response of {@code ListEnvelopeDocumentAnnotationsResponse}
   */
  public CompletableFuture<ListEnvelopeDocumentAnnotationsResponse> getEnvelopeDocumentAnnotationsAsync(
    @NonNull String envelopeId,
    @NonNull String documentId
  ) throws ApiException {
    Request request = this.buildGetEnvelopeDocumentAnnotationsRequest(envelopeId, documentId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res ->
      ModelConverter.convert(res, new TypeReference<ListEnvelopeDocumentAnnotationsResponse>() {})
    );
  }

  private Request buildGetEnvelopeDocumentAnnotationsRequest(@NonNull String envelopeId, @NonNull String documentId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "envelope/{envelope_id}/annotations/{document_id}")
      .setPathParameter("envelope_id", envelopeId)
      .setPathParameter("document_id", documentId)
      .build();
  }

  /**
   * Add envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param addAnnotationRequest {@link AddAnnotationRequest} Request Body
   * @return response of {@code Annotation}
   */
  public Annotation addEnvelopeAnnotation(
    @NonNull String envelopeId,
    @NonNull AddAnnotationRequest addAnnotationRequest
  ) throws ApiException {
    Request request = this.buildAddEnvelopeAnnotationRequest(envelopeId, addAnnotationRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Annotation>() {});
  }

  /**
   * Add envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param addAnnotationRequest {@link AddAnnotationRequest} Request Body
   * @return response of {@code Annotation}
   */
  public CompletableFuture<Annotation> addEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull AddAnnotationRequest addAnnotationRequest
  ) throws ApiException {
    Request request = this.buildAddEnvelopeAnnotationRequest(envelopeId, addAnnotationRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Annotation>() {}));
  }

  private Request buildAddEnvelopeAnnotationRequest(
    @NonNull String envelopeId,
    @NonNull AddAnnotationRequest addAnnotationRequest
  ) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "envelope/{envelope_id}/annotation")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(addAnnotationRequest)
      .build();
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code Void}
   */
  public void deleteEnvelopeAnnotation(@NonNull String envelopeId, @NonNull String annotationId) throws ApiException {
    Request request = this.buildDeleteEnvelopeAnnotationRequest(envelopeId, annotationId);
    this.execute(request);
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull String annotationId
  ) throws ApiException {
    Request request = this.buildDeleteEnvelopeAnnotationRequest(envelopeId, annotationId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteEnvelopeAnnotationRequest(@NonNull String envelopeId, @NonNull String annotationId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "envelope/{envelope_id}/annotation/{annotation_id}")
      .setPathParameter("envelope_id", envelopeId)
      .setPathParameter("annotation_id", annotationId)
      .build();
  }

  /**
   * Create new template
   *
   * @param createTemplateRequest {@link CreateTemplateRequest} Request Body
   * @return response of {@code Template}
   */
  public Template createTemplate(@NonNull CreateTemplateRequest createTemplateRequest) throws ApiException {
    Request request = this.buildCreateTemplateRequest(createTemplateRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Template>() {});
  }

  /**
   * Create new template
   *
   * @param createTemplateRequest {@link CreateTemplateRequest} Request Body
   * @return response of {@code Template}
   */
  public CompletableFuture<Template> createTemplateAsync(@NonNull CreateTemplateRequest createTemplateRequest)
    throws ApiException {
    Request request = this.buildCreateTemplateRequest(createTemplateRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Template>() {}));
  }

  private Request buildCreateTemplateRequest(@NonNull CreateTemplateRequest createTemplateRequest) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "template")
      .setJsonContent(createTemplateRequest)
      .build();
  }

  /**
   * List templates
   *
   * @return response of {@code ListTemplatesResponse}
   */
  public ListTemplatesResponse listTemplates() throws ApiException {
    return listTemplates(ListTemplatesRequest.builder().build());
  }

  /**
   * List templates
   *
   * @param listTemplatesRequest {@link ListTemplatesRequest} Request Body
   * @return response of {@code ListTemplatesResponse}
   */
  public ListTemplatesResponse listTemplates(@NonNull ListTemplatesRequest listTemplatesRequest) throws ApiException {
    Request request = this.buildListTemplatesRequest(listTemplatesRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ListTemplatesResponse>() {});
  }

  /**
   * List templates
   *
   * @return response of {@code ListTemplatesResponse}
   */
  public CompletableFuture<ListTemplatesResponse> listTemplatesAsync() throws ApiException {
    return listTemplatesAsync(ListTemplatesRequest.builder().build());
  }

  /**
   * List templates
   *
   * @param listTemplatesRequest {@link ListTemplatesRequest} Request Body
   * @return response of {@code ListTemplatesResponse}
   */
  public CompletableFuture<ListTemplatesResponse> listTemplatesAsync(
    @NonNull ListTemplatesRequest listTemplatesRequest
  ) throws ApiException {
    Request request = this.buildListTemplatesRequest(listTemplatesRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<ListTemplatesResponse>() {}));
  }

  private Request buildListTemplatesRequest(@NonNull ListTemplatesRequest listTemplatesRequest) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "templates")
      .setJsonContent(listTemplatesRequest)
      .build();
  }

  /**
   * Get template
   *
   * @param templateId String
   * @return response of {@code Template}
   */
  public Template getTemplate(@NonNull String templateId) throws ApiException {
    Request request = this.buildGetTemplateRequest(templateId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Template>() {});
  }

  /**
   * Get template
   *
   * @param templateId String
   * @return response of {@code Template}
   */
  public CompletableFuture<Template> getTemplateAsync(@NonNull String templateId) throws ApiException {
    Request request = this.buildGetTemplateRequest(templateId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Template>() {}));
  }

  private Request buildGetTemplateRequest(@NonNull String templateId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "template/{template_id}")
      .setPathParameter("template_id", templateId)
      .build();
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code Void}
   */
  public void deleteTemplate(@NonNull String templateId) throws ApiException {
    Request request = this.buildDeleteTemplateRequest(templateId);
    this.execute(request);
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteTemplateAsync(@NonNull String templateId) throws ApiException {
    Request request = this.buildDeleteTemplateRequest(templateId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteTemplateRequest(@NonNull String templateId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "template/{template_id}")
      .setPathParameter("template_id", templateId)
      .build();
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @return response of {@code Template}
   */
  public Template duplicateTemplate(@NonNull String templateId) throws ApiException {
    Request request = this.buildDuplicateTemplateRequest(templateId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Template>() {});
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @return response of {@code Template}
   */
  public CompletableFuture<Template> duplicateTemplateAsync(@NonNull String templateId) throws ApiException {
    Request request = this.buildDuplicateTemplateRequest(templateId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Template>() {}));
  }

  private Request buildDuplicateTemplateRequest(@NonNull String templateId) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "template/{template_id}/duplicate")
      .setPathParameter("template_id", templateId)
      .build();
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param addTemplateDocumentRequest {@link AddTemplateDocumentRequest} Request Body
   * @return response of {@code Document}
   */
  public Document addTemplateDocument(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentRequest addTemplateDocumentRequest
  ) throws ApiException {
    Request request = this.buildAddTemplateDocumentRequest(templateId, addTemplateDocumentRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Document>() {});
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param addTemplateDocumentRequest {@link AddTemplateDocumentRequest} Request Body
   * @return response of {@code Document}
   */
  public CompletableFuture<Document> addTemplateDocumentAsync(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentRequest addTemplateDocumentRequest
  ) throws ApiException {
    Request request = this.buildAddTemplateDocumentRequest(templateId, addTemplateDocumentRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Document>() {}));
  }

  private Request buildAddTemplateDocumentRequest(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentRequest addTemplateDocumentRequest
  ) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "template/{template_id}/document")
      .setPathParameter("template_id", templateId)
      .setJsonContent(addTemplateDocumentRequest)
      .build();
  }

  /**
   * Get template document
   *
   * @param templateId String
   * @param documentId String
   * @return response of {@code Document}
   */
  public Document getTemplateDocument(@NonNull String templateId, @NonNull String documentId) throws ApiException {
    Request request = this.buildGetTemplateDocumentRequest(templateId, documentId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Document>() {});
  }

  /**
   * Get template document
   *
   * @param templateId String
   * @param documentId String
   * @return response of {@code Document}
   */
  public CompletableFuture<Document> getTemplateDocumentAsync(@NonNull String templateId, @NonNull String documentId)
    throws ApiException {
    Request request = this.buildGetTemplateDocumentRequest(templateId, documentId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Document>() {}));
  }

  private Request buildGetTemplateDocumentRequest(@NonNull String templateId, @NonNull String documentId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "template/{template_id}/document/{document_id}")
      .setPathParameter("template_id", templateId)
      .setPathParameter("document_id", documentId)
      .build();
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @return response of {@code ListTemplateDocumentsResponse}
   */
  public ListTemplateDocumentsResponse getTemplateDocuments(@NonNull String templateId) throws ApiException {
    Request request = this.buildGetTemplateDocumentsRequest(templateId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ListTemplateDocumentsResponse>() {});
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @return response of {@code ListTemplateDocumentsResponse}
   */
  public CompletableFuture<ListTemplateDocumentsResponse> getTemplateDocumentsAsync(@NonNull String templateId)
    throws ApiException {
    Request request = this.buildGetTemplateDocumentsRequest(templateId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res ->
      ModelConverter.convert(res, new TypeReference<ListTemplateDocumentsResponse>() {})
    );
  }

  private Request buildGetTemplateDocumentsRequest(@NonNull String templateId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "template/{template_id}/documents")
      .setPathParameter("template_id", templateId)
      .build();
  }

  /**
   * Add template signing steps
   *
   * @param templateId String
   * @param addTemplateSigningStepsRequest {@link AddTemplateSigningStepsRequest} Request Body
   * @return response of {@code Template}
   */
  public Template addTemplateSigningSteps(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsRequest addTemplateSigningStepsRequest
  ) throws ApiException {
    Request request = this.buildAddTemplateSigningStepsRequest(templateId, addTemplateSigningStepsRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Template>() {});
  }

  /**
   * Add template signing steps
   *
   * @param templateId String
   * @param addTemplateSigningStepsRequest {@link AddTemplateSigningStepsRequest} Request Body
   * @return response of {@code Template}
   */
  public CompletableFuture<Template> addTemplateSigningStepsAsync(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsRequest addTemplateSigningStepsRequest
  ) throws ApiException {
    Request request = this.buildAddTemplateSigningStepsRequest(templateId, addTemplateSigningStepsRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Template>() {}));
  }

  private Request buildAddTemplateSigningStepsRequest(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsRequest addTemplateSigningStepsRequest
  ) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "template/{template_id}/signing_steps")
      .setPathParameter("template_id", templateId)
      .setJsonContent(addTemplateSigningStepsRequest)
      .build();
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param renameTemplateRequest {@link RenameTemplateRequest} Request Body
   * @return response of {@code Template}
   */
  public Template renameTemplate(@NonNull String templateId, @NonNull RenameTemplateRequest renameTemplateRequest)
    throws ApiException {
    Request request = this.buildRenameTemplateRequest(templateId, renameTemplateRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Template>() {});
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param renameTemplateRequest {@link RenameTemplateRequest} Request Body
   * @return response of {@code Template}
   */
  public CompletableFuture<Template> renameTemplateAsync(
    @NonNull String templateId,
    @NonNull RenameTemplateRequest renameTemplateRequest
  ) throws ApiException {
    Request request = this.buildRenameTemplateRequest(templateId, renameTemplateRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Template>() {}));
  }

  private Request buildRenameTemplateRequest(
    @NonNull String templateId,
    @NonNull RenameTemplateRequest renameTemplateRequest
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "template/{template_id}/rename")
      .setPathParameter("template_id", templateId)
      .setJsonContent(renameTemplateRequest)
      .build();
  }

  /**
   * Set template comment
   *
   * @param templateId String
   * @param setTemplateCommentRequest {@link SetTemplateCommentRequest} Request Body
   * @return response of {@code Template}
   */
  public Template setTemplateComment(
    @NonNull String templateId,
    @NonNull SetTemplateCommentRequest setTemplateCommentRequest
  ) throws ApiException {
    Request request = this.buildSetTemplateCommentRequest(templateId, setTemplateCommentRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Template>() {});
  }

  /**
   * Set template comment
   *
   * @param templateId String
   * @param setTemplateCommentRequest {@link SetTemplateCommentRequest} Request Body
   * @return response of {@code Template}
   */
  public CompletableFuture<Template> setTemplateCommentAsync(
    @NonNull String templateId,
    @NonNull SetTemplateCommentRequest setTemplateCommentRequest
  ) throws ApiException {
    Request request = this.buildSetTemplateCommentRequest(templateId, setTemplateCommentRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Template>() {}));
  }

  private Request buildSetTemplateCommentRequest(
    @NonNull String templateId,
    @NonNull SetTemplateCommentRequest setTemplateCommentRequest
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "template/{template_id}/set_comment")
      .setPathParameter("template_id", templateId)
      .setJsonContent(setTemplateCommentRequest)
      .build();
  }

  /**
   * Set template notification
   *
   * @param templateId String
   * @param envelopeNotification {@link EnvelopeNotification} Request Body
   * @return response of {@code Template}
   */
  public Template setTemplateNotification(
    @NonNull String templateId,
    @NonNull EnvelopeNotification envelopeNotification
  ) throws ApiException {
    Request request = this.buildSetTemplateNotificationRequest(templateId, envelopeNotification);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Template>() {});
  }

  /**
   * Set template notification
   *
   * @param templateId String
   * @param envelopeNotification {@link EnvelopeNotification} Request Body
   * @return response of {@code Template}
   */
  public CompletableFuture<Template> setTemplateNotificationAsync(
    @NonNull String templateId,
    @NonNull EnvelopeNotification envelopeNotification
  ) throws ApiException {
    Request request = this.buildSetTemplateNotificationRequest(templateId, envelopeNotification);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Template>() {}));
  }

  private Request buildSetTemplateNotificationRequest(
    @NonNull String templateId,
    @NonNull EnvelopeNotification envelopeNotification
  ) {
    return new RequestBuilder(HttpMethod.PUT, this.serverUrl, "template/{template_id}/set_notification")
      .setPathParameter("template_id", templateId)
      .setJsonContent(envelopeNotification)
      .build();
  }

  /**
   * Get template annotations
   *
   * @param templateId String ID of the template
   * @return response of {@code ListTemplateAnnotationsResponse}
   */
  public ListTemplateAnnotationsResponse getTemplateAnnotations(@NonNull String templateId) throws ApiException {
    Request request = this.buildGetTemplateAnnotationsRequest(templateId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ListTemplateAnnotationsResponse>() {});
  }

  /**
   * Get template annotations
   *
   * @param templateId String ID of the template
   * @return response of {@code ListTemplateAnnotationsResponse}
   */
  public CompletableFuture<ListTemplateAnnotationsResponse> getTemplateAnnotationsAsync(@NonNull String templateId)
    throws ApiException {
    Request request = this.buildGetTemplateAnnotationsRequest(templateId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res ->
      ModelConverter.convert(res, new TypeReference<ListTemplateAnnotationsResponse>() {})
    );
  }

  private Request buildGetTemplateAnnotationsRequest(@NonNull String templateId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "template/{template_id}/annotations")
      .setPathParameter("template_id", templateId)
      .build();
  }

  /**
   * Get document template annotations
   *
   * @param templateId String ID of the template
   * @param documentId String ID of document
   * @return response of {@code ListTemplateDocumentAnnotationsResponse}
   */
  public ListTemplateDocumentAnnotationsResponse getDocumentTemplateAnnotations(
    @NonNull String templateId,
    @NonNull String documentId
  ) throws ApiException {
    Request request = this.buildGetDocumentTemplateAnnotationsRequest(templateId, documentId);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ListTemplateDocumentAnnotationsResponse>() {});
  }

  /**
   * Get document template annotations
   *
   * @param templateId String ID of the template
   * @param documentId String ID of document
   * @return response of {@code ListTemplateDocumentAnnotationsResponse}
   */
  public CompletableFuture<ListTemplateDocumentAnnotationsResponse> getDocumentTemplateAnnotationsAsync(
    @NonNull String templateId,
    @NonNull String documentId
  ) throws ApiException {
    Request request = this.buildGetDocumentTemplateAnnotationsRequest(templateId, documentId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res ->
      ModelConverter.convert(res, new TypeReference<ListTemplateDocumentAnnotationsResponse>() {})
    );
  }

  private Request buildGetDocumentTemplateAnnotationsRequest(@NonNull String templateId, @NonNull String documentId) {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "template/{template_id}/annotations/{document_id}")
      .setPathParameter("template_id", templateId)
      .setPathParameter("document_id", documentId)
      .build();
  }

  /**
   * Add template annotation
   *
   * @param templateId String ID of the template
   * @param addAnnotationRequest {@link AddAnnotationRequest} Request Body
   * @return response of {@code Annotation}
   */
  public Annotation addTemplateAnnotation(
    @NonNull String templateId,
    @NonNull AddAnnotationRequest addAnnotationRequest
  ) throws ApiException {
    Request request = this.buildAddTemplateAnnotationRequest(templateId, addAnnotationRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Annotation>() {});
  }

  /**
   * Add template annotation
   *
   * @param templateId String ID of the template
   * @param addAnnotationRequest {@link AddAnnotationRequest} Request Body
   * @return response of {@code Annotation}
   */
  public CompletableFuture<Annotation> addTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull AddAnnotationRequest addAnnotationRequest
  ) throws ApiException {
    Request request = this.buildAddTemplateAnnotationRequest(templateId, addAnnotationRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Annotation>() {}));
  }

  private Request buildAddTemplateAnnotationRequest(
    @NonNull String templateId,
    @NonNull AddAnnotationRequest addAnnotationRequest
  ) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "template/{template_id}/annotation")
      .setPathParameter("template_id", templateId)
      .setJsonContent(addAnnotationRequest)
      .build();
  }

  /**
   * Delete template annotation
   *
   * @param templateId String ID of the template
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code Void}
   */
  public void deleteTemplateAnnotation(@NonNull String templateId, @NonNull String annotationId) throws ApiException {
    Request request = this.buildDeleteTemplateAnnotationRequest(templateId, annotationId);
    this.execute(request);
  }

  /**
   * Delete template annotation
   *
   * @param templateId String ID of the template
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull String annotationId
  ) throws ApiException {
    Request request = this.buildDeleteTemplateAnnotationRequest(templateId, annotationId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteTemplateAnnotationRequest(@NonNull String templateId, @NonNull String annotationId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "template/{template_id}/annotation/{annotation_id}")
      .setPathParameter("template_id", templateId)
      .setPathParameter("annotation_id", annotationId)
      .build();
  }

  /**
   * Create webhook
   *
   * @param createWebhookRequest {@link CreateWebhookRequest} Request Body
   * @return response of {@code Webhook}
   */
  public Webhook createWebhook(@NonNull CreateWebhookRequest createWebhookRequest) throws ApiException {
    Request request = this.buildCreateWebhookRequest(createWebhookRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<Webhook>() {});
  }

  /**
   * Create webhook
   *
   * @param createWebhookRequest {@link CreateWebhookRequest} Request Body
   * @return response of {@code Webhook}
   */
  public CompletableFuture<Webhook> createWebhookAsync(@NonNull CreateWebhookRequest createWebhookRequest)
    throws ApiException {
    Request request = this.buildCreateWebhookRequest(createWebhookRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<Webhook>() {}));
  }

  private Request buildCreateWebhookRequest(@NonNull CreateWebhookRequest createWebhookRequest) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "webhook").setJsonContent(createWebhookRequest).build();
  }

  /**
   * List webhooks
   *
   * @return response of {@code ListWebhooksResponse}
   */
  public ListWebhooksResponse listWebhooks() throws ApiException {
    return listWebhooks(ListWebhooksRequest.builder().build());
  }

  /**
   * List webhooks
   *
   * @param listWebhooksRequest {@link ListWebhooksRequest} Request Body
   * @return response of {@code ListWebhooksResponse}
   */
  public ListWebhooksResponse listWebhooks(@NonNull ListWebhooksRequest listWebhooksRequest) throws ApiException {
    Request request = this.buildListWebhooksRequest(listWebhooksRequest);
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ListWebhooksResponse>() {});
  }

  /**
   * List webhooks
   *
   * @return response of {@code ListWebhooksResponse}
   */
  public CompletableFuture<ListWebhooksResponse> listWebhooksAsync() throws ApiException {
    return listWebhooksAsync(ListWebhooksRequest.builder().build());
  }

  /**
   * List webhooks
   *
   * @param listWebhooksRequest {@link ListWebhooksRequest} Request Body
   * @return response of {@code ListWebhooksResponse}
   */
  public CompletableFuture<ListWebhooksResponse> listWebhooksAsync(@NonNull ListWebhooksRequest listWebhooksRequest)
    throws ApiException {
    Request request = this.buildListWebhooksRequest(listWebhooksRequest);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> ModelConverter.convert(res, new TypeReference<ListWebhooksResponse>() {}));
  }

  private Request buildListWebhooksRequest(@NonNull ListWebhooksRequest listWebhooksRequest) {
    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "webhooks").setJsonContent(listWebhooksRequest).build();
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code Void}
   */
  public void deleteWebhook(@NonNull String webhookId) throws ApiException {
    Request request = this.buildDeleteWebhookRequest(webhookId);
    this.execute(request);
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> deleteWebhookAsync(@NonNull String webhookId) throws ApiException {
    Request request = this.buildDeleteWebhookRequest(webhookId);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildDeleteWebhookRequest(@NonNull String webhookId) {
    return new RequestBuilder(HttpMethod.DELETE, this.serverUrl, "webhook/{webhook_id}")
      .setPathParameter("webhook_id", webhookId)
      .build();
  }
}
