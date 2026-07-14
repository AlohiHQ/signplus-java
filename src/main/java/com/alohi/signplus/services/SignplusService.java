package com.alohi.signplus.services;

import com.alohi.signplus.config.RequestConfig;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.exceptions.ApiError;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.HttpMethod;
import com.alohi.signplus.http.ModelConverter;
import com.alohi.signplus.http.util.RequestBuilder;
import com.alohi.signplus.models.AddAnnotationRequest;
import com.alohi.signplus.models.AddEnvelopeDocumentRequest;
import com.alohi.signplus.models.AddEnvelopeSigningStepsRequest;
import com.alohi.signplus.models.AddTemplateDocumentRequest;
import com.alohi.signplus.models.AddTemplateSigningStepsRequest;
import com.alohi.signplus.models.Annotation;
import com.alohi.signplus.models.CreateEnvelopeFromTemplateRequest;
import com.alohi.signplus.models.CreateEnvelopeRequest;
import com.alohi.signplus.models.CreateTemplateRequest;
import com.alohi.signplus.models.CreateWebhookRequest;
import com.alohi.signplus.models.Document;
import com.alohi.signplus.models.DownloadEnvelopeSignedDocumentsParameters;
import com.alohi.signplus.models.Envelope;
import com.alohi.signplus.models.EnvelopeAttachments;
import com.alohi.signplus.models.EnvelopeNotification;
import com.alohi.signplus.models.ListEnvelopeDocumentAnnotationsResponse;
import com.alohi.signplus.models.ListEnvelopeDocumentsResponse;
import com.alohi.signplus.models.ListEnvelopesRequest;
import com.alohi.signplus.models.ListEnvelopesResponse;
import com.alohi.signplus.models.ListTemplateAnnotationsResponse;
import com.alohi.signplus.models.ListTemplateDocumentAnnotationsResponse;
import com.alohi.signplus.models.ListTemplateDocumentsResponse;
import com.alohi.signplus.models.ListTemplatesRequest;
import com.alohi.signplus.models.ListTemplatesResponse;
import com.alohi.signplus.models.ListWebhooksRequest;
import com.alohi.signplus.models.ListWebhooksResponse;
import com.alohi.signplus.models.RenameEnvelopeRequest;
import com.alohi.signplus.models.RenameTemplateRequest;
import com.alohi.signplus.models.SetEnvelopeAttachmentsPlaceholdersRequest;
import com.alohi.signplus.models.SetEnvelopeAttachmentsSettingsRequest;
import com.alohi.signplus.models.SetEnvelopeCommentRequest;
import com.alohi.signplus.models.SetEnvelopeDynamicFieldsRequest;
import com.alohi.signplus.models.SetEnvelopeExpirationRequest;
import com.alohi.signplus.models.SetEnvelopeLegalityLevelRequest;
import com.alohi.signplus.models.SetTemplateCommentRequest;
import com.alohi.signplus.models.Template;
import com.alohi.signplus.models.Webhook;
import com.alohi.signplus.validation.ViolationAggregator;
import com.alohi.signplus.validation.exceptions.ValidationException;
import com.alohi.signplus.validation.validators.modelValidators.CreateEnvelopeFromTemplateRequestValidator;
import com.alohi.signplus.validation.validators.modelValidators.CreateEnvelopeRequestValidator;
import com.alohi.signplus.validation.validators.modelValidators.CreateTemplateRequestValidator;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
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
 * SignplusService Service
 */
public class SignplusService extends BaseService {

  private RequestConfig createEnvelopeConfig;
  private RequestConfig createEnvelopeFromTemplateConfig;
  private RequestConfig listEnvelopesConfig;
  private RequestConfig getEnvelopeConfig;
  private RequestConfig deleteEnvelopeConfig;
  private RequestConfig downloadEnvelopeSignedDocumentsConfig;
  private RequestConfig downloadEnvelopeCertificateConfig;
  private RequestConfig getEnvelopeDocumentConfig;
  private RequestConfig getEnvelopeDocumentsConfig;
  private RequestConfig addEnvelopeDocumentConfig;
  private RequestConfig setEnvelopeDynamicFieldsConfig;
  private RequestConfig addEnvelopeSigningStepsConfig;
  private RequestConfig setEnvelopeAttachmentsSettingsConfig;
  private RequestConfig setEnvelopeAttachmentsPlaceholdersConfig;
  private RequestConfig getAttachmentFileConfig;
  private RequestConfig sendEnvelopeConfig;
  private RequestConfig duplicateEnvelopeConfig;
  private RequestConfig voidEnvelopeConfig;
  private RequestConfig renameEnvelopeConfig;
  private RequestConfig setEnvelopeCommentConfig;
  private RequestConfig setEnvelopeNotificationConfig;
  private RequestConfig setEnvelopeExpirationDateConfig;
  private RequestConfig setEnvelopeLegalityLevelConfig;
  private RequestConfig getEnvelopeAnnotationsConfig;
  private RequestConfig getEnvelopeDocumentAnnotationsConfig;
  private RequestConfig addEnvelopeAnnotationConfig;
  private RequestConfig deleteEnvelopeAnnotationConfig;
  private RequestConfig createTemplateConfig;
  private RequestConfig listTemplatesConfig;
  private RequestConfig getTemplateConfig;
  private RequestConfig deleteTemplateConfig;
  private RequestConfig duplicateTemplateConfig;
  private RequestConfig addTemplateDocumentConfig;
  private RequestConfig getTemplateDocumentConfig;
  private RequestConfig getTemplateDocumentsConfig;
  private RequestConfig addTemplateSigningStepsConfig;
  private RequestConfig renameTemplateConfig;
  private RequestConfig setTemplateCommentConfig;
  private RequestConfig setTemplateNotificationConfig;
  private RequestConfig getTemplateAnnotationsConfig;
  private RequestConfig getDocumentTemplateAnnotationsConfig;
  private RequestConfig addTemplateAnnotationConfig;
  private RequestConfig deleteTemplateAnnotationConfig;
  private RequestConfig setTemplateAttachmentsSettingsConfig;
  private RequestConfig setTemplateAttachmentsPlaceholdersConfig;
  private RequestConfig createWebhookConfig;
  private RequestConfig listWebhooksConfig;
  private RequestConfig deleteWebhookConfig;

