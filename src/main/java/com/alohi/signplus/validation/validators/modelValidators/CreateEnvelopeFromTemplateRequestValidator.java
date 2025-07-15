package com.alohi.signplus.validation.validators.modelValidators;

import com.alohi.signplus.models.CreateEnvelopeFromTemplateRequest;
import com.alohi.signplus.validation.Violation;
import com.alohi.signplus.validation.ViolationAggregator;
import com.alohi.signplus.validation.validators.StringValidator;

public class CreateEnvelopeFromTemplateRequestValidator
  extends AbstractModelValidator<CreateEnvelopeFromTemplateRequest> {

  public CreateEnvelopeFromTemplateRequestValidator(String fieldName) {
    super(fieldName);
  }

  public CreateEnvelopeFromTemplateRequestValidator() {}

  @Override
  protected Violation[] validateModel(CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest) {
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
