package com.alohi.signplus.validation.validators.modelValidators;

import com.alohi.signplus.models.CreateTemplateRequest;
import com.alohi.signplus.validation.Violation;
import com.alohi.signplus.validation.ViolationAggregator;
import com.alohi.signplus.validation.validators.StringValidator;

/**
 * Validator implementation for CreateTemplateRequest model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class CreateTemplateRequestValidator extends AbstractModelValidator<CreateTemplateRequest> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public CreateTemplateRequestValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public CreateTemplateRequestValidator() {}

  /**
   * Validates the CreateTemplateRequest model's fields and constraints.
   *
   * @param createTemplateRequest The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(CreateTemplateRequest createTemplateRequest) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(256)
          .pattern("^[a-zA-Z0-9][a-zA-Z0-9 ]*[a-zA-Z0-9]$")
          .required()
          .validate(createTemplateRequest.getName())
      )
      .aggregate();
  }
}
