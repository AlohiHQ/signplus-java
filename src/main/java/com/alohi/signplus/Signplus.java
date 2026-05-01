package com.alohi.signplus;

import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.http.Environment;
import com.alohi.signplus.http.interceptors.DefaultHeadersInterceptor;
import com.alohi.signplus.http.interceptors.RetryInterceptor;
import com.alohi.signplus.services.AnnotationIdService;
import com.alohi.signplus.services.AnnotationService;
import com.alohi.signplus.services.AnnotationsService;
import com.alohi.signplus.services.CertificateService;
import com.alohi.signplus.services.DocumentIdService;
import com.alohi.signplus.services.DocumentService;
import com.alohi.signplus.services.DocumentsService;
import com.alohi.signplus.services.DuplicateService;
import com.alohi.signplus.services.DynamicFieldsService;
import com.alohi.signplus.services.EnvelopeEnvelopeIdAnnotationsDocumentIdService;
import com.alohi.signplus.services.EnvelopeIdService;
import com.alohi.signplus.services.EnvelopeService;
import com.alohi.signplus.services.EnvelopesService;
import com.alohi.signplus.services.FileIdService;
import com.alohi.signplus.services.PlaceholdersService;
import com.alohi.signplus.services.RenameService;
import com.alohi.signplus.services.SendService;
import com.alohi.signplus.services.SetCommentService;
import com.alohi.signplus.services.SetExpirationDateService;
import com.alohi.signplus.services.SetLegalityLevelService;
import com.alohi.signplus.services.SetNotificationService;
import com.alohi.signplus.services.SettingsService;
import com.alohi.signplus.services.SignedDocumentsService;
import com.alohi.signplus.services.SigningStepsService;
import com.alohi.signplus.services.TemplateIdService;
import com.alohi.signplus.services.TemplateService;
import com.alohi.signplus.services.TemplateTemplateIdAnnotationAnnotationIdService;
import com.alohi.signplus.services.TemplateTemplateIdAnnotationService;
import com.alohi.signplus.services.TemplateTemplateIdAnnotationsDocumentIdService;
import com.alohi.signplus.services.TemplateTemplateIdAnnotationsService;
import com.alohi.signplus.services.TemplateTemplateIdAttachmentsPlaceholdersService;
import com.alohi.signplus.services.TemplateTemplateIdAttachmentsSettingsService;
import com.alohi.signplus.services.TemplateTemplateIdDocumentDocumentIdService;
import com.alohi.signplus.services.TemplateTemplateIdDocumentService;
import com.alohi.signplus.services.TemplateTemplateIdDocumentsService;
import com.alohi.signplus.services.TemplateTemplateIdDuplicateService;
import com.alohi.signplus.services.TemplateTemplateIdRenameService;
import com.alohi.signplus.services.TemplateTemplateIdService;
import com.alohi.signplus.services.TemplateTemplateIdSetCommentService;
import com.alohi.signplus.services.TemplateTemplateIdSetNotificationService;
import com.alohi.signplus.services.TemplateTemplateIdSigningStepsService;
import com.alohi.signplus.services.TemplatesService;
import com.alohi.signplus.services.Void_Service;
import com.alohi.signplus.services.WebhookIdService;
import com.alohi.signplus.services.WebhookService;
import com.alohi.signplus.services.WebhooksService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** Integrate legally-binding electronic signature to your workflow

Contact Support:
 Name: Sign.Plus
 Email: support@alohi.com */
public class Signplus {

  public final TemplateIdService templateId;
  public final SignedDocumentsService signedDocuments;
  public final CertificateService certificate;
  public final DocumentIdService documentId;
  public final DocumentService document;
  public final DocumentsService documents;
  public final DynamicFieldsService dynamicFields;
  public final SigningStepsService signingSteps;
  public final SettingsService settings;
  public final PlaceholdersService placeholders;
  public final FileIdService fileId;
  public final SendService send;
  public final DuplicateService duplicate;
  public final Void_Service void_;
  public final RenameService rename;
  public final SetCommentService setComment;
  public final SetNotificationService setNotification;
  public final SetExpirationDateService setExpirationDate;
  public final SetLegalityLevelService setLegalityLevel;
  public final EnvelopeEnvelopeIdAnnotationsDocumentIdService envelopeEnvelopeIdAnnotationsDocumentId;
  public final AnnotationsService annotations;
  public final AnnotationIdService annotationId;
  public final AnnotationService annotation;
  public final EnvelopeIdService envelopeId;
  public final EnvelopeService envelope;
  public final EnvelopesService envelopes;
  public final TemplateTemplateIdDuplicateService templateTemplateIdDuplicate;
  public final TemplateTemplateIdDocumentDocumentIdService templateTemplateIdDocumentDocumentId;
  public final TemplateTemplateIdDocumentService templateTemplateIdDocument;
  public final TemplateTemplateIdDocumentsService templateTemplateIdDocuments;
  public final TemplateTemplateIdSigningStepsService templateTemplateIdSigningSteps;
  public final TemplateTemplateIdRenameService templateTemplateIdRename;
  public final TemplateTemplateIdSetCommentService templateTemplateIdSetComment;
  public final TemplateTemplateIdSetNotificationService templateTemplateIdSetNotification;
  public final TemplateTemplateIdAnnotationsDocumentIdService templateTemplateIdAnnotationsDocumentId;
  public final TemplateTemplateIdAnnotationsService templateTemplateIdAnnotations;
  public final TemplateTemplateIdAnnotationAnnotationIdService templateTemplateIdAnnotationAnnotationId;
  public final TemplateTemplateIdAnnotationService templateTemplateIdAnnotation;
  public final TemplateTemplateIdAttachmentsSettingsService templateTemplateIdAttachmentsSettings;
  public final TemplateTemplateIdAttachmentsPlaceholdersService templateTemplateIdAttachmentsPlaceholders;
  public final TemplateTemplateIdService templateTemplateId;
  public final TemplateService template;
  public final TemplatesService templates;
  public final WebhookIdService webhookId;
  public final WebhookService webhook;
  public final WebhooksService webhooks;