  /**
   * Constructs a new instance of SignplusService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public SignplusService(@NonNull OkHttpClient httpClient, SignplusConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setCreateEnvelopeConfig(RequestConfig config) {
    this.createEnvelopeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createEnvelopeFromTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setCreateEnvelopeFromTemplateConfig(RequestConfig config) {
    this.createEnvelopeFromTemplateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listEnvelopes}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setListEnvelopesConfig(RequestConfig config) {
    this.listEnvelopesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetEnvelopeConfig(RequestConfig config) {
    this.getEnvelopeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDeleteEnvelopeConfig(RequestConfig config) {
    this.deleteEnvelopeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code downloadEnvelopeSignedDocuments}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDownloadEnvelopeSignedDocumentsConfig(RequestConfig config) {
    this.downloadEnvelopeSignedDocumentsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code downloadEnvelopeCertificate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDownloadEnvelopeCertificateConfig(RequestConfig config) {
    this.downloadEnvelopeCertificateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getEnvelopeDocument}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetEnvelopeDocumentConfig(RequestConfig config) {
    this.getEnvelopeDocumentConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getEnvelopeDocuments}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetEnvelopeDocumentsConfig(RequestConfig config) {
    this.getEnvelopeDocumentsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code addEnvelopeDocument}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setAddEnvelopeDocumentConfig(RequestConfig config) {
    this.addEnvelopeDocumentConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeDynamicFields}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetEnvelopeDynamicFieldsConfig(RequestConfig config) {
    this.setEnvelopeDynamicFieldsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code addEnvelopeSigningSteps}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setAddEnvelopeSigningStepsConfig(RequestConfig config) {
    this.addEnvelopeSigningStepsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeAttachmentsSettings}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetEnvelopeAttachmentsSettingsConfig(RequestConfig config) {
    this.setEnvelopeAttachmentsSettingsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeAttachmentsPlaceholders}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetEnvelopeAttachmentsPlaceholdersConfig(RequestConfig config) {
    this.setEnvelopeAttachmentsPlaceholdersConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getAttachmentFile}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetAttachmentFileConfig(RequestConfig config) {
    this.getAttachmentFileConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code sendEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSendEnvelopeConfig(RequestConfig config) {
    this.sendEnvelopeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code duplicateEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDuplicateEnvelopeConfig(RequestConfig config) {
    this.duplicateEnvelopeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code voidEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setVoidEnvelopeConfig(RequestConfig config) {
    this.voidEnvelopeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code renameEnvelope}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setRenameEnvelopeConfig(RequestConfig config) {
    this.renameEnvelopeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeComment}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetEnvelopeCommentConfig(RequestConfig config) {
    this.setEnvelopeCommentConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeNotification}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetEnvelopeNotificationConfig(RequestConfig config) {
    this.setEnvelopeNotificationConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeExpirationDate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetEnvelopeExpirationDateConfig(RequestConfig config) {
    this.setEnvelopeExpirationDateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setEnvelopeLegalityLevel}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetEnvelopeLegalityLevelConfig(RequestConfig config) {
    this.setEnvelopeLegalityLevelConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getEnvelopeAnnotations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetEnvelopeAnnotationsConfig(RequestConfig config) {
    this.getEnvelopeAnnotationsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getEnvelopeDocumentAnnotations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetEnvelopeDocumentAnnotationsConfig(RequestConfig config) {
    this.getEnvelopeDocumentAnnotationsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code addEnvelopeAnnotation}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setAddEnvelopeAnnotationConfig(RequestConfig config) {
    this.addEnvelopeAnnotationConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteEnvelopeAnnotation}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDeleteEnvelopeAnnotationConfig(RequestConfig config) {
    this.deleteEnvelopeAnnotationConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setCreateTemplateConfig(RequestConfig config) {
    this.createTemplateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listTemplates}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setListTemplatesConfig(RequestConfig config) {
    this.listTemplatesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetTemplateConfig(RequestConfig config) {
    this.getTemplateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDeleteTemplateConfig(RequestConfig config) {
    this.deleteTemplateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code duplicateTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDuplicateTemplateConfig(RequestConfig config) {
    this.duplicateTemplateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code addTemplateDocument}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setAddTemplateDocumentConfig(RequestConfig config) {
    this.addTemplateDocumentConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getTemplateDocument}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetTemplateDocumentConfig(RequestConfig config) {
    this.getTemplateDocumentConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getTemplateDocuments}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetTemplateDocumentsConfig(RequestConfig config) {
    this.getTemplateDocumentsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code addTemplateSigningSteps}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setAddTemplateSigningStepsConfig(RequestConfig config) {
    this.addTemplateSigningStepsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code renameTemplate}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setRenameTemplateConfig(RequestConfig config) {
    this.renameTemplateConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setTemplateComment}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetTemplateCommentConfig(RequestConfig config) {
    this.setTemplateCommentConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setTemplateNotification}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetTemplateNotificationConfig(RequestConfig config) {
    this.setTemplateNotificationConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getTemplateAnnotations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetTemplateAnnotationsConfig(RequestConfig config) {
    this.getTemplateAnnotationsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getDocumentTemplateAnnotations}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setGetDocumentTemplateAnnotationsConfig(RequestConfig config) {
    this.getDocumentTemplateAnnotationsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code addTemplateAnnotation}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setAddTemplateAnnotationConfig(RequestConfig config) {
    this.addTemplateAnnotationConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteTemplateAnnotation}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDeleteTemplateAnnotationConfig(RequestConfig config) {
    this.deleteTemplateAnnotationConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setTemplateAttachmentsSettings}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetTemplateAttachmentsSettingsConfig(RequestConfig config) {
    this.setTemplateAttachmentsSettingsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code setTemplateAttachmentsPlaceholders}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setSetTemplateAttachmentsPlaceholdersConfig(RequestConfig config) {
    this.setTemplateAttachmentsPlaceholdersConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createWebhook}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setCreateWebhookConfig(RequestConfig config) {
    this.createWebhookConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listWebhooks}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setListWebhooksConfig(RequestConfig config) {
    this.listWebhooksConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteWebhook}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public SignplusService setDeleteWebhookConfig(RequestConfig config) {
    this.deleteWebhookConfig = config;
    return this;
  }

  /**
   * Create new envelope
   *
   * @param createEnvelopeRequest {@link CreateEnvelopeRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope createEnvelope(@NonNull CreateEnvelopeRequest createEnvelopeRequest)
    throws ApiError, ValidationException {
    return this.createEnvelope(createEnvelopeRequest, null);
  }

  /**
   * Create new envelope
   *
   * @param createEnvelopeRequest {@link CreateEnvelopeRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope createEnvelope(
    @NonNull CreateEnvelopeRequest createEnvelopeRequest,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createEnvelopeConfig, requestConfig);
    Request request = this.buildCreateEnvelopeRequest(createEnvelopeRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Create new envelope
   *
   * @param createEnvelopeRequest {@link CreateEnvelopeRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> createEnvelopeAsync(
    @NonNull CreateEnvelopeRequest createEnvelopeRequest
  ) throws ApiError, ValidationException {
    return this.createEnvelopeAsync(createEnvelopeRequest, null);
  }

  /**
   * Create new envelope
   *
   * @param createEnvelopeRequest {@link CreateEnvelopeRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> createEnvelopeAsync(
    @NonNull CreateEnvelopeRequest createEnvelopeRequest,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createEnvelopeConfig, requestConfig);
    Request request = this.buildCreateEnvelopeRequest(createEnvelopeRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildCreateEnvelopeRequest(
    @NonNull CreateEnvelopeRequest createEnvelopeRequest,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new CreateEnvelopeRequestValidator("createEnvelopeRequest")
          .required()
          .validate(createEnvelopeRequest)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError, ValidationException {
    return this.createEnvelopeFromTemplate(templateId, createEnvelopeFromTemplateRequest, null);
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
    @NonNull CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.createEnvelopeFromTemplateConfig, requestConfig);
    Request request =
      this.buildCreateEnvelopeFromTemplateRequest(
          templateId,
          createEnvelopeFromTemplateRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Create new envelope from template
   *
   * @param templateId String
   * @param createEnvelopeFromTemplateRequest {@link CreateEnvelopeFromTemplateRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> createEnvelopeFromTemplateAsync(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest
  ) throws ApiError, ValidationException {
    return this.createEnvelopeFromTemplateAsync(
        templateId,
        createEnvelopeFromTemplateRequest,
        null
      );
  }

  /**
   * Create new envelope from template
   *
   * @param templateId String
   * @param createEnvelopeFromTemplateRequest {@link CreateEnvelopeFromTemplateRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> createEnvelopeFromTemplateAsync(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.createEnvelopeFromTemplateConfig, requestConfig);
    Request request =
      this.buildCreateEnvelopeFromTemplateRequest(
          templateId,
          createEnvelopeFromTemplateRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildCreateEnvelopeFromTemplateRequest(
    @NonNull String templateId,
    @NonNull CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new CreateEnvelopeFromTemplateRequestValidator("createEnvelopeFromTemplateRequest")
          .required()
          .validate(createEnvelopeFromTemplateRequest)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/from_template/{template_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setJsonContent(createEnvelopeFromTemplateRequest)
      .build();
  }

  /**
   * List envelopes
   *
   * @return response of {@code ListEnvelopesResponse}
   */
  public ListEnvelopesResponse listEnvelopes() throws ApiError {
    return this.listEnvelopes(ListEnvelopesRequest.builder().build());
  }

  /**
   * List envelopes
   *
   * @param listEnvelopesRequest {@link ListEnvelopesRequest} Request Body
   * @return response of {@code ListEnvelopesResponse}
   */
  public ListEnvelopesResponse listEnvelopes(@NonNull ListEnvelopesRequest listEnvelopesRequest)
    throws ApiError {
    return this.listEnvelopes(listEnvelopesRequest, null);
  }

