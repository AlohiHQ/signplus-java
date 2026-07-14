package com.alohi.signplus.validation.validators.modelValidators;

import com.alohi.signplus.models.CreateEnvelopeFromTemplateRequest;
import com.alohi.signplus.validation.Violation;
import com.alohi.signplus.validation.ViolationAggregator;
import com.alohi.signplus.validation.validators.StringValidator;

/**
 * Validator implementation for CreateEnvelopeFromTemplateRequest model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreateEnvelopeFromTemplateRequestValidator
  extends AbstractModelValidator<CreateEnvelopeFromTemplateRequest> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreateEnvelopeFromTemplateRequestValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreateEnvelopeFromTemplateRequestValidator() {}

  /**
   * Validates the CreateEnvelopeFromTemplateRequest model's fields and constraints.
   *
   * @param createEnvelopeFromTemplateRequest The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(
    CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest
  ) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(256)
          .pattern("^[a-zA-Z0-9][a-zA-Z0-9 ]*[a-zA-Z0-9]$")
          .required()
          .validate(createEnvelopeFromTemplateRequest.getName())
      )
      .aggregate();
  }
}