  private final SignplusConfig config;

  /**
   * Constructs a new instance of Signplus with default configuration.
   */
  public Signplus() {
    // Default configs
    this(SignplusConfig.builder().build());
  }

  /**
   * Constructs a new instance of Signplus with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public Signplus(SignplusConfig config) {
    this.config = config;

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.templateId = new TemplateIdService(httpClient, config);
    this.signedDocuments = new SignedDocumentsService(httpClient, config);
    this.certificate = new CertificateService(httpClient, config);
    this.documentId = new DocumentIdService(httpClient, config);
    this.document = new DocumentService(httpClient, config);
    this.documents = new DocumentsService(httpClient, config);
    this.dynamicFields = new DynamicFieldsService(httpClient, config);
    this.signingSteps = new SigningStepsService(httpClient, config);
    this.settings = new SettingsService(httpClient, config);
    this.placeholders = new PlaceholdersService(httpClient, config);
    this.fileId = new FileIdService(httpClient, config);
    this.send = new SendService(httpClient, config);
    this.duplicate = new DuplicateService(httpClient, config);
    this.void_ = new Void_Service(httpClient, config);
    this.rename = new RenameService(httpClient, config);
    this.setComment = new SetCommentService(httpClient, config);
    this.setNotification = new SetNotificationService(httpClient, config);
    this.setExpirationDate = new SetExpirationDateService(httpClient, config);
    this.setLegalityLevel = new SetLegalityLevelService(httpClient, config);
    this.envelopeEnvelopeIdAnnotationsDocumentId =
      new EnvelopeEnvelopeIdAnnotationsDocumentIdService(httpClient, config);
    this.annotations = new AnnotationsService(httpClient, config);
    this.annotationId = new AnnotationIdService(httpClient, config);
    this.annotation = new AnnotationService(httpClient, config);
    this.envelopeId = new EnvelopeIdService(httpClient, config);
    this.envelope = new EnvelopeService(httpClient, config);
    this.envelopes = new EnvelopesService(httpClient, config);
    this.templateTemplateIdDuplicate = new TemplateTemplateIdDuplicateService(httpClient, config);
    this.templateTemplateIdDocumentDocumentId = new TemplateTemplateIdDocumentDocumentIdService(
      httpClient,
      config
    );
    this.templateTemplateIdDocument = new TemplateTemplateIdDocumentService(httpClient, config);
    this.templateTemplateIdDocuments = new TemplateTemplateIdDocumentsService(httpClient, config);
    this.templateTemplateIdSigningSteps = new TemplateTemplateIdSigningStepsService(
      httpClient,
      config
    );
    this.templateTemplateIdRename = new TemplateTemplateIdRenameService(httpClient, config);
    this.templateTemplateIdSetComment = new TemplateTemplateIdSetCommentService(httpClient, config);
    this.templateTemplateIdSetNotification = new TemplateTemplateIdSetNotificationService(
      httpClient,
      config
    );
    this.templateTemplateIdAnnotationsDocumentId =
      new TemplateTemplateIdAnnotationsDocumentIdService(httpClient, config);
    this.templateTemplateIdAnnotations = new TemplateTemplateIdAnnotationsService(
      httpClient,
      config
    );
    this.templateTemplateIdAnnotationAnnotationId =
      new TemplateTemplateIdAnnotationAnnotationIdService(httpClient, config);
    this.templateTemplateIdAnnotation = new TemplateTemplateIdAnnotationService(httpClient, config);
    this.templateTemplateIdAttachmentsSettings = new TemplateTemplateIdAttachmentsSettingsService(
      httpClient,
      config
    );
    this.templateTemplateIdAttachmentsPlaceholders =
      new TemplateTemplateIdAttachmentsPlaceholdersService(httpClient, config);
    this.templateTemplateId = new TemplateTemplateIdService(httpClient, config);
    this.template = new TemplateService(httpClient, config);
    this.templates = new TemplatesService(httpClient, config);
    this.webhookId = new WebhookIdService(httpClient, config);
    this.webhook = new WebhookService(httpClient, config);
    this.webhooks = new WebhooksService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  /**
   * Sets the access token (Bearer token) for all API requests.
   *
   * @param token The access token to use for authentication
   */
  public void setAccessToken(String token) {
    this.config.setAccessToken(token);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