  /**
   * List envelopes
   *
   * @param listEnvelopesRequest {@link ListEnvelopesRequest} Request Body
   * @return response of {@code ListEnvelopesResponse}
   */
  public ListEnvelopesResponse listEnvelopes(
    @NonNull ListEnvelopesRequest listEnvelopesRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listEnvelopesConfig, requestConfig);
    Request request = this.buildListEnvelopesRequest(listEnvelopesRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ListEnvelopesResponse>() {});
  }

  /**
   * List envelopes
   *
   * @return response of {@code CompletableFuture<ListEnvelopesResponse>}
   */
  public CompletableFuture<ListEnvelopesResponse> listEnvelopesAsync() throws ApiError {
    return this.listEnvelopesAsync(ListEnvelopesRequest.builder().build());
  }

  /**
   * List envelopes
   *
   * @param listEnvelopesRequest {@link ListEnvelopesRequest} Request Body
   * @return response of {@code CompletableFuture<ListEnvelopesResponse>}
   */
  public CompletableFuture<ListEnvelopesResponse> listEnvelopesAsync(
    @NonNull ListEnvelopesRequest listEnvelopesRequest
  ) throws ApiError {
    return this.listEnvelopesAsync(listEnvelopesRequest, null);
  }

  /**
   * List envelopes
   *
   * @param listEnvelopesRequest {@link ListEnvelopesRequest} Request Body
   * @return response of {@code CompletableFuture<ListEnvelopesResponse>}
   */
  public CompletableFuture<ListEnvelopesResponse> listEnvelopesAsync(
    @NonNull ListEnvelopesRequest listEnvelopesRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listEnvelopesConfig, requestConfig);
    Request request = this.buildListEnvelopesRequest(listEnvelopesRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ListEnvelopesResponse>() {});
    });
  }

  private Request buildListEnvelopesRequest(
    @NonNull ListEnvelopesRequest listEnvelopesRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelopes"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(listEnvelopesRequest)
      .build();
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope getEnvelope(@NonNull String envelopeId) throws ApiError {
    return this.getEnvelope(envelopeId, null);
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope getEnvelope(@NonNull String envelopeId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEnvelopeConfig, requestConfig);
    Request request = this.buildGetEnvelopeRequest(envelopeId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> getEnvelopeAsync(@NonNull String envelopeId) throws ApiError {
    return this.getEnvelopeAsync(envelopeId, null);
  }

  /**
   * Get envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> getEnvelopeAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getEnvelopeConfig, requestConfig);
    Request request = this.buildGetEnvelopeRequest(envelopeId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildGetEnvelopeRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code void}
   */
  public void deleteEnvelope(@NonNull String envelopeId) throws ApiError {
    this.deleteEnvelope(envelopeId, null);
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code void}
   */
  public void deleteEnvelope(@NonNull String envelopeId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteEnvelopeConfig, requestConfig);
    Request request = this.buildDeleteEnvelopeRequest(envelopeId, resolvedConfig);
    this.execute(request, resolvedConfig);
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteEnvelopeAsync(@NonNull String envelopeId) throws ApiError {
    return this.deleteEnvelopeAsync(envelopeId, null);
  }

  /**
   * Delete envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteEnvelopeAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteEnvelopeConfig, requestConfig);
    Request request = this.buildDeleteEnvelopeRequest(envelopeId, resolvedConfig);
    return this.executeAsync(request, resolvedConfig).thenApplyAsync(response -> null);
  }

  private Request buildDeleteEnvelopeRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Download signed documents for an envelope
   *
   * @param envelopeId String ID of the envelope
   * @param requestParameters {@link DownloadEnvelopeSignedDocumentsParameters} Request Parameters Object
   * @return response of {@code byte[]}
   */
  public byte[] downloadEnvelopeSignedDocuments(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeSignedDocumentsParameters requestParameters
  ) throws ApiError {
    return this.downloadEnvelopeSignedDocuments(envelopeId, requestParameters, null);
  }

  /**
   * Download signed documents for an envelope
   *
   * @param envelopeId String ID of the envelope
   * @param requestParameters {@link DownloadEnvelopeSignedDocumentsParameters} Request Parameters Object
   * @return response of {@code byte[]}
   */
  public byte[] downloadEnvelopeSignedDocuments(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeSignedDocumentsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.downloadEnvelopeSignedDocumentsConfig, requestConfig);
    Request request =
      this.buildDownloadEnvelopeSignedDocumentsRequest(
          envelopeId,
          requestParameters,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return bodyBytes;
  }

  /**
   * Download signed documents for an envelope
   *
   * @param envelopeId String ID of the envelope
   * @param requestParameters {@link DownloadEnvelopeSignedDocumentsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<byte[]>}
   */
  public CompletableFuture<byte[]> downloadEnvelopeSignedDocumentsAsync(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeSignedDocumentsParameters requestParameters
  ) throws ApiError {
    return this.downloadEnvelopeSignedDocumentsAsync(envelopeId, requestParameters, null);
  }

  /**
   * Download signed documents for an envelope
   *
   * @param envelopeId String ID of the envelope
   * @param requestParameters {@link DownloadEnvelopeSignedDocumentsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<byte[]>}
   */
  public CompletableFuture<byte[]> downloadEnvelopeSignedDocumentsAsync(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeSignedDocumentsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.downloadEnvelopeSignedDocumentsConfig, requestConfig);
    Request request =
      this.buildDownloadEnvelopeSignedDocumentsRequest(
          envelopeId,
          requestParameters,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return bodyBytes;
    });
  }

  private Request buildDownloadEnvelopeSignedDocumentsRequest(
    @NonNull String envelopeId,
    @NonNull DownloadEnvelopeSignedDocumentsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/signed_documents"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setOptionalQueryParameter(
        "certificate_of_completion",
        requestParameters.getCertificateOfCompletion()
      )
      .build();
  }

  /**
   * Download certificate of completion for an envelope
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code byte[]}
   */
  public byte[] downloadEnvelopeCertificate(@NonNull String envelopeId) throws ApiError {
    return this.downloadEnvelopeCertificate(envelopeId, null);
  }

  /**
   * Download certificate of completion for an envelope
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code byte[]}
   */
  public byte[] downloadEnvelopeCertificate(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.downloadEnvelopeCertificateConfig, requestConfig);
    Request request = this.buildDownloadEnvelopeCertificateRequest(envelopeId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return bodyBytes;
  }

  /**
   * Download certificate of completion for an envelope
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code CompletableFuture<byte[]>}
   */
  public CompletableFuture<byte[]> downloadEnvelopeCertificateAsync(@NonNull String envelopeId)
    throws ApiError {
    return this.downloadEnvelopeCertificateAsync(envelopeId, null);
  }

  /**
   * Download certificate of completion for an envelope
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code CompletableFuture<byte[]>}
   */
  public CompletableFuture<byte[]> downloadEnvelopeCertificateAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.downloadEnvelopeCertificateConfig, requestConfig);
    Request request = this.buildDownloadEnvelopeCertificateRequest(envelopeId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return bodyBytes;
    });
  }

  private Request buildDownloadEnvelopeCertificateRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/certificate"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  public Document getEnvelopeDocument(@NonNull String envelopeId, @NonNull String documentId)
    throws ApiError {
    return this.getEnvelopeDocument(envelopeId, documentId, null);
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @return response of {@code Document}
   */
  public Document getEnvelopeDocument(
    @NonNull String envelopeId,
    @NonNull String documentId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentConfig, requestConfig);
    Request request = this.buildGetEnvelopeDocumentRequest(envelopeId, documentId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Document>() {});
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @return response of {@code CompletableFuture<Document>}
   */
  public CompletableFuture<Document> getEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull String documentId
  ) throws ApiError {
    return this.getEnvelopeDocumentAsync(envelopeId, documentId, null);
  }

  /**
   * Get envelope document
   *
   * @param envelopeId String
   * @param documentId String
   * @return response of {@code CompletableFuture<Document>}
   */
  public CompletableFuture<Document> getEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull String documentId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentConfig, requestConfig);
    Request request = this.buildGetEnvelopeDocumentRequest(envelopeId, documentId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Document>() {});
    });
  }

  private Request buildGetEnvelopeDocumentRequest(
    @NonNull String envelopeId,
    @NonNull String documentId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/document/{document_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  public ListEnvelopeDocumentsResponse getEnvelopeDocuments(@NonNull String envelopeId)
    throws ApiError {
    return this.getEnvelopeDocuments(envelopeId, null);
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @return response of {@code ListEnvelopeDocumentsResponse}
   */
  public ListEnvelopeDocumentsResponse getEnvelopeDocuments(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentsConfig, requestConfig);
    Request request = this.buildGetEnvelopeDocumentsRequest(envelopeId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ListEnvelopeDocumentsResponse>() {});
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<ListEnvelopeDocumentsResponse>}
   */
  public CompletableFuture<ListEnvelopeDocumentsResponse> getEnvelopeDocumentsAsync(
    @NonNull String envelopeId
  ) throws ApiError {
    return this.getEnvelopeDocumentsAsync(envelopeId, null);
  }

  /**
   * Get envelope documents
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<ListEnvelopeDocumentsResponse>}
   */
  public CompletableFuture<ListEnvelopeDocumentsResponse> getEnvelopeDocumentsAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentsConfig, requestConfig);
    Request request = this.buildGetEnvelopeDocumentsRequest(envelopeId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(
        bodyBytes,
        new TypeReference<ListEnvelopeDocumentsResponse>() {}
      );
    });
  }

  private Request buildGetEnvelopeDocumentsRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/documents"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param addEnvelopeDocumentRequest {@link AddEnvelopeDocumentRequest} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code Document}
   */
  public Document addEnvelopeDocument(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentRequest addEnvelopeDocumentRequest,
    @NonNull String _filename
  ) throws ApiError {
    return this.addEnvelopeDocument(envelopeId, addEnvelopeDocumentRequest, _filename, null);
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param addEnvelopeDocumentRequest {@link AddEnvelopeDocumentRequest} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code Document}
   */
  public Document addEnvelopeDocument(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentRequest addEnvelopeDocumentRequest,
    @NonNull String _filename,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeDocumentConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeDocumentRequest(
          envelopeId,
          addEnvelopeDocumentRequest,
          _filename,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Document>() {});
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param addEnvelopeDocumentRequest {@link AddEnvelopeDocumentRequest} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<Document>}
   */
  public CompletableFuture<Document> addEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentRequest addEnvelopeDocumentRequest,
    @NonNull String _filename
  ) throws ApiError {
    return this.addEnvelopeDocumentAsync(envelopeId, addEnvelopeDocumentRequest, _filename, null);
  }

  /**
   * Add envelope document
   *
   * @param envelopeId String
   * @param addEnvelopeDocumentRequest {@link AddEnvelopeDocumentRequest} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<Document>}
   */
  public CompletableFuture<Document> addEnvelopeDocumentAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentRequest addEnvelopeDocumentRequest,
    @NonNull String _filename,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeDocumentConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeDocumentRequest(
          envelopeId,
          addEnvelopeDocumentRequest,
          _filename,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Document>() {});
    });
  }

  private Request buildAddEnvelopeDocumentRequest(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeDocumentRequest addEnvelopeDocumentRequest,
    @NonNull String _filename,
    RequestConfig resolvedConfig
  ) {
    MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder()
      .setType(MultipartBody.FORM);
    if (addEnvelopeDocumentRequest.getFile() != null) {
      multipartBodyBuilder.addFormDataPart(
        "file",
        _filename,
        RequestBody.create(
          addEnvelopeDocumentRequest.getFile(),
          MediaType.parse("application/octet-stream")
        )
      );
    }
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/document"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setBody(multipartBodyBuilder.build())
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
  ) throws ApiError {
    return this.setEnvelopeDynamicFields(envelopeId, setEnvelopeDynamicFieldsRequest, null);
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
    @NonNull SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeDynamicFieldsConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeDynamicFieldsRequest(
          envelopeId,
          setEnvelopeDynamicFieldsRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope dynamic fields
   *
   * @param envelopeId String
   * @param setEnvelopeDynamicFieldsRequest {@link SetEnvelopeDynamicFieldsRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeDynamicFieldsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest
  ) throws ApiError {
    return this.setEnvelopeDynamicFieldsAsync(envelopeId, setEnvelopeDynamicFieldsRequest, null);
  }

  /**
   * Set envelope dynamic fields
   *
   * @param envelopeId String
   * @param setEnvelopeDynamicFieldsRequest {@link SetEnvelopeDynamicFieldsRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeDynamicFieldsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeDynamicFieldsConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeDynamicFieldsRequest(
          envelopeId,
          setEnvelopeDynamicFieldsRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildSetEnvelopeDynamicFieldsRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/dynamic_fields"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.addEnvelopeSigningSteps(envelopeId, addEnvelopeSigningStepsRequest, null);
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
    @NonNull AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeSigningStepsConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeSigningStepsRequest(
          envelopeId,
          addEnvelopeSigningStepsRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Add envelope signing steps
   *
   * @param envelopeId String
   * @param addEnvelopeSigningStepsRequest {@link AddEnvelopeSigningStepsRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> addEnvelopeSigningStepsAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest
  ) throws ApiError {
    return this.addEnvelopeSigningStepsAsync(envelopeId, addEnvelopeSigningStepsRequest, null);
  }

  /**
   * Add envelope signing steps
   *
   * @param envelopeId String
   * @param addEnvelopeSigningStepsRequest {@link AddEnvelopeSigningStepsRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> addEnvelopeSigningStepsAsync(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeSigningStepsConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeSigningStepsRequest(
          envelopeId,
          addEnvelopeSigningStepsRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildAddEnvelopeSigningStepsRequest(
    @NonNull String envelopeId,
    @NonNull AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/signing_steps"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(addEnvelopeSigningStepsRequest)
      .build();
  }

  /**
   * Set envelope attachment settings
   *
   * @param envelopeId String
   * @param setEnvelopeAttachmentsSettingsRequest {@link SetEnvelopeAttachmentsSettingsRequest} Request Body
   * @return response of {@code EnvelopeAttachments}
   */
  public EnvelopeAttachments setEnvelopeAttachmentsSettings(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest
  ) throws ApiError {
    return this.setEnvelopeAttachmentsSettings(
        envelopeId,
        setEnvelopeAttachmentsSettingsRequest,
        null
      );
  }

  /**
   * Set envelope attachment settings
   *
   * @param envelopeId String
   * @param setEnvelopeAttachmentsSettingsRequest {@link SetEnvelopeAttachmentsSettingsRequest} Request Body
   * @return response of {@code EnvelopeAttachments}
   */
  public EnvelopeAttachments setEnvelopeAttachmentsSettings(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeAttachmentsSettingsConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeAttachmentsSettingsRequest(
          envelopeId,
          setEnvelopeAttachmentsSettingsRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<EnvelopeAttachments>() {});
  }

  /**
   * Set envelope attachment settings
   *
   * @param envelopeId String
   * @param setEnvelopeAttachmentsSettingsRequest {@link SetEnvelopeAttachmentsSettingsRequest} Request Body
   * @return response of {@code CompletableFuture<EnvelopeAttachments>}
   */
  public CompletableFuture<EnvelopeAttachments> setEnvelopeAttachmentsSettingsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest
  ) throws ApiError {
    return this.setEnvelopeAttachmentsSettingsAsync(
        envelopeId,
        setEnvelopeAttachmentsSettingsRequest,
        null
      );
  }

  /**
   * Set envelope attachment settings
   *
   * @param envelopeId String
   * @param setEnvelopeAttachmentsSettingsRequest {@link SetEnvelopeAttachmentsSettingsRequest} Request Body
   * @return response of {@code CompletableFuture<EnvelopeAttachments>}
   */
  public CompletableFuture<EnvelopeAttachments> setEnvelopeAttachmentsSettingsAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeAttachmentsSettingsConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeAttachmentsSettingsRequest(
          envelopeId,
          setEnvelopeAttachmentsSettingsRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<EnvelopeAttachments>() {});
    });
  }

  private Request buildSetEnvelopeAttachmentsSettingsRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/attachments/settings"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(setEnvelopeAttachmentsSettingsRequest)
      .build();
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param envelopeId String
   * @param setEnvelopeAttachmentsPlaceholdersRequest {@link SetEnvelopeAttachmentsPlaceholdersRequest} Request Body
   * @return response of {@code EnvelopeAttachments}
   */
  public EnvelopeAttachments setEnvelopeAttachmentsPlaceholders(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest
  ) throws ApiError {
    return this.setEnvelopeAttachmentsPlaceholders(
        envelopeId,
        setEnvelopeAttachmentsPlaceholdersRequest,
        null
      );
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param envelopeId String
   * @param setEnvelopeAttachmentsPlaceholdersRequest {@link SetEnvelopeAttachmentsPlaceholdersRequest} Request Body
   * @return response of {@code EnvelopeAttachments}
   */
  public EnvelopeAttachments setEnvelopeAttachmentsPlaceholders(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeAttachmentsPlaceholdersConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeAttachmentsPlaceholdersRequest(
          envelopeId,
          setEnvelopeAttachmentsPlaceholdersRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<EnvelopeAttachments>() {});
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param envelopeId String
   * @param setEnvelopeAttachmentsPlaceholdersRequest {@link SetEnvelopeAttachmentsPlaceholdersRequest} Request Body
   * @return response of {@code CompletableFuture<EnvelopeAttachments>}
   */
  public CompletableFuture<EnvelopeAttachments> setEnvelopeAttachmentsPlaceholdersAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest
  ) throws ApiError {
    return this.setEnvelopeAttachmentsPlaceholdersAsync(
        envelopeId,
        setEnvelopeAttachmentsPlaceholdersRequest,
        null
      );
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param envelopeId String
   * @param setEnvelopeAttachmentsPlaceholdersRequest {@link SetEnvelopeAttachmentsPlaceholdersRequest} Request Body
   * @return response of {@code CompletableFuture<EnvelopeAttachments>}
   */
  public CompletableFuture<EnvelopeAttachments> setEnvelopeAttachmentsPlaceholdersAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeAttachmentsPlaceholdersConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeAttachmentsPlaceholdersRequest(
          envelopeId,
          setEnvelopeAttachmentsPlaceholdersRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<EnvelopeAttachments>() {});
    });
  }

  private Request buildSetEnvelopeAttachmentsPlaceholdersRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/attachments/placeholders"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(setEnvelopeAttachmentsPlaceholdersRequest)
      .build();
  }

  /**
   * Get envelope attachment file
   *
   * @param envelopeId String
   * @param fileId String
   * @return response of {@code byte[]}
   */
  public byte[] getAttachmentFile(@NonNull String envelopeId, @NonNull String fileId)
    throws ApiError {
    return this.getAttachmentFile(envelopeId, fileId, null);
  }

  /**
   * Get envelope attachment file
   *
   * @param envelopeId String
   * @param fileId String
   * @return response of {@code byte[]}
   */
  public byte[] getAttachmentFile(
    @NonNull String envelopeId,
    @NonNull String fileId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getAttachmentFileConfig, requestConfig);
    Request request = this.buildGetAttachmentFileRequest(envelopeId, fileId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return bodyBytes;
  }

  /**
   * Get envelope attachment file
   *
   * @param envelopeId String
   * @param fileId String
   * @return response of {@code CompletableFuture<byte[]>}
   */
  public CompletableFuture<byte[]> getAttachmentFileAsync(
    @NonNull String envelopeId,
    @NonNull String fileId
  ) throws ApiError {
    return this.getAttachmentFileAsync(envelopeId, fileId, null);
  }

  /**
   * Get envelope attachment file
   *
   * @param envelopeId String
   * @param fileId String
   * @return response of {@code CompletableFuture<byte[]>}
   */
  public CompletableFuture<byte[]> getAttachmentFileAsync(
    @NonNull String envelopeId,
    @NonNull String fileId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getAttachmentFileConfig, requestConfig);
    Request request = this.buildGetAttachmentFileRequest(envelopeId, fileId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return bodyBytes;
    });
  }

  private Request buildGetAttachmentFileRequest(
    @NonNull String envelopeId,
    @NonNull String fileId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/attachments/{file_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setPathParameter("file_id", fileId)
      .build();
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope sendEnvelope(@NonNull String envelopeId) throws ApiError {
    return this.sendEnvelope(envelopeId, null);
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope sendEnvelope(@NonNull String envelopeId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.sendEnvelopeConfig, requestConfig);
    Request request = this.buildSendEnvelopeRequest(envelopeId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> sendEnvelopeAsync(@NonNull String envelopeId) throws ApiError {
    return this.sendEnvelopeAsync(envelopeId, null);
  }

  /**
   * Send envelope for signature
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> sendEnvelopeAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.sendEnvelopeConfig, requestConfig);
    Request request = this.buildSendEnvelopeRequest(envelopeId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildSendEnvelopeRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/send"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope duplicateEnvelope(@NonNull String envelopeId) throws ApiError {
    return this.duplicateEnvelope(envelopeId, null);
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope duplicateEnvelope(@NonNull String envelopeId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.duplicateEnvelopeConfig, requestConfig);
    Request request = this.buildDuplicateEnvelopeRequest(envelopeId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> duplicateEnvelopeAsync(@NonNull String envelopeId)
    throws ApiError {
    return this.duplicateEnvelopeAsync(envelopeId, null);
  }

  /**
   * Duplicate envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> duplicateEnvelopeAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.duplicateEnvelopeConfig, requestConfig);
    Request request = this.buildDuplicateEnvelopeRequest(envelopeId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildDuplicateEnvelopeRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/duplicate"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .build();
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope voidEnvelope(@NonNull String envelopeId) throws ApiError {
    return this.voidEnvelope(envelopeId, null);
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @return response of {@code Envelope}
   */
  public Envelope voidEnvelope(@NonNull String envelopeId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.voidEnvelopeConfig, requestConfig);
    Request request = this.buildVoidEnvelopeRequest(envelopeId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> voidEnvelopeAsync(@NonNull String envelopeId) throws ApiError {
    return this.voidEnvelopeAsync(envelopeId, null);
  }

  /**
   * Void envelope
   *
   * @param envelopeId String
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> voidEnvelopeAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.voidEnvelopeConfig, requestConfig);
    Request request = this.buildVoidEnvelopeRequest(envelopeId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildVoidEnvelopeRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/void"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  public Envelope renameEnvelope(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeRequest renameEnvelopeRequest
  ) throws ApiError {
    return this.renameEnvelope(envelopeId, renameEnvelopeRequest, null);
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param renameEnvelopeRequest {@link RenameEnvelopeRequest} Request Body
   * @return response of {@code Envelope}
   */
  public Envelope renameEnvelope(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeRequest renameEnvelopeRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.renameEnvelopeConfig, requestConfig);
    Request request =
      this.buildRenameEnvelopeRequest(envelopeId, renameEnvelopeRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param renameEnvelopeRequest {@link RenameEnvelopeRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> renameEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeRequest renameEnvelopeRequest
  ) throws ApiError {
    return this.renameEnvelopeAsync(envelopeId, renameEnvelopeRequest, null);
  }

  /**
   * Rename envelope
   *
   * @param envelopeId String
   * @param renameEnvelopeRequest {@link RenameEnvelopeRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> renameEnvelopeAsync(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeRequest renameEnvelopeRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.renameEnvelopeConfig, requestConfig);
    Request request =
      this.buildRenameEnvelopeRequest(envelopeId, renameEnvelopeRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildRenameEnvelopeRequest(
    @NonNull String envelopeId,
    @NonNull RenameEnvelopeRequest renameEnvelopeRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/rename"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.setEnvelopeComment(envelopeId, setEnvelopeCommentRequest, null);
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
    @NonNull SetEnvelopeCommentRequest setEnvelopeCommentRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeCommentConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeCommentRequest(envelopeId, setEnvelopeCommentRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope comment
   *
   * @param envelopeId String
   * @param setEnvelopeCommentRequest {@link SetEnvelopeCommentRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeCommentAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentRequest setEnvelopeCommentRequest
  ) throws ApiError {
    return this.setEnvelopeCommentAsync(envelopeId, setEnvelopeCommentRequest, null);
  }

  /**
   * Set envelope comment
   *
   * @param envelopeId String
   * @param setEnvelopeCommentRequest {@link SetEnvelopeCommentRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeCommentAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentRequest setEnvelopeCommentRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeCommentConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeCommentRequest(envelopeId, setEnvelopeCommentRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildSetEnvelopeCommentRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeCommentRequest setEnvelopeCommentRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/set_comment"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.setEnvelopeNotification(envelopeId, envelopeNotification, null);
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
    @NonNull EnvelopeNotification envelopeNotification,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeNotificationConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeNotificationRequest(envelopeId, envelopeNotification, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope notification
   *
   * @param envelopeId String
   * @param envelopeNotification {@link EnvelopeNotification} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeNotificationAsync(
    @NonNull String envelopeId,
    @NonNull EnvelopeNotification envelopeNotification
  ) throws ApiError {
    return this.setEnvelopeNotificationAsync(envelopeId, envelopeNotification, null);
  }

  /**
   * Set envelope notification
   *
   * @param envelopeId String
   * @param envelopeNotification {@link EnvelopeNotification} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeNotificationAsync(
    @NonNull String envelopeId,
    @NonNull EnvelopeNotification envelopeNotification,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeNotificationConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeNotificationRequest(envelopeId, envelopeNotification, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildSetEnvelopeNotificationRequest(
    @NonNull String envelopeId,
    @NonNull EnvelopeNotification envelopeNotification,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/set_notification"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.setEnvelopeExpirationDate(envelopeId, setEnvelopeExpirationRequest, null);
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
    @NonNull SetEnvelopeExpirationRequest setEnvelopeExpirationRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeExpirationDateConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeExpirationDateRequest(
          envelopeId,
          setEnvelopeExpirationRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope expiration date
   *
   * @param envelopeId String
   * @param setEnvelopeExpirationRequest {@link SetEnvelopeExpirationRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeExpirationDateAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationRequest setEnvelopeExpirationRequest
  ) throws ApiError {
    return this.setEnvelopeExpirationDateAsync(envelopeId, setEnvelopeExpirationRequest, null);
  }

  /**
   * Set envelope expiration date
   *
   * @param envelopeId String
   * @param setEnvelopeExpirationRequest {@link SetEnvelopeExpirationRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeExpirationDateAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationRequest setEnvelopeExpirationRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeExpirationDateConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeExpirationDateRequest(
          envelopeId,
          setEnvelopeExpirationRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildSetEnvelopeExpirationDateRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeExpirationRequest setEnvelopeExpirationRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/set_expiration_date"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.setEnvelopeLegalityLevel(envelopeId, setEnvelopeLegalityLevelRequest, null);
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
    @NonNull SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeLegalityLevelConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeLegalityLevelRequest(
          envelopeId,
          setEnvelopeLegalityLevelRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
  }

  /**
   * Set envelope legality level
   *
   * @param envelopeId String
   * @param setEnvelopeLegalityLevelRequest {@link SetEnvelopeLegalityLevelRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeLegalityLevelAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest
  ) throws ApiError {
    return this.setEnvelopeLegalityLevelAsync(envelopeId, setEnvelopeLegalityLevelRequest, null);
  }

  /**
   * Set envelope legality level
   *
   * @param envelopeId String
   * @param setEnvelopeLegalityLevelRequest {@link SetEnvelopeLegalityLevelRequest} Request Body
   * @return response of {@code CompletableFuture<Envelope>}
   */
  public CompletableFuture<Envelope> setEnvelopeLegalityLevelAsync(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setEnvelopeLegalityLevelConfig, requestConfig);
    Request request =
      this.buildSetEnvelopeLegalityLevelRequest(
          envelopeId,
          setEnvelopeLegalityLevelRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Envelope>() {});
    });
  }

  private Request buildSetEnvelopeLegalityLevelRequest(
    @NonNull String envelopeId,
    @NonNull SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/set_legality_level"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  public List<Annotation> getEnvelopeAnnotations(@NonNull String envelopeId) throws ApiError {
    return this.getEnvelopeAnnotations(envelopeId, null);
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code List<Annotation>}
   */
  public List<Annotation> getEnvelopeAnnotations(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeAnnotationsConfig, requestConfig);
    Request request = this.buildGetEnvelopeAnnotationsRequest(envelopeId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<List<Annotation>>() {});
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code CompletableFuture<List<Annotation>>}
   */
  public CompletableFuture<List<Annotation>> getEnvelopeAnnotationsAsync(
    @NonNull String envelopeId
  ) throws ApiError {
    return this.getEnvelopeAnnotationsAsync(envelopeId, null);
  }

  /**
   * Get envelope annotations
   *
   * @param envelopeId String ID of the envelope
   * @return response of {@code CompletableFuture<List<Annotation>>}
   */
  public CompletableFuture<List<Annotation>> getEnvelopeAnnotationsAsync(
    @NonNull String envelopeId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeAnnotationsConfig, requestConfig);
    Request request = this.buildGetEnvelopeAnnotationsRequest(envelopeId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<List<Annotation>>() {});
    });
  }

  private Request buildGetEnvelopeAnnotationsRequest(
    @NonNull String envelopeId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/annotations"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.getEnvelopeDocumentAnnotations(envelopeId, documentId, null);
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
    @NonNull String documentId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeDocumentAnnotationsRequest(envelopeId, documentId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(
      bodyBytes,
      new TypeReference<ListEnvelopeDocumentAnnotationsResponse>() {}
    );
  }

  /**
   * Get envelope document annotations
   *
   * @param envelopeId String ID of the envelope
   * @param documentId String ID of document
   * @return response of {@code CompletableFuture<ListEnvelopeDocumentAnnotationsResponse>}
   */
  public CompletableFuture<
    ListEnvelopeDocumentAnnotationsResponse
  > getEnvelopeDocumentAnnotationsAsync(@NonNull String envelopeId, @NonNull String documentId)
    throws ApiError {
    return this.getEnvelopeDocumentAnnotationsAsync(envelopeId, documentId, null);
  }

  /**
   * Get envelope document annotations
   *
   * @param envelopeId String ID of the envelope
   * @param documentId String ID of document
   * @return response of {@code CompletableFuture<ListEnvelopeDocumentAnnotationsResponse>}
   */
  public CompletableFuture<
    ListEnvelopeDocumentAnnotationsResponse
  > getEnvelopeDocumentAnnotationsAsync(
    @NonNull String envelopeId,
    @NonNull String documentId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getEnvelopeDocumentAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetEnvelopeDocumentAnnotationsRequest(envelopeId, documentId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(
        bodyBytes,
        new TypeReference<ListEnvelopeDocumentAnnotationsResponse>() {}
      );
    });
  }

  private Request buildGetEnvelopeDocumentAnnotationsRequest(
    @NonNull String envelopeId,
    @NonNull String documentId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/annotations/{document_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.addEnvelopeAnnotation(envelopeId, addAnnotationRequest, null);
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
    @NonNull AddAnnotationRequest addAnnotationRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeAnnotationConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeAnnotationRequest(envelopeId, addAnnotationRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Annotation>() {});
  }

  /**
   * Add envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param addAnnotationRequest {@link AddAnnotationRequest} Request Body
   * @return response of {@code CompletableFuture<Annotation>}
   */
  public CompletableFuture<Annotation> addEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull AddAnnotationRequest addAnnotationRequest
  ) throws ApiError {
    return this.addEnvelopeAnnotationAsync(envelopeId, addAnnotationRequest, null);
  }

  /**
   * Add envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param addAnnotationRequest {@link AddAnnotationRequest} Request Body
   * @return response of {@code CompletableFuture<Annotation>}
   */
  public CompletableFuture<Annotation> addEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull AddAnnotationRequest addAnnotationRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addEnvelopeAnnotationConfig, requestConfig);
    Request request =
      this.buildAddEnvelopeAnnotationRequest(envelopeId, addAnnotationRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Annotation>() {});
    });
  }

  private Request buildAddEnvelopeAnnotationRequest(
    @NonNull String envelopeId,
    @NonNull AddAnnotationRequest addAnnotationRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/annotation"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("envelope_id", envelopeId)
      .setJsonContent(addAnnotationRequest)
      .build();
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code void}
   */
  public void deleteEnvelopeAnnotation(@NonNull String envelopeId, @NonNull String annotationId)
    throws ApiError {
    this.deleteEnvelopeAnnotation(envelopeId, annotationId, null);
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code void}
   */
  public void deleteEnvelopeAnnotation(
    @NonNull String envelopeId,
    @NonNull String annotationId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.deleteEnvelopeAnnotationConfig, requestConfig);
    Request request =
      this.buildDeleteEnvelopeAnnotationRequest(envelopeId, annotationId, resolvedConfig);
    this.execute(request, resolvedConfig);
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull String annotationId
  ) throws ApiError {
    return this.deleteEnvelopeAnnotationAsync(envelopeId, annotationId, null);
  }

  /**
   * Delete envelope annotation
   *
   * @param envelopeId String ID of the envelope
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteEnvelopeAnnotationAsync(
    @NonNull String envelopeId,
    @NonNull String annotationId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.deleteEnvelopeAnnotationConfig, requestConfig);
    Request request =
      this.buildDeleteEnvelopeAnnotationRequest(envelopeId, annotationId, resolvedConfig);
    return this.executeAsync(request, resolvedConfig).thenApplyAsync(response -> null);
  }

  private Request buildDeleteEnvelopeAnnotationRequest(
    @NonNull String envelopeId,
    @NonNull String annotationId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "envelope/{envelope_id}/annotation/{annotation_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  public Template createTemplate(@NonNull CreateTemplateRequest createTemplateRequest)
    throws ApiError, ValidationException {
    return this.createTemplate(createTemplateRequest, null);
  }

  /**
   * Create new template
   *
   * @param createTemplateRequest {@link CreateTemplateRequest} Request Body
   * @return response of {@code Template}
   */
  public Template createTemplate(
    @NonNull CreateTemplateRequest createTemplateRequest,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createTemplateConfig, requestConfig);
    Request request = this.buildCreateTemplateRequest(createTemplateRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
  }

  /**
   * Create new template
   *
   * @param createTemplateRequest {@link CreateTemplateRequest} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> createTemplateAsync(
    @NonNull CreateTemplateRequest createTemplateRequest
  ) throws ApiError, ValidationException {
    return this.createTemplateAsync(createTemplateRequest, null);
  }

  /**
   * Create new template
   *
   * @param createTemplateRequest {@link CreateTemplateRequest} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> createTemplateAsync(
    @NonNull CreateTemplateRequest createTemplateRequest,
    RequestConfig requestConfig
  ) throws ApiError, ValidationException {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createTemplateConfig, requestConfig);
    Request request = this.buildCreateTemplateRequest(createTemplateRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
    });
  }

  private Request buildCreateTemplateRequest(
    @NonNull CreateTemplateRequest createTemplateRequest,
    RequestConfig resolvedConfig
  ) throws ValidationException {
    new ViolationAggregator()
      .add(
        new CreateTemplateRequestValidator("createTemplateRequest")
          .required()
          .validate(createTemplateRequest)
      )
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(createTemplateRequest)
      .build();
  }

  /**
   * List templates
   *
   * @return response of {@code ListTemplatesResponse}
   */
  public ListTemplatesResponse listTemplates() throws ApiError {
    return this.listTemplates(ListTemplatesRequest.builder().build());
  }

  /**
   * List templates
   *
   * @param listTemplatesRequest {@link ListTemplatesRequest} Request Body
   * @return response of {@code ListTemplatesResponse}
   */
  public ListTemplatesResponse listTemplates(@NonNull ListTemplatesRequest listTemplatesRequest)
    throws ApiError {
    return this.listTemplates(listTemplatesRequest, null);
  }

  /**
   * List templates
   *
   * @param listTemplatesRequest {@link ListTemplatesRequest} Request Body
   * @return response of {@code ListTemplatesResponse}
   */
  public ListTemplatesResponse listTemplates(
    @NonNull ListTemplatesRequest listTemplatesRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listTemplatesConfig, requestConfig);
    Request request = this.buildListTemplatesRequest(listTemplatesRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ListTemplatesResponse>() {});
  }

  /**
   * List templates
   *
   * @return response of {@code CompletableFuture<ListTemplatesResponse>}
   */
  public CompletableFuture<ListTemplatesResponse> listTemplatesAsync() throws ApiError {
    return this.listTemplatesAsync(ListTemplatesRequest.builder().build());
  }

  /**
   * List templates
   *
   * @param listTemplatesRequest {@link ListTemplatesRequest} Request Body
   * @return response of {@code CompletableFuture<ListTemplatesResponse>}
   */
  public CompletableFuture<ListTemplatesResponse> listTemplatesAsync(
    @NonNull ListTemplatesRequest listTemplatesRequest
  ) throws ApiError {
    return this.listTemplatesAsync(listTemplatesRequest, null);
  }

  /**
   * List templates
   *
   * @param listTemplatesRequest {@link ListTemplatesRequest} Request Body
   * @return response of {@code CompletableFuture<ListTemplatesResponse>}
   */
  public CompletableFuture<ListTemplatesResponse> listTemplatesAsync(
    @NonNull ListTemplatesRequest listTemplatesRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listTemplatesConfig, requestConfig);
    Request request = this.buildListTemplatesRequest(listTemplatesRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ListTemplatesResponse>() {});
    });
  }

  private Request buildListTemplatesRequest(
    @NonNull ListTemplatesRequest listTemplatesRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "templates"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(listTemplatesRequest)
      .build();
  }

  /**
   * Get template
   *
   * @param templateId String
   * @return response of {@code Template}
   */
  public Template getTemplate(@NonNull String templateId) throws ApiError {
    return this.getTemplate(templateId, null);
  }

  /**
   * Get template
   *
   * @param templateId String
   * @return response of {@code Template}
   */
  public Template getTemplate(@NonNull String templateId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getTemplateConfig, requestConfig);
    Request request = this.buildGetTemplateRequest(templateId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
  }

  /**
   * Get template
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> getTemplateAsync(@NonNull String templateId) throws ApiError {
    return this.getTemplateAsync(templateId, null);
  }

  /**
   * Get template
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> getTemplateAsync(
    @NonNull String templateId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getTemplateConfig, requestConfig);
    Request request = this.buildGetTemplateRequest(templateId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
    });
  }

  private Request buildGetTemplateRequest(
    @NonNull String templateId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .build();
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code void}
   */
  public void deleteTemplate(@NonNull String templateId) throws ApiError {
    this.deleteTemplate(templateId, null);
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code void}
   */
  public void deleteTemplate(@NonNull String templateId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteTemplateConfig, requestConfig);
    Request request = this.buildDeleteTemplateRequest(templateId, resolvedConfig);
    this.execute(request, resolvedConfig);
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteTemplateAsync(@NonNull String templateId) throws ApiError {
    return this.deleteTemplateAsync(templateId, null);
  }

  /**
   * Delete template
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteTemplateAsync(
    @NonNull String templateId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteTemplateConfig, requestConfig);
    Request request = this.buildDeleteTemplateRequest(templateId, resolvedConfig);
    return this.executeAsync(request, resolvedConfig).thenApplyAsync(response -> null);
  }

  private Request buildDeleteTemplateRequest(
    @NonNull String templateId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .build();
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @return response of {@code Template}
   */
  public Template duplicateTemplate(@NonNull String templateId) throws ApiError {
    return this.duplicateTemplate(templateId, null);
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @return response of {@code Template}
   */
  public Template duplicateTemplate(@NonNull String templateId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.duplicateTemplateConfig, requestConfig);
    Request request = this.buildDuplicateTemplateRequest(templateId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> duplicateTemplateAsync(@NonNull String templateId)
    throws ApiError {
    return this.duplicateTemplateAsync(templateId, null);
  }

  /**
   * Duplicate template
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> duplicateTemplateAsync(
    @NonNull String templateId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.duplicateTemplateConfig, requestConfig);
    Request request = this.buildDuplicateTemplateRequest(templateId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
    });
  }

  private Request buildDuplicateTemplateRequest(
    @NonNull String templateId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/duplicate"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .build();
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param addTemplateDocumentRequest {@link AddTemplateDocumentRequest} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code Document}
   */
  public Document addTemplateDocument(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentRequest addTemplateDocumentRequest,
    @NonNull String _filename
  ) throws ApiError {
    return this.addTemplateDocument(templateId, addTemplateDocumentRequest, _filename, null);
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param addTemplateDocumentRequest {@link AddTemplateDocumentRequest} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code Document}
   */
  public Document addTemplateDocument(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentRequest addTemplateDocumentRequest,
    @NonNull String _filename,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateDocumentConfig, requestConfig);
    Request request =
      this.buildAddTemplateDocumentRequest(
          templateId,
          addTemplateDocumentRequest,
          _filename,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Document>() {});
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param addTemplateDocumentRequest {@link AddTemplateDocumentRequest} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<Document>}
   */
  public CompletableFuture<Document> addTemplateDocumentAsync(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentRequest addTemplateDocumentRequest,
    @NonNull String _filename
  ) throws ApiError {
    return this.addTemplateDocumentAsync(templateId, addTemplateDocumentRequest, _filename, null);
  }

  /**
   * Add template document
   *
   * @param templateId String
   * @param addTemplateDocumentRequest {@link AddTemplateDocumentRequest} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<Document>}
   */
  public CompletableFuture<Document> addTemplateDocumentAsync(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentRequest addTemplateDocumentRequest,
    @NonNull String _filename,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateDocumentConfig, requestConfig);
    Request request =
      this.buildAddTemplateDocumentRequest(
          templateId,
          addTemplateDocumentRequest,
          _filename,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Document>() {});
    });
  }

  private Request buildAddTemplateDocumentRequest(
    @NonNull String templateId,
    @NonNull AddTemplateDocumentRequest addTemplateDocumentRequest,
    @NonNull String _filename,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/document"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setBody(
        new MultipartBody.Builder()
          .setType(MultipartBody.FORM)
          .addFormDataPart(
            "file",
            _filename,
            RequestBody.create(
              addTemplateDocumentRequest.getFile(),
              MediaType.parse("application/octet-stream")
            )
          )
          .build()
      )
      .build();
  }

  /**
   * Get template document
   *
   * @param templateId String
   * @param documentId String
   * @return response of {@code Document}
   */
  public Document getTemplateDocument(@NonNull String templateId, @NonNull String documentId)
    throws ApiError {
    return this.getTemplateDocument(templateId, documentId, null);
  }

  /**
   * Get template document
   *
   * @param templateId String
   * @param documentId String
   * @return response of {@code Document}
   */
  public Document getTemplateDocument(
    @NonNull String templateId,
    @NonNull String documentId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateDocumentConfig, requestConfig);
    Request request = this.buildGetTemplateDocumentRequest(templateId, documentId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Document>() {});
  }

  /**
   * Get template document
   *
   * @param templateId String
   * @param documentId String
   * @return response of {@code CompletableFuture<Document>}
   */
  public CompletableFuture<Document> getTemplateDocumentAsync(
    @NonNull String templateId,
    @NonNull String documentId
  ) throws ApiError {
    return this.getTemplateDocumentAsync(templateId, documentId, null);
  }

  /**
   * Get template document
   *
   * @param templateId String
   * @param documentId String
   * @return response of {@code CompletableFuture<Document>}
   */
  public CompletableFuture<Document> getTemplateDocumentAsync(
    @NonNull String templateId,
    @NonNull String documentId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateDocumentConfig, requestConfig);
    Request request = this.buildGetTemplateDocumentRequest(templateId, documentId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Document>() {});
    });
  }

  private Request buildGetTemplateDocumentRequest(
    @NonNull String templateId,
    @NonNull String documentId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/document/{document_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  public ListTemplateDocumentsResponse getTemplateDocuments(@NonNull String templateId)
    throws ApiError {
    return this.getTemplateDocuments(templateId, null);
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @return response of {@code ListTemplateDocumentsResponse}
   */
  public ListTemplateDocumentsResponse getTemplateDocuments(
    @NonNull String templateId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateDocumentsConfig, requestConfig);
    Request request = this.buildGetTemplateDocumentsRequest(templateId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ListTemplateDocumentsResponse>() {});
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<ListTemplateDocumentsResponse>}
   */
  public CompletableFuture<ListTemplateDocumentsResponse> getTemplateDocumentsAsync(
    @NonNull String templateId
  ) throws ApiError {
    return this.getTemplateDocumentsAsync(templateId, null);
  }

  /**
   * Get template documents
   *
   * @param templateId String
   * @return response of {@code CompletableFuture<ListTemplateDocumentsResponse>}
   */
  public CompletableFuture<ListTemplateDocumentsResponse> getTemplateDocumentsAsync(
    @NonNull String templateId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateDocumentsConfig, requestConfig);
    Request request = this.buildGetTemplateDocumentsRequest(templateId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(
        bodyBytes,
        new TypeReference<ListTemplateDocumentsResponse>() {}
      );
    });
  }

  private Request buildGetTemplateDocumentsRequest(
    @NonNull String templateId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/documents"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.addTemplateSigningSteps(templateId, addTemplateSigningStepsRequest, null);
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
    @NonNull AddTemplateSigningStepsRequest addTemplateSigningStepsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateSigningStepsConfig, requestConfig);
    Request request =
      this.buildAddTemplateSigningStepsRequest(
          templateId,
          addTemplateSigningStepsRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
  }

  /**
   * Add template signing steps
   *
   * @param templateId String
   * @param addTemplateSigningStepsRequest {@link AddTemplateSigningStepsRequest} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> addTemplateSigningStepsAsync(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsRequest addTemplateSigningStepsRequest
  ) throws ApiError {
    return this.addTemplateSigningStepsAsync(templateId, addTemplateSigningStepsRequest, null);
  }

  /**
   * Add template signing steps
   *
   * @param templateId String
   * @param addTemplateSigningStepsRequest {@link AddTemplateSigningStepsRequest} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> addTemplateSigningStepsAsync(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsRequest addTemplateSigningStepsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateSigningStepsConfig, requestConfig);
    Request request =
      this.buildAddTemplateSigningStepsRequest(
          templateId,
          addTemplateSigningStepsRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
    });
  }

  private Request buildAddTemplateSigningStepsRequest(
    @NonNull String templateId,
    @NonNull AddTemplateSigningStepsRequest addTemplateSigningStepsRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/signing_steps"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  public Template renameTemplate(
    @NonNull String templateId,
    @NonNull RenameTemplateRequest renameTemplateRequest
  ) throws ApiError {
    return this.renameTemplate(templateId, renameTemplateRequest, null);
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param renameTemplateRequest {@link RenameTemplateRequest} Request Body
   * @return response of {@code Template}
   */
  public Template renameTemplate(
    @NonNull String templateId,
    @NonNull RenameTemplateRequest renameTemplateRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.renameTemplateConfig, requestConfig);
    Request request =
      this.buildRenameTemplateRequest(templateId, renameTemplateRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param renameTemplateRequest {@link RenameTemplateRequest} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> renameTemplateAsync(
    @NonNull String templateId,
    @NonNull RenameTemplateRequest renameTemplateRequest
  ) throws ApiError {
    return this.renameTemplateAsync(templateId, renameTemplateRequest, null);
  }

  /**
   * Rename template
   *
   * @param templateId String
   * @param renameTemplateRequest {@link RenameTemplateRequest} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> renameTemplateAsync(
    @NonNull String templateId,
    @NonNull RenameTemplateRequest renameTemplateRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.renameTemplateConfig, requestConfig);
    Request request =
      this.buildRenameTemplateRequest(templateId, renameTemplateRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
    });
  }

  private Request buildRenameTemplateRequest(
    @NonNull String templateId,
    @NonNull RenameTemplateRequest renameTemplateRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/rename"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.setTemplateComment(templateId, setTemplateCommentRequest, null);
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
    @NonNull SetTemplateCommentRequest setTemplateCommentRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateCommentConfig, requestConfig);
    Request request =
      this.buildSetTemplateCommentRequest(templateId, setTemplateCommentRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
  }

  /**
   * Set template comment
   *
   * @param templateId String
   * @param setTemplateCommentRequest {@link SetTemplateCommentRequest} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> setTemplateCommentAsync(
    @NonNull String templateId,
    @NonNull SetTemplateCommentRequest setTemplateCommentRequest
  ) throws ApiError {
    return this.setTemplateCommentAsync(templateId, setTemplateCommentRequest, null);
  }

  /**
   * Set template comment
   *
   * @param templateId String
   * @param setTemplateCommentRequest {@link SetTemplateCommentRequest} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> setTemplateCommentAsync(
    @NonNull String templateId,
    @NonNull SetTemplateCommentRequest setTemplateCommentRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateCommentConfig, requestConfig);
    Request request =
      this.buildSetTemplateCommentRequest(templateId, setTemplateCommentRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
    });
  }

  private Request buildSetTemplateCommentRequest(
    @NonNull String templateId,
    @NonNull SetTemplateCommentRequest setTemplateCommentRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/set_comment"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.setTemplateNotification(templateId, envelopeNotification, null);
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
    @NonNull EnvelopeNotification envelopeNotification,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateNotificationConfig, requestConfig);
    Request request =
      this.buildSetTemplateNotificationRequest(templateId, envelopeNotification, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
  }

  /**
   * Set template notification
   *
   * @param templateId String
   * @param envelopeNotification {@link EnvelopeNotification} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> setTemplateNotificationAsync(
    @NonNull String templateId,
    @NonNull EnvelopeNotification envelopeNotification
  ) throws ApiError {
    return this.setTemplateNotificationAsync(templateId, envelopeNotification, null);
  }

  /**
   * Set template notification
   *
   * @param templateId String
   * @param envelopeNotification {@link EnvelopeNotification} Request Body
   * @return response of {@code CompletableFuture<Template>}
   */
  public CompletableFuture<Template> setTemplateNotificationAsync(
    @NonNull String templateId,
    @NonNull EnvelopeNotification envelopeNotification,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateNotificationConfig, requestConfig);
    Request request =
      this.buildSetTemplateNotificationRequest(templateId, envelopeNotification, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Template>() {});
    });
  }

  private Request buildSetTemplateNotificationRequest(
    @NonNull String templateId,
    @NonNull EnvelopeNotification envelopeNotification,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/set_notification"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  public ListTemplateAnnotationsResponse getTemplateAnnotations(@NonNull String templateId)
    throws ApiError {
    return this.getTemplateAnnotations(templateId, null);
  }

  /**
   * Get template annotations
   *
   * @param templateId String ID of the template
   * @return response of {@code ListTemplateAnnotationsResponse}
   */
  public ListTemplateAnnotationsResponse getTemplateAnnotations(
    @NonNull String templateId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateAnnotationsConfig, requestConfig);
    Request request = this.buildGetTemplateAnnotationsRequest(templateId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(
      bodyBytes,
      new TypeReference<ListTemplateAnnotationsResponse>() {}
    );
  }

  /**
   * Get template annotations
   *
   * @param templateId String ID of the template
   * @return response of {@code CompletableFuture<ListTemplateAnnotationsResponse>}
   */
  public CompletableFuture<ListTemplateAnnotationsResponse> getTemplateAnnotationsAsync(
    @NonNull String templateId
  ) throws ApiError {
    return this.getTemplateAnnotationsAsync(templateId, null);
  }

  /**
   * Get template annotations
   *
   * @param templateId String ID of the template
   * @return response of {@code CompletableFuture<ListTemplateAnnotationsResponse>}
   */
  public CompletableFuture<ListTemplateAnnotationsResponse> getTemplateAnnotationsAsync(
    @NonNull String templateId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getTemplateAnnotationsConfig, requestConfig);
    Request request = this.buildGetTemplateAnnotationsRequest(templateId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(
        bodyBytes,
        new TypeReference<ListTemplateAnnotationsResponse>() {}
      );
    });
  }

  private Request buildGetTemplateAnnotationsRequest(
    @NonNull String templateId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/annotations"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.getDocumentTemplateAnnotations(templateId, documentId, null);
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
    @NonNull String documentId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getDocumentTemplateAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetDocumentTemplateAnnotationsRequest(templateId, documentId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(
      bodyBytes,
      new TypeReference<ListTemplateDocumentAnnotationsResponse>() {}
    );
  }

  /**
   * Get document template annotations
   *
   * @param templateId String ID of the template
   * @param documentId String ID of document
   * @return response of {@code CompletableFuture<ListTemplateDocumentAnnotationsResponse>}
   */
  public CompletableFuture<
    ListTemplateDocumentAnnotationsResponse
  > getDocumentTemplateAnnotationsAsync(@NonNull String templateId, @NonNull String documentId)
    throws ApiError {
    return this.getDocumentTemplateAnnotationsAsync(templateId, documentId, null);
  }

  /**
   * Get document template annotations
   *
   * @param templateId String ID of the template
   * @param documentId String ID of document
   * @return response of {@code CompletableFuture<ListTemplateDocumentAnnotationsResponse>}
   */
  public CompletableFuture<
    ListTemplateDocumentAnnotationsResponse
  > getDocumentTemplateAnnotationsAsync(
    @NonNull String templateId,
    @NonNull String documentId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.getDocumentTemplateAnnotationsConfig, requestConfig);
    Request request =
      this.buildGetDocumentTemplateAnnotationsRequest(templateId, documentId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(
        bodyBytes,
        new TypeReference<ListTemplateDocumentAnnotationsResponse>() {}
      );
    });
  }

  private Request buildGetDocumentTemplateAnnotationsRequest(
    @NonNull String templateId,
    @NonNull String documentId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/annotations/{document_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
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
  ) throws ApiError {
    return this.addTemplateAnnotation(templateId, addAnnotationRequest, null);
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
    @NonNull AddAnnotationRequest addAnnotationRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateAnnotationConfig, requestConfig);
    Request request =
      this.buildAddTemplateAnnotationRequest(templateId, addAnnotationRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Annotation>() {});
  }

  /**
   * Add template annotation
   *
   * @param templateId String ID of the template
   * @param addAnnotationRequest {@link AddAnnotationRequest} Request Body
   * @return response of {@code CompletableFuture<Annotation>}
   */
  public CompletableFuture<Annotation> addTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull AddAnnotationRequest addAnnotationRequest
  ) throws ApiError {
    return this.addTemplateAnnotationAsync(templateId, addAnnotationRequest, null);
  }

  /**
   * Add template annotation
   *
   * @param templateId String ID of the template
   * @param addAnnotationRequest {@link AddAnnotationRequest} Request Body
   * @return response of {@code CompletableFuture<Annotation>}
   */
  public CompletableFuture<Annotation> addTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull AddAnnotationRequest addAnnotationRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.addTemplateAnnotationConfig, requestConfig);
    Request request =
      this.buildAddTemplateAnnotationRequest(templateId, addAnnotationRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Annotation>() {});
    });
  }

  private Request buildAddTemplateAnnotationRequest(
    @NonNull String templateId,
    @NonNull AddAnnotationRequest addAnnotationRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/annotation"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setJsonContent(addAnnotationRequest)
      .build();
  }

  /**
   * Delete template annotation
   *
   * @param templateId String ID of the template
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code void}
   */
  public void deleteTemplateAnnotation(@NonNull String templateId, @NonNull String annotationId)
    throws ApiError {
    this.deleteTemplateAnnotation(templateId, annotationId, null);
  }

  /**
   * Delete template annotation
   *
   * @param templateId String ID of the template
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code void}
   */
  public void deleteTemplateAnnotation(
    @NonNull String templateId,
    @NonNull String annotationId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.deleteTemplateAnnotationConfig, requestConfig);
    Request request =
      this.buildDeleteTemplateAnnotationRequest(templateId, annotationId, resolvedConfig);
    this.execute(request, resolvedConfig);
  }

  /**
   * Delete template annotation
   *
   * @param templateId String ID of the template
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull String annotationId
  ) throws ApiError {
    return this.deleteTemplateAnnotationAsync(templateId, annotationId, null);
  }

  /**
   * Delete template annotation
   *
   * @param templateId String ID of the template
   * @param annotationId String ID of the annotation to delete
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteTemplateAnnotationAsync(
    @NonNull String templateId,
    @NonNull String annotationId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.deleteTemplateAnnotationConfig, requestConfig);
    Request request =
      this.buildDeleteTemplateAnnotationRequest(templateId, annotationId, resolvedConfig);
    return this.executeAsync(request, resolvedConfig).thenApplyAsync(response -> null);
  }

  private Request buildDeleteTemplateAnnotationRequest(
    @NonNull String templateId,
    @NonNull String annotationId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/annotation/{annotation_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setPathParameter("annotation_id", annotationId)
      .build();
  }

  /**
   * Set template attachment settings
   *
   * @param templateId String
   * @param setEnvelopeAttachmentsSettingsRequest {@link SetEnvelopeAttachmentsSettingsRequest} Request Body
   * @return response of {@code EnvelopeAttachments}
   */
  public EnvelopeAttachments setTemplateAttachmentsSettings(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest
  ) throws ApiError {
    return this.setTemplateAttachmentsSettings(
        templateId,
        setEnvelopeAttachmentsSettingsRequest,
        null
      );
  }

  /**
   * Set template attachment settings
   *
   * @param templateId String
   * @param setEnvelopeAttachmentsSettingsRequest {@link SetEnvelopeAttachmentsSettingsRequest} Request Body
   * @return response of {@code EnvelopeAttachments}
   */
  public EnvelopeAttachments setTemplateAttachmentsSettings(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateAttachmentsSettingsConfig, requestConfig);
    Request request =
      this.buildSetTemplateAttachmentsSettingsRequest(
          templateId,
          setEnvelopeAttachmentsSettingsRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<EnvelopeAttachments>() {});
  }

  /**
   * Set template attachment settings
   *
   * @param templateId String
   * @param setEnvelopeAttachmentsSettingsRequest {@link SetEnvelopeAttachmentsSettingsRequest} Request Body
   * @return response of {@code CompletableFuture<EnvelopeAttachments>}
   */
  public CompletableFuture<EnvelopeAttachments> setTemplateAttachmentsSettingsAsync(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest
  ) throws ApiError {
    return this.setTemplateAttachmentsSettingsAsync(
        templateId,
        setEnvelopeAttachmentsSettingsRequest,
        null
      );
  }

  /**
   * Set template attachment settings
   *
   * @param templateId String
   * @param setEnvelopeAttachmentsSettingsRequest {@link SetEnvelopeAttachmentsSettingsRequest} Request Body
   * @return response of {@code CompletableFuture<EnvelopeAttachments>}
   */
  public CompletableFuture<EnvelopeAttachments> setTemplateAttachmentsSettingsAsync(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateAttachmentsSettingsConfig, requestConfig);
    Request request =
      this.buildSetTemplateAttachmentsSettingsRequest(
          templateId,
          setEnvelopeAttachmentsSettingsRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<EnvelopeAttachments>() {});
    });
  }

  private Request buildSetTemplateAttachmentsSettingsRequest(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/attachments/settings"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setJsonContent(setEnvelopeAttachmentsSettingsRequest)
      .build();
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param templateId String
   * @param setEnvelopeAttachmentsPlaceholdersRequest {@link SetEnvelopeAttachmentsPlaceholdersRequest} Request Body
   * @return response of {@code EnvelopeAttachments}
   */
  public EnvelopeAttachments setTemplateAttachmentsPlaceholders(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest
  ) throws ApiError {
    return this.setTemplateAttachmentsPlaceholders(
        templateId,
        setEnvelopeAttachmentsPlaceholdersRequest,
        null
      );
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param templateId String
   * @param setEnvelopeAttachmentsPlaceholdersRequest {@link SetEnvelopeAttachmentsPlaceholdersRequest} Request Body
   * @return response of {@code EnvelopeAttachments}
   */
  public EnvelopeAttachments setTemplateAttachmentsPlaceholders(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateAttachmentsPlaceholdersConfig, requestConfig);
    Request request =
      this.buildSetTemplateAttachmentsPlaceholdersRequest(
          templateId,
          setEnvelopeAttachmentsPlaceholdersRequest,
          resolvedConfig
        );
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<EnvelopeAttachments>() {});
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param templateId String
   * @param setEnvelopeAttachmentsPlaceholdersRequest {@link SetEnvelopeAttachmentsPlaceholdersRequest} Request Body
   * @return response of {@code CompletableFuture<EnvelopeAttachments>}
   */
  public CompletableFuture<EnvelopeAttachments> setTemplateAttachmentsPlaceholdersAsync(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest
  ) throws ApiError {
    return this.setTemplateAttachmentsPlaceholdersAsync(
        templateId,
        setEnvelopeAttachmentsPlaceholdersRequest,
        null
      );
  }

  /**
   * Placeholders to be set, completely replacing the existing ones.
   *
   * @param templateId String
   * @param setEnvelopeAttachmentsPlaceholdersRequest {@link SetEnvelopeAttachmentsPlaceholdersRequest} Request Body
   * @return response of {@code CompletableFuture<EnvelopeAttachments>}
   */
  public CompletableFuture<EnvelopeAttachments> setTemplateAttachmentsPlaceholdersAsync(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig =
      this.getResolvedConfig(this.setTemplateAttachmentsPlaceholdersConfig, requestConfig);
    Request request =
      this.buildSetTemplateAttachmentsPlaceholdersRequest(
          templateId,
          setEnvelopeAttachmentsPlaceholdersRequest,
          resolvedConfig
        );
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<EnvelopeAttachments>() {});
    });
  }

  private Request buildSetTemplateAttachmentsPlaceholdersRequest(
    @NonNull String templateId,
    @NonNull SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "template/{template_id}/attachments/placeholders"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("template_id", templateId)
      .setJsonContent(setEnvelopeAttachmentsPlaceholdersRequest)
      .build();
  }

  /**
   * Create webhook
   *
   * @param createWebhookRequest {@link CreateWebhookRequest} Request Body
   * @return response of {@code Webhook}
   */
  public Webhook createWebhook(@NonNull CreateWebhookRequest createWebhookRequest) throws ApiError {
    return this.createWebhook(createWebhookRequest, null);
  }

  /**
   * Create webhook
   *
   * @param createWebhookRequest {@link CreateWebhookRequest} Request Body
   * @return response of {@code Webhook}
   */
  public Webhook createWebhook(
    @NonNull CreateWebhookRequest createWebhookRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createWebhookConfig, requestConfig);
    Request request = this.buildCreateWebhookRequest(createWebhookRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Webhook>() {});
  }

  /**
   * Create webhook
   *
   * @param createWebhookRequest {@link CreateWebhookRequest} Request Body
   * @return response of {@code CompletableFuture<Webhook>}
   */
  public CompletableFuture<Webhook> createWebhookAsync(
    @NonNull CreateWebhookRequest createWebhookRequest
  ) throws ApiError {
    return this.createWebhookAsync(createWebhookRequest, null);
  }

  /**
   * Create webhook
   *
   * @param createWebhookRequest {@link CreateWebhookRequest} Request Body
   * @return response of {@code CompletableFuture<Webhook>}
   */
  public CompletableFuture<Webhook> createWebhookAsync(
    @NonNull CreateWebhookRequest createWebhookRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createWebhookConfig, requestConfig);
    Request request = this.buildCreateWebhookRequest(createWebhookRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Webhook>() {});
    });
  }

  private Request buildCreateWebhookRequest(
    @NonNull CreateWebhookRequest createWebhookRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "webhook"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(createWebhookRequest)
      .build();
  }

  /**
   * List webhooks
   *
   * @return response of {@code ListWebhooksResponse}
   */
  public ListWebhooksResponse listWebhooks() throws ApiError {
    return this.listWebhooks(ListWebhooksRequest.builder().build());
  }

  /**
   * List webhooks
   *
   * @param listWebhooksRequest {@link ListWebhooksRequest} Request Body
   * @return response of {@code ListWebhooksResponse}
   */
  public ListWebhooksResponse listWebhooks(@NonNull ListWebhooksRequest listWebhooksRequest)
    throws ApiError {
    return this.listWebhooks(listWebhooksRequest, null);
  }

  /**
   * List webhooks
   *
   * @param listWebhooksRequest {@link ListWebhooksRequest} Request Body
   * @return response of {@code ListWebhooksResponse}
   */
  public ListWebhooksResponse listWebhooks(
    @NonNull ListWebhooksRequest listWebhooksRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listWebhooksConfig, requestConfig);
    Request request = this.buildListWebhooksRequest(listWebhooksRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<ListWebhooksResponse>() {});
  }

  /**
   * List webhooks
   *
   * @return response of {@code CompletableFuture<ListWebhooksResponse>}
   */
  public CompletableFuture<ListWebhooksResponse> listWebhooksAsync() throws ApiError {
    return this.listWebhooksAsync(ListWebhooksRequest.builder().build());
  }

  /**
   * List webhooks
   *
   * @param listWebhooksRequest {@link ListWebhooksRequest} Request Body
   * @return response of {@code CompletableFuture<ListWebhooksResponse>}
   */
  public CompletableFuture<ListWebhooksResponse> listWebhooksAsync(
    @NonNull ListWebhooksRequest listWebhooksRequest
  ) throws ApiError {
    return this.listWebhooksAsync(listWebhooksRequest, null);
  }

  /**
   * List webhooks
   *
   * @param listWebhooksRequest {@link ListWebhooksRequest} Request Body
   * @return response of {@code CompletableFuture<ListWebhooksResponse>}
   */
  public CompletableFuture<ListWebhooksResponse> listWebhooksAsync(
    @NonNull ListWebhooksRequest listWebhooksRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listWebhooksConfig, requestConfig);
    Request request = this.buildListWebhooksRequest(listWebhooksRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<ListWebhooksResponse>() {});
    });
  }

  private Request buildListWebhooksRequest(
    @NonNull ListWebhooksRequest listWebhooksRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "webhooks"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(listWebhooksRequest)
      .build();
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code void}
   */
  public void deleteWebhook(@NonNull String webhookId) throws ApiError {
    this.deleteWebhook(webhookId, null);
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code void}
   */
  public void deleteWebhook(@NonNull String webhookId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteWebhookConfig, requestConfig);
    Request request = this.buildDeleteWebhookRequest(webhookId, resolvedConfig);
    this.execute(request, resolvedConfig);
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteWebhookAsync(@NonNull String webhookId) throws ApiError {
    return this.deleteWebhookAsync(webhookId, null);
  }

  /**
   * Delete webhook
   *
   * @param webhookId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteWebhookAsync(
    @NonNull String webhookId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteWebhookConfig, requestConfig);
    Request request = this.buildDeleteWebhookRequest(webhookId, resolvedConfig);
    return this.executeAsync(request, resolvedConfig).thenApplyAsync(response -> null);
  }

  private Request buildDeleteWebhookRequest(
    @NonNull String webhookId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "webhook/{webhook_id}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("webhook_id", webhookId)
      .build();
  }
}
